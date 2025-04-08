package com.ihiviko.com.ihiviko

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//config our server engine o nuestro motor de servidor
fun main(args: Array<String>):Unit = io.ktor.server.netty.EngineMain.main(args)

//declararemos todo lo necesario para nuestro servidor de backend

fun Application.module(){
//llamare una funcion de enrutamiento
    routing {
        //nuestro servidor respondera a una solicitud get
        get("/") {
            call.respondText("hello world, I'm ihiviko")
        }
    }
}