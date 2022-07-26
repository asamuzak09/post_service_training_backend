package com.example.post_service_training_backend.logic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class UserAccountReadLogicTests {
    @Autowired
    lateinit var userAccountReadLogic: UserAccountReadLogic
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Transactional
    @Test
    fun successValidateSignIn() {
        val insertSql = "INSERT INTO users(name, account_id, encrypt_password) VALUES (?, ?, ?);"
        jdbcTemplate.update(insertSql, "name", "accountId", "encryptPassword")

        val userAccountDomain = userAccountReadLogic.validateSignIn("accountId", "encryptPassword")
        assertThat(userAccountDomain?.accountId).isEqualTo("accountId")
    }

    @Transactional
    @Test
    fun failedValidateSignIn() {
        val insertSql = "INSERT INTO users(name, account_id, encrypt_password) VALUES (?, ?, ?);"
        jdbcTemplate.update(insertSql, "name", "accountId", "encryptPassword")

        val error = assertThrows<Error> {
            userAccountReadLogic.validateSignIn("accountId", "wrongEncryptPassword")
        }
        assertThat(error.message).isEqualTo("認証失敗")
    }

}
