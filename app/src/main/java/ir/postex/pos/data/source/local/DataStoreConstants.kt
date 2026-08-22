package ir.postex.pos.data.source.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DataStoreConstants {

    const val DATASTORE_NAME = "default_datastore"
    val ACCESS_TOKEN = stringPreferencesKey(name = "access_token")
    val IS_SIGNED_IN = booleanPreferencesKey(name = "sign_in_state")
    val TERMINAL_ID = stringPreferencesKey(name = "terminal_id")
    val MERCHANT_ID = stringPreferencesKey(name = "merchant_id")
    val IS_DEVICE_CONFIGURED = booleanPreferencesKey(name = "is_device_configured")
    val DEVICE_ID = stringPreferencesKey(name = "device_id")
    val USER_ID = stringPreferencesKey(name = "user_id")
    val USER_ID_NET = stringPreferencesKey(name = "user_id_net")
    val SERIAL = stringPreferencesKey(name = "serial")
    val REFRESH_TOKEN = stringPreferencesKey(name = "REFRESH_TOKEN")

}