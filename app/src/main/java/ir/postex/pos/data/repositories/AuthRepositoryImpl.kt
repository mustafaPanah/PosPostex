package ir.postex.pos.data.repositories

import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.data.source.remote.Services
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.data.source.remote.network.SafeApiRequest
import ir.postex.pos.domain.model.poslogin.LoginRequest
import ir.postex.pos.domain.repositories.AuthRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val service: Services
): AuthRepository, SafeApiRequest() {

    override suspend fun login(userName: String, password: String): Flow<Resource<LoginResponse>> =
        apiRequest {
            service.login(LoginRequest( userName,password,"android_pos",""))
        }

}