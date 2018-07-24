package com.procurement.formsservice.model.bid

class Data (
    val parameters: Parameters,
    val uris: Uris,
    val amount: Amount
)

data class Parameters(
    val CNOCID: String,
    val lotId: String
)

data class Uris(
    val country: String, // /country?lang=langFromRequest
    val region: String, // /region?lang=langFromRequest&country=
    val locality: String, // /locality?lang=langFromRequest&region=
    val registrationScheme: String, // /registration-scheme?lang=langFromRequest&country=
    val currency: String // /currency?lang=langFromRequest&country=(Buyer.Address.Country.id)
)

data class Amount(
    val currency: String, // for current lotId CN.tender.lots[i].value.currency
    val maxAmount: Number // for current lotId CN.tender.lots[i].value.amount
)