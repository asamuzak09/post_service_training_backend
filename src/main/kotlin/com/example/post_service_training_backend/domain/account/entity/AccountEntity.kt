package com.example.post_service_training_backend.domain.account.entity

class AccountEntity(
    val userId: Int?,
    val name: String,
    val accountId: String,
    val encryptPassword: String
    ){
}