package com.br.gook.port.output

import com.br.gook.data.input.NotificationInputPort

interface FirebaseNotificationServiceOutput {

    fun sendPush(notificationInputPort: NotificationInputPort)

}
