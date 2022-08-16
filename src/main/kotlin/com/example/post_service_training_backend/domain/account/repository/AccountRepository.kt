package com.example.post_service_training_backend.domain.account.repository

import com.example.post_service_training_backend.domain.account.entity.AccountEntity

interface AccountRepository {
    fun create(accountEntity: AccountEntity): AccountEntity?
    fun findByAccountIdAndPassword(accountId: String, encryptPassword: String): AccountEntity?
}