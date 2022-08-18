package com.puzzle.industries.budgetplan.previewProviders.models

import com.puzzle.industries.budgetplan.components.ActionButton

data class TopHeaderModel(
    val Title: String,
    val SubTitle: String,
    val IsHomeEnabled: Boolean,
    val actions: List<ActionButton> = emptyList()
)
