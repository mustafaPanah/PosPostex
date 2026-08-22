package ir.postex.pos.domain.model.shipment

data class ShipmentPayRequest(
    val amount: Int,
    val stan: String,
    val rrn: String,
    val lat: Long,
    val lon: Long,
)
