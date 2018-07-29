package com.procurement.formsservice.model.award

class Data (
        val parameters: Parameters
)

data class Parameters(
        val awardId: String,
        val lotId: String
)