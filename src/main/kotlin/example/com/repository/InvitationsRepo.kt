package example.com.repository

import example.com.entities.InvitationCard

interface InvitationsRepo {
    fun getInvitations(): List<InvitationCard>
    fun getInvitation(id: Int): InvitationCard?
    fun createInvitation(card: InvitationCard): InvitationCard
    fun updateInvitation(id: Int, card: InvitationCard): Boolean
    fun removeInvitation(id: Int): Boolean
}