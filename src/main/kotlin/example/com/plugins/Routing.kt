package example.com.plugins

import example.com.entities.InvitationCard
import example.com.repository.InvitationsRepo
import example.com.repository.InvitationsRepoImpl
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val invitationRepo: InvitationsRepo = InvitationsRepoImpl()

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/invitations") {
            call.respond(invitationRepo.getInvitations())
        }

        get("/invitations/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()

            if (id == null) {
                call.respond(status = HttpStatusCode.BadRequest, message = "ID parameter is null!")
                return@get
            }

            val invitation = invitationRepo.getInvitation(id)
            invitation?.let {
                call.respond(it)
            } ?: call.respond(status = HttpStatusCode.NotFound, message = "Invitation Not found!")
        }



        post("/invitation") {
            val invitation = call.receive<InvitationCard>()
            call.respond(invitationRepo.createInvitation(invitation))
        }


        put("/invitations/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            val invitation = call.receive<InvitationCard>()
            if (id == null){
                call.respond(status = HttpStatusCode.BadRequest, "ID is null!")
                return@put
            }
            val updateInvitation = invitationRepo.updateInvitation(id = id, card = invitation)
            if (updateInvitation){
                call.respond(HttpStatusCode.OK)
            }else{
                call.respond(HttpStatusCode.NotFound, "No data found!")
            }


        }

        delete("/invitations/{id}") {
            val id = call.parameters["id"]?.toIntOrNull()
            if (id == null){
                call.respond(status = HttpStatusCode.BadRequest, "ID is null!")
                return@delete
            }
            val removeInvitation = invitationRepo.removeInvitation(id = id)
            if (removeInvitation){
                call.respond(HttpStatusCode.OK)
            }else{
                call.respond(HttpStatusCode.NotFound, "No data found!")
            }

        }
    }
}
