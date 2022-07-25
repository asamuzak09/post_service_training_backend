package com.example.post_service_training_backend.request

data class UserAccountCreateRequest(val name: String, val accountId: String, val encryptPassword: String)
data class UserAccountSignInRequest(val accountId: String, val encryptPassword: String)
