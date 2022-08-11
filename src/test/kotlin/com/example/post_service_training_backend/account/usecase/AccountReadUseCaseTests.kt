package com.example.post_service_training_backend.account.usecase

import com.example.post_service_training_backend.domain.account.usecase.AccountReadUseCase
import com.example.post_service_training_backend.exposed_model.Users
import org.assertj.core.api.Assertions.assertThat
import org.jetbrains.exposed.sql.insert
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class AccountReadUseCaseTests {
    @Autowired
    lateinit var accountReadUseCase: AccountReadUseCase

    @Transactional
    @Test
    fun successValidateSignIn() {
        Users.insert {
            it[name] = "name"
            it[accountId] = "accountId"
            it[encryptPassword] = "encryptPassword"
        }

        val userAccountDomain = accountReadUseCase.validateSignIn("accountId", "encryptPassword")
        assertThat(userAccountDomain?.accountId).isEqualTo("accountId")
    }

    @Transactional
    @Test
    fun failedValidateSignIn() {
        Users.insert {
            it[name] = "name"
            it[accountId] = "accountId"
            it[encryptPassword] = "encryptPassword"
        }


        val error = assertThrows<Error> {
            accountReadUseCase.validateSignIn("accountId", "wrongEncryptPassword")
        }
        assertThat(error.message).isEqualTo("認証失敗")
    }

}
