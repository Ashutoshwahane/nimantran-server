package example.com.entities

import kotlinx.serialization.Serializable

@Serializable
data class InvitationCard(
    val id: Int?,
    val bridegroomName: String,
    val brideName: String,
    val invitationEvents: List<InvitationEvent>,
    val brideFamily: FamilyDetails,
    val bridegroomFamily: FamilyDetails,
)

@Serializable
data class InvitationEvent(
    val eventType: Events,
    val eventDate: String,
    val eventTime: String,
    val eventAddress: String,
)

@Serializable
data class FamilyDetails(
    val fatherName: String,
    val motherName: String,
)

enum class Events(val rawValue: String){
    HALDI("HALDI"),
    MAHEDI("MAHEDI"),
    SANGEET("SANGEET"),
    SHAADI("SHAADI"),
    BIDAI("BIDAI"),
    RECEPTION("RECEPTION")
}


fun createMockInvitationCards(): List<InvitationCard> {
    val invitationEvents1 = listOf(
        InvitationEvent(Events.HALDI, "2024-08-01", "10:00 AM", "Venue A"),
        InvitationEvent(Events.MAHEDI, "2024-08-02", "11:00 AM", "Venue B"),
        InvitationEvent(Events.SANGEET, "2024-08-03", "07:00 PM", "Venue C"),
        InvitationEvent(Events.SHAADI, "2024-08-04", "05:00 PM", "Venue D"),
        InvitationEvent(Events.BIDAI, "2024-08-05", "11:00 AM", "Venue E"),
        InvitationEvent(Events.RECEPTION, "2024-08-06", "08:00 PM", "Venue F")
    )

    val invitationEvents2 = listOf(
        InvitationEvent(Events.HALDI, "2024-09-01", "09:00 AM", "Venue G"),
        InvitationEvent(Events.MAHEDI, "2024-09-02", "10:00 AM", "Venue H"),
        InvitationEvent(Events.SANGEET, "2024-09-03", "06:00 PM", "Venue I"),
        InvitationEvent(Events.SHAADI, "2024-09-04", "04:00 PM", "Venue J"),
        InvitationEvent(Events.BIDAI, "2024-09-05", "10:00 AM", "Venue K"),
        InvitationEvent(Events.RECEPTION, "2024-09-06", "07:00 PM", "Venue L")
    )

    val familyDetails1 = FamilyDetails("Father A", "Mother A")
    val familyDetails2 = FamilyDetails("Father B", "Mother B")

    val invitationCard1 = InvitationCard(1, "John Doe", "Jane Smith", invitationEvents1, familyDetails1, familyDetails1)
    val invitationCard2 = InvitationCard(2, "Mike Johnson", "Emily Davis", invitationEvents2, familyDetails2, familyDetails2)

    return listOf(invitationCard1, invitationCard2)
}

