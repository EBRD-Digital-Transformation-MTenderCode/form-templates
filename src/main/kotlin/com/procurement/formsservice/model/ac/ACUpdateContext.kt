package com.procurement.formsservice.model.ac

class ACUpdateContext (
    val parameters: Parameters,
    val lotId: String, // AC.awards[0].relatedLots[0]
    val contract: Contract,
    val buyer: Buyer,
    val supplier: Supplier,
    val itemUris: ItemUris,
    val currency: String // AC.planning.budget.budgetSource[0].currency
) {
    data class Parameters (
        val ocid: String // ocds-t1s2t3-MD-1532010121824-AC-1532010122650
    )

    data class Contract(
        val title: String?, // AC.contracts[0].title
        val description: String?, // AC.contracts[0].description
        val period: Period,
        val documents: List<Document>? // AC.contracts[0].documents
    ) {
        data class Period(
            val startDate: String?, // AC.contracts[0].period.startDate
            val endDate: String? // AC.contracts[0].period.endDate
        )

        data class Document(
            val id: String, // AC.contracts[0].documents[*].id
            val type: String, // AC.contracts[0].documents[*].documentType
            val title: String?, // AC.contracts[0].documents[*].title
            val description: String?, // AC.contracts[0].documents[*].description
            val relatedLot: String, // AC.contracts[0].documents[*].relatedLots[0]
            val confirmationRequest: ConfirmationRequest? // AC.contracts[0].confirmationRequests
        ) {
            data class ConfirmationRequest(
                val id: String, // AC.contracts[0].confirmationRequests[relatedItem==document.id].id
                val relatedItem: String, // AC.contracts[0].confirmationRequests[relatedItem==document.id].relatedItem
                val source: String // AC.contracts[0].confirmationRequests[relatedItem==document.id].source
            )
        }
    }

    data class Buyer (
        val uris: Uris,
        val bankAccountUris: BankAccountUris
    ) {
        data class Uris (
            val country: String, // /country/AC.parties[role=="buyer"].address.addressDetails.country.id?lang=langFromRequest
            val region: String, // /region?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id
            val locality: String, // /locality?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id&region=AC.parties[role=="buyer"].address.addressDetails.region.id
            val registrationScheme: String  // /registration-scheme?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id
        )

        data class BankAccountUris (
            val country: String, // /country/AC.parties[role=="buyer"].address.addressDetails.country.id?lang=langFromRequest
            val region: String, // /region?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id
            val locality: String, // /locality?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id&region=$region$
            val registrationScheme: String  // /registration-scheme?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id
        )
    }

    data class Supplier(
        val uris: Uris,
        val bankAccountUris: BankAccountUris
    ) {
        data class Uris (
            val country: String, // /country/AC.parties[role=="supplier"].address.addressDetails.country.id?lang=langFromRequest
            val region: String, // /region?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id
            val locality: String, // /locality?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id&region=AC.parties[role=="supplier"].address.addressDetails.region.id
            val registrationScheme: String  // /registration-scheme?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id
        )

        data class BankAccountUris (
            val country: String, // /country/AC.parties[role=="supplier"].address.addressDetails.country.id?lang=langFromRequest
            val region: String, // /region?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id
            val locality: String, // /locality?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id&region=$region$
            val registrationScheme: String  // /registration-scheme?lang=langFromRequest&country=AC.parties[role=="supplier"].address.addressDetails.country.id
        )
    }

    data class ItemUris(
            val country: String, // /country/AC.parties[role=="buyer"].address.addressDetails.country.id?lang=langFromRequest
            val region: String, // /region?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id
            val locality: String // /locality?lang=langFromRequest&country=AC.parties[role=="buyer"].address.addressDetails.country.id&region=$region$
    )
}

