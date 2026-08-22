package ir.postex.pos.presentation.increaseBalanceScreen

import android.util.Base64
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.squareup.moshi.Moshi
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.postex.pos.data.source.local.DataStoreConstants.DEVICE_ID
import ir.postex.pos.data.source.local.DataStoreConstants.MERCHANT_ID
import ir.postex.pos.data.source.local.DataStoreConstants.TERMINAL_ID
import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.model.topup.TopUpResponse
import ir.postex.pos.domain.repositories.MainRepository
import ir.postex.pos.presentation.main.PosResultBus.result
import ir.postex.pos.security.Ed25519KeyManager
import ir.postex.pos.security.PrivateKeyStorage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import timber.log.Timber
import java.nio.charset.StandardCharsets
import java.security.MessageDigest
import java.security.PrivateKey
import java.security.Signature
import javax.inject.Inject

@HiltViewModel
class IncreaseBalanceViewModel @Inject constructor(
    private val repository: MainRepository,
    private val dataStoreManager: DataStoreManager,
    private val moshi: Moshi,
    private val privateKeyStorage: PrivateKeyStorage
) : ViewModel() {
    var isLoading by mutableStateOf(false)
        private set

    private var _stateGetBalance = MutableStateFlow<Resource<BalanceResponse>?>(null)
    val stateteGetBalance: StateFlow<Resource<BalanceResponse>?> = _stateGetBalance

    private var _stateTopUp = MutableStateFlow<Resource<TopUpResponse>?>(null)
    val stateTopUp: StateFlow<Resource<TopUpResponse>?> = _stateTopUp

    init {
        viewModelScope.launch {
            dataStoreManager.updateData(TERMINAL_ID, "12345")

            // جمع‌آوری مقادیر Flow
            dataStoreManager.getData(DEVICE_ID).collect { deviceId ->
                Timber.tag("aaaaa").e("DEVICE_ID: $deviceId")
            }

            dataStoreManager.getData(MERCHANT_ID).collect { merchantId ->
                Timber.tag("aaaaa").e("MERCHANT_ID: $merchantId")
            }

            dataStoreManager.getData(TERMINAL_ID).collect { terminalId ->
                Timber.tag("aaaaa").e("TERMINAL_ID: $terminalId")
            }
        }
        Timber.tag("SHA").e(sha256FromBytes("hello".toByteArray()))

        val method = "post"
        val path = "/api/payment"
        val body = "hello".toByteArray(StandardCharsets.UTF_8)


        val result = buildCanonicalRequest(
            method,
            path,
            body
        )


        val canonical = String(
            result,
            StandardCharsets.UTF_8
        )


        println(canonical)

        println()
        println("Canonical SHA256:")
        println(sha256Hex(canonical))


        getBalance()
    }

    fun getBalance() = viewModelScope.launch {

        repository.getBalance().collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    _stateGetBalance.value = result

                }

                is Resource.Error -> {
                    _stateGetBalance.value = result
                }

                is Resource.Loading -> {
                    _stateGetBalance.value = result
                }
            }
        }
    }

    fun topUP(request: TopUpRequest) = viewModelScope.launch {
        val keyPair = privateKeyStorage.loadKeyPair()
            ?: Ed25519KeyManager.generateKeyPair().also {
                privateKeyStorage.saveKeyPair(it)
            }

        val adapter = moshi.adapter(TopUpRequest::class.java)
        val bodyJson = adapter.toJson(request)

        Timber.e("MOSHI JSON = $bodyJson")
        val cleanedJson = bodyJson.replace(Regex("\\s"), "")

        //  val canonical = buildCanonicalRequest(bodyJson)
        //  Timber.tag("CCCCCCCCC2").e(canonical)
        val publicKeyBase64 = Base64.encodeToString(keyPair.public.encoded, Base64.NO_WRAP)
     //   Timber.tag("PUBLIC_KEY").e("Public Key: $publicKeyBase64")

        // یا به صورت Hex
        val publicKeyHex = keyPair.public.encoded.joinToString("") { "%02x".format(it) }
      //  Timber.tag("PUBLIC_KEY_HEX").e("Public Key Hex: $publicKeyHex")


        val method = "post"
        val path = "/api/payment"
        // val body = "hello".toByteArray(StandardCharsets.UTF_8)
        val body = cleanedJson.toByteArray(StandardCharsets.UTF_8)


        val canonicalResult = buildCanonicalRequest(
            method,
            path,
            body
        )


        val canonical = String(
            canonicalResult,
            StandardCharsets.UTF_8
        )


        val signature = signCanonical(canonical, keyPair.private)

        Timber.tag("cleanedJson :").e("cleanedJson :" + cleanedJson)
        Timber.tag("canonical :").e("canonical :" + canonical)
        Timber.tag("Canonical SHA256:").e("Canonical SHA256:" + sha256Hex(canonical))
        Timber.tag("signature:").e("signature:" + signature)
        Timber.e(request.toString())
        repository.topUp(request, signature).collectLatest { result ->
            when (result) {
                is Resource.Success -> {
                    _stateTopUp.value = result

                }

                is Resource.Error -> {
                    _stateTopUp.value = result
                }

                is Resource.Loading -> {
                    _stateTopUp.value = result
                }
            }
        }
    }

