package com.example.post_service_training_backend.request

data class AccountCreateRequest(val name: String, val accountId: String, val encryptPassword: String)
data class AccountSignInRequest(val accountId: String, val encryptPassword: String)
