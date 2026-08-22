package ir.postex.pos.security

import android.util.Base64
import java.security.KeyFactory
import java.security.KeyPair
import java.security.KeyPairGenerator
import java.security.PrivateKey
import java.security.PublicKey
import java.security.Signature
import java.security.spec.PKCS8EncodedKeySpec
import java.security.spec.X509EncodedKeySpec

object Ed25519KeyManager {
    fun generateKeyPair(): KeyPair {
        val kpg = KeyPairGenerator.getInstance("Ed25519", "BC")
        return kpg.generateKeyPair()
    }

    fun publicKeyToBase64(publicKey: PublicKey): String =
        Base64.encodeToString(publicKey.encoded, Base64.NO_WRAP)

    fun sign(data: ByteArray, privateKey: PrivateKey): String {
        val signature = Signature.getInstance("Ed25519", "BC")
        signature.initSign(privateKey)
        signature.update(data)
        return Base64.encodeToString(signature.sign(), Base64.NO_WRAP)
    }

    fun loadPublicKey(keyBytes: ByteArray): PublicKey {
        val spec = X509EncodedKeySpec(keyBytes)
        return KeyFactory.getInstance("Ed25519", "BC").generatePublic(spec)
    }

    fun loadPrivateKey(keyBytes: ByteArray): PrivateKey {
        val spec = PKCS8EncodedKeySpec(keyBytes)
        return KeyFactory.getInstance("Ed25519", "BC").generatePrivate(spec)
    }
}