package com.example.post_service_training_backend.domain.profile.usecase

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity
import com.example.post_service_training_backend.domain.profile.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ProfileReadUseCase {
    @Autowired
    lateinit var profileRepository: ProfileRepository

    fun find(userId: Int): ProfileEntity? {
        return profileRepository.findById(userId)
    }
}