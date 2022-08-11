package com.example.post_service_training_backend.domain.profile.entity

class ProfileEntity(
    val userId: Int,
    val name: String,
    val accountId: String,
    val statusComment: String?,
    val iconUrl: String?,
    val backGroundImageUrl: String?,
    ){
}