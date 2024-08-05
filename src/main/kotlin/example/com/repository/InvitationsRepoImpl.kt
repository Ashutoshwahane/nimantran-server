package example.com.repository

import example.com.entities.InvitationCard
import example.com.entities.createMockInvitationCards

class InvitationsRepoImpl: InvitationsRepo {

    private val invitations = mutableListOf<InvitationCard>()

    override fun getInvitations(): List<InvitationCard> {
        return invitations
    }

    override fun getInvitation(id: Int): InvitationCard? {
        return createMockInvitationCards().firstOrNull{
            id == it.id
        }
    }

    override fun createInvitation(card: InvitationCard): InvitationCard {
        val invitationCard = InvitationCard(
            id = invitations.size + 1,
            brideName = card.brideName,
            invitationEvents = card.invitationEvents,
            bridegroomName = card.bridegroomName,
            bridegroomFamily = card.bridegroomFamily,
            brideFamily = card.brideFamily,
        )
        invitations.add(invitationCard)

        return invitationCard
    }

    override fun updateInvitation(id: Int, card: InvitationCard): Boolean {
        invitations.removeIf { id == it.id }
        invitations.add(card)
        return true
    }

    override fun removeInvitation(id: Int): Boolean {
        return invitations.removeIf { id == it.id }
    }
}