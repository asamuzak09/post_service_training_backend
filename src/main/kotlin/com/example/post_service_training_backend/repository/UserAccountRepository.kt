package com.example.post_service_training_backend.repository

import com.example.post_service_training_backend.domain_model.UserAccountDomainModel
import com.example.post_service_training_backend.row_mapper.UserAccountRowMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class UserAccountRepository {
    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    fun create(accountId: String, encryptPassword: String): UserAccountDomainModel? {
        val insertSql = "INSERT INTO users(account_id, encrypt_password) VALUES (?, ?);"
        jdbcTemplate.update(insertSql, accountId, encryptPassword)

        val readSql = ("SELECT * FROM users WHERE account_id = ?")

        return jdbcTemplate.queryForObject(readSql, UserAccountRowMapper(), accountId)
    }
}