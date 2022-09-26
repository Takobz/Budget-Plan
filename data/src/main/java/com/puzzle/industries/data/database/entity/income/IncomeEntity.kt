package com.puzzle.industries.data.database.entity.income

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.puzzle.industries.data.database.constants.Entities
import com.puzzle.industries.domain.constants.FrequencyType
import java.util.*

@Entity(tableName = Entities.INCOME)
internal data class IncomeEntity(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    val frequencyType: FrequencyType,
    val frequencyWhen: String,
    val amount: Double,
    val title: String,
    val description: String,
    val lastModifyDate: Date = Date()
)