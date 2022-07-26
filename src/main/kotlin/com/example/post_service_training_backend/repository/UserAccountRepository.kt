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

    fun create(name: String, accountId: String, encryptPassword: String): UserAccountDomainModel? {
        val insertSql = "INSERT INTO users(name, account_id, encrypt_password) VALUES (?, ?, ?);"
        jdbcTemplate.update(insertSql, name, accountId, encryptPassword)

        val readSql = ("SELECT * FROM users WHERE account_id = ?")

        return jdbcTemplate.queryForObject(readSql, UserAccountRowMapper(), accountId)
    }

    fun validateSignIn(accountId: String, encryptPassword: String): UserAccountDomainModel?{
        val readSql = ("SELECT * FROM users WHERE account_id = ? AND encrypt_password = ?")

        return jdbcTemplate.queryForObject(readSql, UserAccountRowMapper(), accountId, encryptPassword)
    }
}