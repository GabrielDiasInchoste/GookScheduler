package com.br.gook.notification.firebase.notification

import com.br.gook.port.output.FirebaseNotificationServiceOutput
import com.br.gook.notification.firebase.notification.client.FirebaseNotificationClient
import com.br.gook.notification.firebase.notification.dto.FirebasePushNotificationInput
import com.br.gook.notification.firebase.notification.dto.NotificationDTO
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestHeader

@Service
class FirebaseNotificationServiceImpl(
    val firebaseNotificationClient: FirebaseNotificationClient,
) : FirebaseNotificationServiceOutput {

    private val log = LoggerFactory.getLogger(javaClass)

    override fun sendPush(tokenSendPush: String) {
        try {
            log.info("FirebaseNotificationServiceImpl.sendPush - Start - tokenSendPush : $tokenSendPush")
            firebaseNotificationClient.sendPush(
                token = "key=AAAAB4l0jEE:APA91bE6at5qpKjMqckXZYxu9pjhqKyeNyHFWE1jLZbBOlwSA1_QUhBMA_kyLYzmKQjL4j795vC6JccfzF9u3rbTjg8COtxEUJSwBr7UQiFnQPdE6jh5z-d2ur5Eg-rnfLlwO3v3MV21",
                FirebasePushNotificationInput(
                    to = tokenSendPush,
                    NotificationDTO(
                        title = "title",
                        body = "body"
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