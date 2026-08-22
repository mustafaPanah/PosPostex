package ir.postex.pos.data.repositories

import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.data.source.remote.Services
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.data.source.remote.network.SafeApiRequest
import ir.postex.pos.domain.model.enroll.EnrollRequest
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.poslogin.LoginRequest
import ir.postex.pos.domain.model.poslogin.RefreshTokenRequest
import ir.postex.pos.domain.model.poslogin.RefreshTokenResponse
import ir.postex.pos.domain.repositories.AuthRepository
import ir.postex.pos.utils.WITHOUT_TOKEN_ANNOTATION
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Named

class AuthRepositoryImpl @Inject constructor(
    @Named(WITHOUT_TOKEN_ANNOTATION)
    private val service: Services
): AuthRepository, SafeApiRequest() {

    override suspend fun login(userName: String, password: String): Flow<Resource<LoginResponse>> =
        apiRequest {
            service.login(LoginRequest( userName,password,"android_pos",""))
        }

    override suspend fun refreshToken(token: String): Flow<Resource<RefreshTokenResponse>> =
        apiRequest {
            service.refreshToken(RefreshTokenRequest( token))
        }

    override suspend fun enroll(publicKey: String,terminalId:Int,merchantId:Int,masterKey:String,serial:String): Flow<Resource<EnrollResponse>> =
        apiRequest {
            service.enroll(EnrollRequest(serial,terminalId,merchantId,publicKey,masterKey))
        }

}