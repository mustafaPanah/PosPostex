package ir.postex.pos.domain.repositories

import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.data.source.remote.network.Resource
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(userName: String,password:String): Flow<Resource<LoginResponse>>
}