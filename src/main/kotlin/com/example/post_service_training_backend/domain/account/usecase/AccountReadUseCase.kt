package com.example.post_service_training_backend.domain.account.usecase

import com.example.post_service_training_backend.domain.account.entity.AccountEntity
import com.example.post_service_training_backend.domain.account.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class AccountReadUseCase {
    @Autowired
    lateinit var accountRepository: AccountRepository

    fun validateSignIn(accountId: String, encryptPassword: String): AccountEntity? {
        try {
            return accountRepository.findByAccountIdAndPassword(accountId, encryptPassword) ?: throw Error("認証失敗")
        } catch (e: Exception) {
            throw Error("認証失敗")
        }

    }
}