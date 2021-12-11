package com.br.gook.port.output

interface FirebaseNotificationServiceOutput {

    fun sendPush(tokenSendPush: String)

}