//    private fun sha256Hex2(data: ByteArray): String {
//        val digest = MessageDigest.getInstance("SHA-256")
//        val hash = digest.digest(data)
//        return hash.joinToString("") { "%02x".format(it) }
//    }
////sha256FromBytes
//    fun sha256Hex222(bytes: ByteArray): String {
//        return try {
//            val digest = MessageDigest.getInstance("SHA-256")
//            val hash = digest.digest(bytes)
//            val hex = StringBuilder()
//            for (b in hash) {
//                hex.append(String.format("%02x", b))
//            }
//            hex.toString()
//        } catch (e: Exception) {
//            throw RuntimeException("SHA-256 failed", e)
//        }
//    }
//
//    private fun buildCanonicalRequest222(bodyJson: String): String {
//        val bodyBytes = bodyJson.toByteArray(Charsets.UTF_8)
//        val bodyHash = sha256Hex(bodyBytes)
//
//        return """
//        METHOD:POST
//        PATH:/api/app/v1/pos/top-up
//        QUERY:
//        BODY_HASH:$bodyHash
//    """.trimIndent()
//    }
//
//    private fun buildCanonicalRequest(bodyJson: String): String {
//        val bodyBytes = bodyJson.toByteArray(Charsets.UTF_8)
//        val bodyHash = sha256Hex(bodyBytes)
//
//        return bodyHash
////        "METHOD:POST\n" +
////                "PATH:/pos-service/api/app/v1/pos/top-up\n" +
////                "QUERY:\n" +
////                "BODY_HASH:$
//
//    }

    private fun signCanonical(canonical: String, privateKey: PrivateKey): String {
        val signature = Signature.getInstance("Ed25519", "BC")
        signature.initSign(privateKey)
        signature.update(canonical.toByteArray(Charsets.UTF_8))
        return Base64.encodeToString(signature.sign(), Base64.NO_WRAP)
    }

//    fun sha256FromBytes(bytes: ByteArray?): String {
//        try {
//            val digest = MessageDigest.getInstance("SHA-256")
//            val hash = digest.digest(bytes)
//            val hex = java.lang.StringBuilder()
//            for (b in hash) {
//                hex.append(String.format("%02x", b))
//            }
//            return hex.toString()
//        } catch (e: java.lang.Exception) {
//            throw java.lang.RuntimeException("SHA-256 failed", e)
//        }
//    }

    ////////////////////////new fun
    fun sha256FromBytes(bytes: ByteArray): String {
        val digest = MessageDigest.getInstance("SHA-256")

        val hash = digest.digest(bytes)

        return hash.joinToString("") {
            "%02x".format(it)
        }
    }

    fun buildCanonicalRequest(
        method: String,
        path: String,
        rawBody: ByteArray?
    ): ByteArray {

        val bodyHash = sha256FromBytes(
            rawBody ?: ByteArray(0)
        )

        val canonical =
        //  "METHOD:${method.uppercase()}\n" +
        //         "PATH:$path\n" +
            //         "BODY_HASH:$bodyHash"
            bodyHash
        return canonical.toByteArray(StandardCharsets.UTF_8)
    }


    fun sha256Hex(input: String): String {
        return sha256FromBytes(
            input.toByteArray(StandardCharsets.UTF_8)
        )
    }
}