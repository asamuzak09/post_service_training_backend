package com.example.post_service_training_backend.response

import com.example.post_service_training_backend.domain_model.UserAccountDomainModel

data class UserAccountResponse(val accountId: String?, val userId: Int?){
    constructor(userAccountDomain: UserAccountDomainModel?) : this(userAccountDomain?.accountId, userAccountDomain?.userId)
}
