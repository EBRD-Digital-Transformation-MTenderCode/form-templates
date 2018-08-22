package com.procurement.formsservice.model.bid

class BidUpdateContext (
    val parameters: Parameters,
    val tenderers: List<Tenderer>,
    val documents: List<Document>,
    val uris: Uris,
    val amount: Amount?
) {
    data class Parameters(
        val ocid: String, // ocds-t1s2t3-MD-1532010121824-EV-1532010122650
        val lotId: String, // 1a8e2f80-8b5f-11e8-a48b-9f2980d5bbdd
        val bidId: String // 325dd0d0-a143-11e8-98ce-5302331a5eb3
    )

    data class Tenderer(
        val name: String, // CN.parties[parties.id=bid.tenderers[0].id].name
        val address: Address,
        val identifier: Identifier,
        val additionalIdentifiers: List<AdditionalIdentifier>?,
        val contactPoint: ContactPoint
    ) {
        data class Address(
            val country: Country,
            val region: Region,
            val locality: Locality,
            val streetAddress: String, // CN.parties[parties.id=bid.tenderers[0].id].address.streetAddress
            val postalCode: String? // CN.parties[parties.id=bid.tenderers[0].id].address.postalCode
        ) {
            data class Country(
                val id: String, // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.country.id
                val description: String // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.country.description
            )

            data class Region(
                val id: String, // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.region.id
                val description: String // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.region.description
            )

            data class Locality(
                val scheme: String, // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.locality.scheme
                val id: String, // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.locality.id
                val description: String // CN.parties[parties.id=bid.tenderers[0].id].address.addressDetails.locality.description
            )
        }

        data class Identifier(
            val scheme: String, // CN.parties[parties.id=bid.tenderers[0].id].identifier.scheme
            val id: String, // CN.parties[parties.id=bid.tenderers[0].id].identifier.id
            val legalName: String, // CN.parties[parties.id=bid.tenderers[0].id].identifier.legalName
            val uri: String? // CN.parties[parties.id=bid.tenderers[0].id].identifier.uri
        )

        data class AdditionalIdentifier(
            val scheme: String, // CN.parties[parties.id=bid.tenderers[0].id].additionalIdentifier[i].scheme
            val id: String, // CN.parties[parties.id=bid.tenderers[0].id].additionalIdentifier[i].id
            val legalName: String, // CN.parties[parties.id=bid.tenderers[0].id].additionalIdentifier[i].legalName
            val uri: String? // CN.parties[parties.id=bid.tenderers[0].id].additionalIdentifier[i].uri
        )

        data class ContactPoint(
            val name: String, // CN.parties[parties.id=bid.tenderers[0].id].contactPoint.name
            val url: String, // CN.parties[parties.id=bid.tenderers[0].id].contactPoint.url
            val telephone: String, // CN.parties[parties.id=bid.tenderers[0].id].contactPoint.telephone
            val email: String, // CN.parties[parties.id=bid.tenderers[0].id].contactPoint.email
            val faxNumber: String? // CN.parties[parties.id=bid.tenderers[0].id].contactPoint.faxNumber
        )
    }

    data class Document(
        val id: String, // CN.bids[id=bidId].documents[i].id
        val type: String, // CN.bids[id=bidId].documents[i].documentType
        val title: String?, // CN.bids[id=bidId].documents[i].title
        val description: String, // CN.bids[id=bidId].documents[i].description
        val relatedLots: List<String> // CCN.bids[id=bidId].documents[i].relatedLots
    )

    data class Uris(
        val country: String, // /country?lang=langFromRequest
        val region: String, // /region?lang=langFromRequest&country=$country$
        val locality: String, // /locality?lang=langFromRequest&country=$country$&region=$region$
        val registrationScheme: String, // /registration-scheme?lang=langFromRequest&country=$country$
        val currency: String // /currency?lang=langFromRequest&country=(ocds-t1s2t3->MD<-1532010121824-EV-1532010122650)
    )

    data class Amount(
        val amount: Double, // CN.bids[id=bidId].value.amount
        val currency: String, // CN.bids[id=bidId].value.currency
        val maxAmount: Double // for current lotId CN.tender.lots[id].value.amount
    )
}