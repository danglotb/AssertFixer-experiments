package com.sikza.socksapi.controllers

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.sikza.socksapi.models.Message
import com.sikza.socksapi.services.IMessageService
import org.springframework.messaging.simp.SimpMessageSendingOperations
import org.springframework.util.Assert
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api")
class MessageController(private val messageService: IMessageService, private val messageSendingTemplate: SimpMessageSendingOperations) {

    @PostMapping("/message")
    fun notify(@RequestBody requestBody: String): String {
        var message = ObjectMapper().readValue(requestBody,Message::class.java)
         messageService.route(message)
        return requestBody
    }

    @PostMapping("/messages/recent")
    fun getRecentMessages(@RequestBody email: String): Collection<Message> {
        return messageService.getRecentMessage(email)
    }

    @PostMapping("/conversation")
    fun getConversation(@RequestBody participants: String): MutableList<Message> {
        Assert.hasLength(participants.trim(), "Request body cannot be empty")
        var participantsEmail = Gson().fromJson(participants, ArrayList::class.java)
        Assert.isTrue(participantsEmail.size == 2, "One or more than two emails are not supported")
        return messageService.getConversation(participantsEmail[0] as String, participantsEmail[1] as String)
    }
}
