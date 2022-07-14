package com.example.post_service_training_backend.row_mapper

import com.example.post_service_training_backend.domain_model.UserAccountDomainModel
import org.springframework.jdbc.core.RowMapper
import java.sql.ResultSet

class UserAccountRowMapper : RowMapper<UserAccountDomainModel> {
    override fun mapRow(rs: ResultSet, rowNum: Int): UserAccountDomainModel {
        return UserAccountDomainModel(
                rs.getString("account_id"),
                rs.getInt("id"),
        )
    }
}
