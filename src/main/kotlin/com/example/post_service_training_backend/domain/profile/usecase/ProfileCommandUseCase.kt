package com.example.post_service_training_backend.domain.profile.usecase

import com.example.post_service_training_backend.domain.profile.entity.ProfileEntity
import com.example.post_service_training_backend.domain.profile.repository.ProfileRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class ProfileCommandUseCase {
    @Autowired
    lateinit var profileRepository: ProfileRepository

    fun register(profileEntity: ProfileEntity): ProfileEntity? {
        return profileRepository.save(profileEntity)
    }
}