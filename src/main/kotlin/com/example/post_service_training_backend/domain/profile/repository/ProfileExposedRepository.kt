package com.example.post_service_training_backend.domain.profile.repository

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity
import com.example.post_service_training_backend.exposed_model.Users
import org.jetbrains.exposed.sql.*
import org.springframework.stereotype.Repository

@Repository
class ProfileExposedRepository: ProfileRepository{

    override fun save(profile: ProfileEntity): ProfileEntity? {
        Users.update ({ Users.id eq profile.userId }) {
            it[name] = profile.name
            it[accountId] = profile.accountId
            it[statusComment] = profile.statusComment
            it[iconUrl] = profile.iconUrl
            it[backGroundImageUrl] = profile.backGroundImageUrl
        }

        return findById(profile.userId)
    }

    override fun findById(userId: Int): ProfileEntity?{
        return Users.select { Users.id eq userId }
                    .firstOrNull()
                    ?.rowToEntity()
    }

    private fun ResultRow.rowToEntity(): ProfileEntity =
        ProfileEntity(
            this[Users.id].value,
            this[Users.name],
            this[Users.accountId],
            this[Users.statusComment],
            this[Users.iconUrl],
            this[Users.backGroundImageUrl],
        )
}