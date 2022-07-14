package com.example.post_service_training_backend.controller

import com.example.post_service_training_backend.logic.UserAccountCommandLogic
import com.example.post_service_training_backend.request.AccountCreateRequest
import com.example.post_service_training_backend.response.UserAccountResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserAccountController {
    @Autowired
    lateinit var userAccountCommandLogic: UserAccountCommandLogic

    @PostMapping("/account/create")
    fun createAccount(@RequestBody request: AccountCreateRequest): UserAccountResponse {
        val userAccountDomain = userAccountCommandLogic.create(request.accountId, request.encryptPassword)

        return UserAccountResponse(userAccountDomain)
    }
}

