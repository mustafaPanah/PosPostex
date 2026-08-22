package ir.postex.pos.security

import android.content.Context
import android.util.Base64

import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

import java.security.KeyPair



class PrivateKeyStorage(context: Context) {

    private val masterKey = MasterKey.Builder(context)
        .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
        .build()

    private val prefs = EncryptedSharedPreferences.create(
        context,
        "crypto_prefs",
        masterKey,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveKeyPair(keyPair: KeyPair) {
        prefs.edit().apply {
            putString("ed25519_private", Base64.encodeToString(keyPair.private.encoded, Base64.NO_WRAP))
            putString("ed25519_public", Base64.encodeToString(keyPair.public.encoded, Base64.NO_WRAP))
            apply()
        }
    }

    fun loadKeyPair(): KeyPair? {
        val privateBase64 = prefs.getString("ed25519_private", null) ?: return null
        val publicBase64 = prefs.getString("ed25519_public", null) ?: return null

        val privateKey = Ed25519KeyManager.loadPrivateKey(Base64.decode(privateBase64, Base64.NO_WRAP))
        val publicKey = Ed25519KeyManager.loadPublicKey(Base64.decode(publicBase64, Base64.NO_WRAP))
        return KeyPair(publicKey, privateKey)
    }
}
