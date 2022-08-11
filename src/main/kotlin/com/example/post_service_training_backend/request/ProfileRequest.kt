package com.example.post_service_training_backend.request

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity

class ProfileRegisterRequest(
    val userId: String,
    val name: String,
    val accountId: String,
    val statusComment: String?,
    val iconImageUrl: String?,
    val backGroundImageUrl: String?,
){
    fun toProfileEntity(): ProfileEntity{
        return ProfileEntity(
            Integer.parseInt(userId),
            name,
            accountId,
            statusComment,
            iconImageUrl,
            backGroundImageUrl
        )
    }
}
