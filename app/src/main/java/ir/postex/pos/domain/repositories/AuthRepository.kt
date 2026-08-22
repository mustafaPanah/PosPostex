package ir.postex.pos.domain.repositories

import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.poslogin.RefreshTokenResponse
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(userName: String,password:String): Flow<Resource<LoginResponse>>
    suspend fun refreshToken(token: String): Flow<Resource<RefreshTokenResponse>>

    suspend fun enroll(publicKey: String,terminalId:Int,merchantId:Int,masterKey:String,serial:String):Flow<Resource<EnrollResponse>>
}