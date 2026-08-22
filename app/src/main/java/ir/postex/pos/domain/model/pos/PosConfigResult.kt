package ir.postex.pos.domain.model.pos

import ir.postex.pos.domain.model.enroll.EnrollResponse

data class PosConfigResult(
    val enrollResponse: EnrollResponse?,
    val settingsResponse: PosSettingsResponse?,
    val errorMessage: String? = null
)