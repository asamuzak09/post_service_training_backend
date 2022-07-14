package com.example.post_service_training_backend.logic

import com.example.post_service_training_backend.domain_model.UserAccountDomainModel
import com.example.post_service_training_backend.repository.UserAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserAccountCommandLogic {
    @Autowired
    lateinit var userAccountRepository: UserAccountRepository

    fun create(accountId: String, encryptPassword: String): UserAccountDomainModel? {
        return userAccountRepository.create(accountId, encryptPassword)
    }
}