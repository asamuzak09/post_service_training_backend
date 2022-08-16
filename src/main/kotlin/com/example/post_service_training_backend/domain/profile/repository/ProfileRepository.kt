package com.example.post_service_training_backend.domain.profile.repository

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity

interface ProfileRepository {
    fun save(profile: ProfileEntity): ProfileEntity?
    fun findById(userId: Int): ProfileEntity?
}