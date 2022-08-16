package com.example.post_service_training_backend.controller

import com.example.post_service_training_backend.domain.profile.usecase.ProfileCommandUseCase
import com.example.post_service_training_backend.domain.profile.usecase.ProfileQueryUseCase
import com.example.post_service_training_backend.request.ProfileRegisterRequest
import com.example.post_service_training_backend.response.ProfileResponse
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class ProfileController {
    @Autowired
    lateinit var profileCommandUseCase: ProfileCommandUseCase
    @Autowired
    lateinit var profileQueryUseCase: ProfileQueryUseCase

    @PutMapping("/profile")
    fun registerProfile(@RequestBody request: ProfileRegisterRequest): ProfileResponse {
        val profileEntity = profileCommandUseCase.register(request.toProfileEntity())

        return ProfileResponse(profileEntity)
    }

    @GetMapping("/profile/{id}")
    fun getProfile(@PathVariable id: String): ProfileResponse {
        val profileEntity = profileQueryUseCase.find(Integer.parseInt(id))

        return ProfileResponse(profileEntity)
    }
}

