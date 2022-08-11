package com.example.post_service_training_backend.response

import com.example.post_service_training_backend.domain.account.entity.AccountEntity

data class AccountResponse(
    val userId: Int?,
    val name: String?,
    val accountId: String?,
    ) {
    constructor(accountEntity: AccountEntity?) : this(accountEntity?.userId, accountEntity?.name, accountEntity?.accountId)
}
