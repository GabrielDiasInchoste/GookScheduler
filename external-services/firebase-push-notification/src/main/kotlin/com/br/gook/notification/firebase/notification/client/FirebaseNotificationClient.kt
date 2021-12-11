package com.br.gook.notification.firebase.notification.client

import com.br.gook.notification.firebase.notification.dto.FirebasePushNotificationInput
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@FeignClient(
    name = "FirebaseNotificationClient",
    url = "\${firebase.push.notification.host}"
)
interface FirebaseNotificationClient {

    @PostMapping(
        path = ["\${firebase.push.notification.url}"],
        consumes = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun sendPush(
        @RequestHeader("Authorization") token: String,
        @RequestBody firebasePushNotificationInput: FirebasePushNotificationInput
    )

}