package com.example.post_service_training_backend.request

import com.example.post_service_training_backend.domain.account.entity.AccountEntity

data class AccountCreateRequest(val name: String, val accountId: String, val encryptPassword: String){
    fun toAccountEntity(): AccountEntity{
        return AccountEntity(
            null,
            name,
            accountId,
            encryptPassword
        )
    }
}
data class AccountSignInRequest(val accountId: String, val encryptPassword: String)
