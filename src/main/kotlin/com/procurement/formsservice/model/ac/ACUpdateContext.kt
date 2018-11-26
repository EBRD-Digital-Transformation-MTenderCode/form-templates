package com.procurement.formsservice.model.ac

class ACUpdateContext (
    val parameters: Parameters,
    val buyer: Buyer,
    val supplier: Supplier
) {
    data class Parameters (
        val ocid: String, // ocds-t1s2t3-MD-1532010121824-AC-1532010122650
        val lotId: String // 1a8e2f80-8b5f-11e8-a48b-9f2980d5bbdd
    )

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
}

