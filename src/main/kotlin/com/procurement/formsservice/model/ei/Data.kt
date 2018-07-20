package com.procurement.formsservice.model.ei

class Data(
    val parameters: Parameters,
    val uris: Uris
)

data class Parameters(
    val country: String,
    val registrationScheme: String
)

data class Uris(
    val cpv: String,
    val country: String,
    val region: String,
    val locality: String,
    val registrationScheme: String
)