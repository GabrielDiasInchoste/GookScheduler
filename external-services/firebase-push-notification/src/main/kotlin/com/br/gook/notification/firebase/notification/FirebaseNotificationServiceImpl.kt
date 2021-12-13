package com.br.gook.notification.firebase.notification

import com.br.gook.data.input.NotificationInputPort
import com.br.gook.port.output.FirebaseNotificationServiceOutput
import com.br.gook.notification.firebase.notification.client.FirebaseNotificationClient
import com.br.gook.notification.firebase.notification.dto.FirebasePushNotificationInput
import com.br.gook.notification.firebase.notification.dto.NotificationDTO
import com.br.gook.notification.firebase.notification.dto.TOKEN
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestHeader

@Service
class FirebaseNotificationServiceImpl(
    val firebaseNotificationClient: FirebaseNotificationClient,
) : FirebaseNotificationServiceOutput {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun sendPush(notificationInputPort: NotificationInputPort) {
        try {
            log.info("FirebaseNotificationServiceImpl.sendPush - Start - notificationInputPort : $notificationInputPort")
            firebaseNotificationClient.sendPush(
                token = TOKEN,
                FirebasePushNotificationInput(
                    to = notificationInputPort.tokenSendPush,
                    NotificationDTO(
                        title = notificationInputPort.title,
                        body = notificationInputPort.body
                    )
                )
            )
            log.info("FirebaseNotificationServiceImpl.sendPush - End -")
        } catch (ex: Exception) {
            log.error("FirebaseNotificationServiceImpl.sendPush - Error to Send Push - Error : ${ex.message}", ex)
            throw ex
        }
    }
}