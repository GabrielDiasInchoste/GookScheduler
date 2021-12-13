package com.br.gook.notification.firebase.notification.dto

data class FirebasePushNotificationInput(
    val to: String,
    val notification: NotificationDTO
)

data class NotificationDTO(
    val title: String,
    val body: String
)

const val TOKEN = "key=AAAAB4l0jEE:APA91bE6at5qpKjMqckXZYxu9pjhqKyeNyHFWE1jLZbBOlwSA1_QUhBMA_kyLYzmKQjL4j795vC6JccfzF9u3rbTjg8COtxEUJSwBr7UQiFnQPdE6jh5z-d2ur5Eg-rnfLlwO3v3MV21"