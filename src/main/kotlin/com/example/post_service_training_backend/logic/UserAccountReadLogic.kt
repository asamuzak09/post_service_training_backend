package com.example.post_service_training_backend.logic

import com.example.post_service_training_backend.domain_model.UserAccountDomainModel
import com.example.post_service_training_backend.repository.UserAccountRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserAccountReadLogic {
    @Autowired
    lateinit var userAccountRepository: UserAccountRepository

    fun validateSignIn(accountId: String, encryptPassword: String): UserAccountDomainModel? {
        try {
            return userAccountRepository.validateSignIn(accountId, encryptPassword)
        }catch (e: Exception){
            throw Error("認証失敗")
        }

    }
}