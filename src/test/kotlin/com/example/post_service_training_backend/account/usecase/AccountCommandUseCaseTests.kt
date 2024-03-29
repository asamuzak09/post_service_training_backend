package com.example.post_service_training_backend.account.usecase

import com.example.post_service_training_backend.domain.account.entity.AccountEntity
import com.example.post_service_training_backend.domain.account.usecase.AccountCommandUseCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class AccountCommandUseCaseTests {
    @Autowired
    lateinit var accountCommandUseCase: AccountCommandUseCase

    @Transactional
    @Test
    fun create() {
        val accountEntity = AccountEntity(
            null,
            "name",
            "asamuzak",
            "encryptPasswordExample"
        )
        val userAccountDomain = accountCommandUseCase.create(accountEntity)
        assertThat(userAccountDomain?.accountId).isEqualTo("asamuzak")
    }

}
