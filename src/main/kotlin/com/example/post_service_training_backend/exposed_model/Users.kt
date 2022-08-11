package com.example.post_service_training_backend.exposed_model

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Users : IntIdTable("users") {
    val name: Column<String> = varchar("name", 50)
    val accountId: Column<String> = varchar("account_id", 50).uniqueIndex()
    val encryptPassword: Column<String> = varchar("encrypt_password", 100)
    val statusComment: Column<String?> = varchar("status_comment", 50).nullable()
    val iconUrl: Column<String?> = varchar("icon_image_url", 100).nullable()
    val backGroundImageUrl: Column<String?> = varchar("back_ground_image_url", 100).nullable()
}