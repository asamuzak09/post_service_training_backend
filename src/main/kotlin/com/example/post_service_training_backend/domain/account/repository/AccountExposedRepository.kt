package com.example.post_service_training_backend.domain.account.repository

import com.example.post_service_training_backend.domain.account.entity.AccountEntity
import com.example.post_service_training_backend.exposed_model.Users
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository

@Repository
class AccountExposedRepository: AccountRepository {

    override fun create(accountEntity: AccountEntity): AccountEntity? {
        val id = Users.insertAndGetId {
            it[name] = accountEntity.name
            it[accountId] = accountEntity.accountId
            it[encryptPassword] = accountEntity.encryptPassword
        }

        return AccountEntity(id.value, accountEntity.name, accountEntity.accountId, accountEntity.encryptPassword)
    }

    override fun findByAccountIdAndPassword(accountId: String, encryptPassword: String): AccountEntity?{
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