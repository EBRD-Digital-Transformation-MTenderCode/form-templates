package com.procurement.formsservice.model.award

class AwardUpdateContext (
        val parameters: Parameters
) {
        data class Parameters(
                val lotId: String
        )
}