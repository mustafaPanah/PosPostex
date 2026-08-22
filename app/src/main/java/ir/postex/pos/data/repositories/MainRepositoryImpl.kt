package ir.postex.pos.data.repositories


import com.persianswitch.smartpos.webservice.LoginResponse
import ir.postex.pos.data.source.local.DataStoreConstants.ACCESS_TOKEN
import ir.postex.pos.data.source.local.DataStoreConstants.SERIAL
import ir.postex.pos.data.source.local.DataStoreConstants.USER_ID
import ir.postex.pos.data.source.local.DataStoreConstants.USER_ID_NET
import ir.postex.pos.data.source.local.DataStoreManager
import ir.postex.pos.data.source.remote.network.MainServices
import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.data.source.remote.network.SafeApiRequest
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.poslogin.LoginRequest
import ir.postex.pos.domain.model.report.DailyReportItem
import ir.postex.pos.domain.model.report.DailyReportResponse
import ir.postex.pos.domain.model.report.TransactionsItem
import ir.postex.pos.domain.model.report.TransactionsResponse
import ir.postex.pos.domain.model.shipment.ShipmentPayRequest
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.model.topup.TopUpResponse
import ir.postex.pos.domain.repositories.MainRepository
import ir.postex.pos.presentation.main.navigation.BottomNavItem.HomeScreen.id
import ir.postex.pos.utils.WITH_TOKEN_ANNOTATION
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.runBlocking
import javax.inject.Inject
import javax.inject.Named
import kotlin.math.sign

class MainRepositoryImpl @Inject constructor(
    @Named(WITH_TOKEN_ANNOTATION)
    private val mServices: MainServices,
    private val dataStoreManager: DataStoreManager,
) : MainRepository, SafeApiRequest() {


    override suspend fun getBalance(
    ): Flow<Resource<BalanceResponse>> =
        apiRequest {
            mServices.getBalance()
        }

    override suspend fun getDailyReport(
    ): Flow<Resource<List<DailyReportItem>>> =
        apiRequest {
            mServices.getDailyReport()
        }

    override suspend fun topUp(request: TopUpRequest,sign:String): Flow<Resource<TopUpResponse>> =
        apiRequest {
            val serial = runBlocking {
                dataStoreManager.getData(SERIAL).firstOrNull()
            }
            mServices.topUp(dataStoreManager.getData(SERIAL).first().toString(),dataStoreManager.getData(USER_ID_NET).first().toString(),sign,request)
          //  mServices.topUp(dataStoreManager.getData(SERIAL).first().toString(),"b427ec3c-a66e-4d8c-b752-6396def3c9c9",sign,request)
        }

    override suspend fun getAmount(id:String): Flow<Resource<InquiryResponse>> =
        apiRequest {
            mServices.getAmount(dataStoreManager.getData(SERIAL).first().toString(),id)
        }

    override suspend fun postShipmentPay(parcelNo:String,request: ShipmentPayRequest): Flow<Resource<EnrollResponse>> =
        apiRequest {
            mServices.postShipmentPay(parcelNo,request)
        }

    override suspend fun getTransactions(fromDate:String,toDate:String
    ): Flow<Resource<List<TransactionsItem>>> =
        apiRequest {
            mServices.getTransactions(fromDate,toDate)
        }

}