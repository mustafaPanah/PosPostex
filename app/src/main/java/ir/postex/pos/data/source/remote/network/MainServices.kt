package ir.postex.pos.data.source.remote.network

import ir.postex.pos.domain.model.balance.BalanceResponse
import ir.postex.pos.domain.model.enroll.EnrollResponse
import ir.postex.pos.domain.model.inquiry.InquiryResponse
import ir.postex.pos.domain.model.report.DailyReportItem
import ir.postex.pos.domain.model.report.DailyReportResponse
import ir.postex.pos.domain.model.report.TransactionsItem
import ir.postex.pos.domain.model.shipment.ShipmentPayRequest
import ir.postex.pos.domain.model.topup.TopUpRequest
import ir.postex.pos.domain.model.topup.TopUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query


interface MainServices {

    @GET("/api/app/v1/wallet/balance")
    suspend fun getBalance(): Response<BalanceResponse>

    @GET("/api/app/v1/pos/shipment/{id}/amount")
    suspend fun getAmount(
        @Header("x-device-serial-no") deviceSerialNo: String,
        @Path("id") requestId: String
    ): Response<InquiryResponse>

    @POST("/api/app/v1/pos/top-up")
    suspend fun topUp(
        @Header("x-device-serial-no") deviceSerialNo: String,
        @Header("x-user-id") id: String,
        @Header("x-signature") signature: String,
        @Body request: TopUpRequest
    ): Response<TopUpResponse>


    @POST("/api/app/v1/pos/shipment/{parcelNo}/pay")
    suspend fun postShipmentPay(
        @Path("parcelNo") parcelNo: String,
        @Body request: ShipmentPayRequest,

    ): Response<EnrollResponse>

    @GET("/api/app/v1/pos/report/summary/daily")
    suspend fun getDailyReport(): Response<List<DailyReportItem>>


   // @GET("/api/app/v1/pos/report/transactions?fromDate={fromDate}&toDate={toDate}")
    @GET("/api/app/v1/pos/report/transactions")
    suspend fun getTransactions(
        @Query("fromDate") fromDate: String,
        @Query("toDate") toDate: String
    ): Response<List<TransactionsItem>>
}