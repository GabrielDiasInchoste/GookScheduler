package com.br.gook.notification.firebase.notification.dto

data class FirebasePushNotificationInput(
    val to: String,
    val notification: NotificationDTO
)

data class NotificationDTO(
    val title: String,
    val body: String
)