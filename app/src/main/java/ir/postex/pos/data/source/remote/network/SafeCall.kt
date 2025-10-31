package ir.postex.pos.data.source.remote.network

import ir.postex.pos.domain.model.NetworkError
import ir.postex.pos.domain.model.ResourceE
import kotlinx.serialization.SerializationException
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException
import java.net.SocketTimeoutException


suspend inline fun <reified T> safeCall(
    execute: () -> Response<T>
): ResourceE<T, NetworkError> {
    return try {
        val response = execute()
        responseToResult(response)
    } catch (e: HttpException) {
        ResourceE.Error(NetworkError.SERVER_ERROR)
    } catch (e: SocketTimeoutException) {
        ResourceE.Error(NetworkError.REQUEST_TIMEOUT)
    } catch (e: IOException) {
        ResourceE.Error(NetworkError.NO_INTERNET)
    } catch (e: SerializationException) {
        ResourceE.Error(NetworkError.SERIALIZATION)
    } catch (e: Exception) {
        ResourceE.Error(NetworkError.UNKNOWN)
    }
}

suspend inline fun <reified T> responseToResult(
    response: Response<T>
): ResourceE<T, NetworkError> {
    return if (response.isSuccessful) {
        response.body()?.let {
            ResourceE.Success(it)
        } ?: ResourceE.Error(NetworkError.NULL_RESPONSE)
    } else {
        when (response.code()) {
            400 -> ResourceE.Error(NetworkError.BAD_REQUEST)
            401 -> ResourceE.Error(NetworkError.UNAUTHORIZED)
            403 -> ResourceE.Error(NetworkError.FORBIDDEN)
            408 -> ResourceE.Error(NetworkError.REQUEST_TIMEOUT)
            429 -> ResourceE.Error(NetworkError.TOO_MANY_REQUESTS)
            in 500..599 -> ResourceE.Error(NetworkError.SERVER_ERROR)
            else -> ResourceE.Error(NetworkError.UNKNOWN)
        }
    }
}