package com.example.post_service_training_backend.controller

import com.example.post_service_training_backend.domain.account.usecase.AccountQueryUseCase
import com.example.post_service_training_backend.response.AccountResponse
import com.example.post_service_training_backend.domain.account.usecase.AccountCommandUseCase
import com.example.post_service_training_backend.request.AccountCreateRequest
import com.example.post_service_training_backend.request.AccountSignInRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class AccountController {
    @Autowired
    lateinit var accountCommandUseCase: AccountCommandUseCase
    @Autowired
    lateinit var accountQueryUseCase: AccountQueryUseCase

    @PostMapping("/account/create")
    fun createAccount(@RequestBody request: AccountCreateRequest): AccountResponse {
        val userAccountDomain = accountCommandUseCase.create(request.toAccountEntity())

        return AccountResponse(userAccountDomain)
    }

    @PostMapping("/account/sign_in")
    fun signIn(@RequestBody request: AccountSignInRequest): AccountResponse {
        val userAccountDomain = accountQueryUseCase.validateSignIn(request.accountId, request.encryptPassword)

        return AccountResponse(userAccountDomain)
    }
}

