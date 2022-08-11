package com.example.post_service_training_backend.domain.account.repository

import com.example.post_service_training_backend.domain.account.entity.AccountEntity
import com.example.post_service_training_backend.exposed_model.Users
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository

@Repository
class AccountRepository {

    fun create(name: String, accountId: String, encryptPassword: String): AccountEntity? {
        val id = Users.insertAndGetId {
            it[Users.name] = name
            it[Users.accountId] = accountId
            it[Users.encryptPassword] = encryptPassword
        }

        return AccountEntity(id.value, name, accountId, encryptPassword)
    }

    fun findByAccountIdAndPassword(accountId: String, encryptPassword: String): AccountEntity?{
        val accountEntity = Users.select { Users.accountId eq accountId and (Users.encryptPassword eq encryptPassword) }
            .firstOrNull()
            ?.rowToEntity()

        return accountEntity
    }

    private fun ResultRow.rowToEntity(): AccountEntity =
        AccountEntity(
            this[Users.id].value,
            this[Users.name],
            this[Users.accountId],
            this[Users.encryptPassword],
        )
}