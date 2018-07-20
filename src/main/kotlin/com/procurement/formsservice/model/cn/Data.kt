package com.procurement.formsservice.model.cn

class Data(
    val parameters: Parameters,
    val uris: Uris,
    val buyer: Buyer,
    val budget: Budget
)

data class Parameters(
    val procuringEntity: String,
    val responsibleContactPerson: String,
    val pmd: String
)

data class Uris(
    val country: String,
    val region: String,
    val locality: String,
    val registrationScheme: String,
    val currency: String,
    val unitClass: String,
    val unit: String,
    val cpv: String,
    val cpvs: String,
    val pmd: String
)

data class Buyer(
    val name: String,
    val address: Address,
    val identifier: Identifier,
    val additionalIdentifiers: List<AdditionalIdentifier>,
    val contactPoint: ContactPoint
) {
    data class Address(
        val country: Country,
        val region: Region,
        val locality: Locality,
        val streetAddress: String, // EI.parties[0].address.streetAddress
        val postalCode: String // EI.parties[0].address.postalCode
    ) {
        data class Country(
            val id: String, // EI.parties[0].address.addressDetails.country.id
            val description: String // EI.parties[0].address.addressDetails.country.description
        )

        data class Region(
            val id: String, // EI.parties[0].address.addressDetails.region.id
            val description: String // EI.parties[0].address.addressDetails.region.description
        )

        data class Locality(
            val scheme: String, // EI.parties[0].address.addressDetails.locality.scheme
            val id: String, // EI.parties[0].address.addressDetails.locality.id
            val description: String // EI.parties[0].address.addressDetails.locality.description
        )
    }

    data class Identifier(
        val scheme: String, // EI.parties[0].identifier.scheme
        val id: String, // EI.parties[0].identifier.id
        val legalName: String, // EI.parties[0].identifier.legalName
        val uri: String // EI.parties[0].identifier.uri
    )

    data class AdditionalIdentifier(
        val scheme: String, // EI.parties[0].identifier.scheme
        val id: String, // EI.parties[0].identifier.id
        val legalName: String, // EI.parties[0].identifier.legalName
        val uri: String // EI.parties[0].identifier.uri
    )

    data class ContactPoint(
        val name: String, // EI.parties[0].contactPoint.name
        val url: String, // EI.parties[0].contactPoint.url
        val telephone: String, // EI.parties[0].contactPoint.telephone
        val email: String, // EI.parties[0].contactPoint.email
        val faxNumber: String // EI.parties[0].contactPoint.faxNumber
    )
}

data class Budget(
    val amount: Amount // EI.planning.budget.amount
) {
    data class Amount(
        val currency: String // EI.planning.budget.amount.currency
    )
}