package com.example.post_service_training_backend.response

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity

data class ProfileResponse(
    val userId: Int?,
    val name: String?,
    val accountId: String?,
    val statusComment: String?,
    val iconUrl: String?,
    val backGroundImageUrl: String?,
    ){

    constructor(profileEntity: ProfileEntity?) : this(
        profileEntity?.userId,
        profileEntity?.name,
        profileEntity?.accountId,
        profileEntity?.statusComment,
        profileEntity?.iconUrl,
        profileEntity?.backGroundImageUrl,
    )
}