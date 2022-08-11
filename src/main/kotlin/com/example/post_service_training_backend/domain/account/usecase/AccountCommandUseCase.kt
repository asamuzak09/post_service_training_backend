package com.example.post_service_training_backend.domain.account.usecase

import com.example.post_service_training_backend.domain.account.entity.AccountEntity
import com.example.post_service_training_backend.domain.account.repository.AccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class AccountCommandUseCase {
    @Autowired
    lateinit var accountRepository: AccountRepository

    fun create(accountEntity: AccountEntity): AccountEntity? {
        return accountRepository.create(accountEntity)
    }
}