package ir.postex.pos.data.source.local

import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey

object DataStoreConstants {

    const val DATASTORE_NAME = "default_datastore"
    val ACCESS_TOKEN = stringPreferencesKey(name = "access_token")
    val IS_SIGNED_IN = booleanPreferencesKey(name = "sign_in_state")
}