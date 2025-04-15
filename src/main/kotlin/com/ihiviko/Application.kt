package com.ihiviko

import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.plugins.calllogging.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.Serializable

//config our server engine o nuestro motor de servidor
fun main(args: Array<String>):Unit = io.ktor.server.netty.EngineMain.main(args)

//declararemos todo lo necesario para nuestro servidor de backend
@Suppress("unused")
fun Application.module(){
    install(CallLogging)
    install(ContentNegotiation){
        json()
    }
//llamare una funcion de enrutamiento
    routing {
        //nuestro servidor respondera a una solicitud get
        get("/") {
            call.respondText("Bienvenid@")//nuestro servidor respondera con este simple texto
        }
        get("/users/{username}") {
            val username = call.parameters["username"]
            val header = call.request.headers["Connection"]
            if (username =="Admin"){
                call.response.header(name = "CustomHeader","Admin")
                call.respond(message= "Hello Admin", status= HttpStatusCode.OK)
            }
            call.respondText("Saludos,$username !!! , with header:$header")//nuestro servidor respondera con este simple texto
        }
        get("/user") {
            val name = call.request.queryParameters["name"]
            val age = call.request.queryParameters["age"]

            call.respondText("Hola,my nombre es $name , tengo $age años ")//nuestro servidor respondera con este simple texto
        }
        //como enviar un obj datos personalizado como respuesta desde un servidor
        //1 creamos dataclass

        get("/person"){
            try {
                val person = Person(name = "Jeremy", age = 28)
                call.respond(message= person, status = HttpStatusCode.OK)
        }catch (e:Exception){
            call.respond(message = "${e.message}", status = HttpStatusCode.BadRequest)
        }
//redirigir al usuario a una pagina diferente
            get("/redirect") {
                call.respondRedirect(url= "/moved", permanent = false)
            }
            get("/moved") {
                call.respondText("tu has sido rederigido con exito ")
            }
        }
    }
}
@Serializable
data class Person(
    val name: String,
    val age: Int
)