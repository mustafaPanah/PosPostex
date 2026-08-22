package ir.postex.pos.domain.repositories

import ir.postex.pos.data.source.remote.network.Resource
import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.report.DailyReportItem
import ir.postex.pos.domain.model.report.DailyReportResponse
import ir.postex.pos.domain.model.report.TransactionsItem
import ir.postex.pos.domain.model.shipment.ShipmentPayRequest
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.model.topup.TopUpResponse
import kotlinx.coroutines.flow.Flow


interface MainRepository {

    suspend fun getBalance(
    ): Flow<Resource<BalanceResponse>>
    suspend fun getDailyReport(
    ): Flow<Resource<List<DailyReportItem>>>

    suspend fun topUp(request: TopUpRequest,sign:String):Flow<Resource<TopUpResponse>>
    suspend fun getAmount(id:String):Flow<Resource<InquiryResponse>>
    suspend fun getTransactions(fromDate:String,toDate:String):Flow<Resource<List<TransactionsItem>>>
    suspend fun postShipmentPay(parcelNo:String,request: ShipmentPayRequest):Flow<Resource<EnrollResponse>>

}