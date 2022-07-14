package com.example.post_service_training_backend.logic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserAccountCommandLogicTests {
    @Autowired
    lateinit var userAccountCommandLogic: UserAccountCommandLogic

    @Transactional
    @Test
    fun create() {
        val accountId = "asamuzak"
        val userAccountDomain = userAccountCommandLogic.create(accountId, "encryptPasswordExample")
        assertThat(userAccountDomain?.accountId).isEqualTo(accountId)
    }

}
