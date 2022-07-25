package com.example.post_service_training_backend.controller

import com.example.post_service_training_backend.logic.UserAccountCommandLogic
import com.example.post_service_training_backend.logic.UserAccountReadLogic
import com.example.post_service_training_backend.request.UserAccountCreateRequest
import com.example.post_service_training_backend.request.UserAccountSignInRequest
import com.example.post_service_training_backend.response.UserAccountResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class UserAccountController {
    @Autowired
    lateinit var userAccountCommandLogic: UserAccountCommandLogic
    @Autowired
    lateinit var userAccountReadLogic: UserAccountReadLogic

    @PostMapping("/account/create")
    fun createAccount(@RequestBody request: UserAccountCreateRequest): UserAccountResponse {
        val userAccountDomain = userAccountCommandLogic.create(request.name, request.accountId, request.encryptPassword)

        return UserAccountResponse(userAccountDomain)
    }

    @PostMapping("/account/sign_in")
    fun signIn(@RequestBody request: UserAccountSignInRequest): UserAccountResponse {
        val userAccountDomain = userAccountReadLogic.validateSignIn(request.accountId, request.encryptPassword)

        return UserAccountResponse(userAccountDomain)
    }
}

