package com.procurement.formsservice.model.enquiry

class Data (
    val parameters: Parameters,
    val uris: Uris
)

data class Parameters(
    val lotId: String?
)

data class Uris(
    val country: String, // /country?lang=langFromRequest
    val region: String, // /region?lang=langFromRequest&country=
    val locality: String, // /locality?lang=langFromRequest&region=
    val registrationScheme: String // /registration-scheme?lang=langFromRequest&country=
)