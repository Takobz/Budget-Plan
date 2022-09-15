@file:OptIn(ExperimentalMaterial3WindowSizeClassApi::class)

package com.puzzle.industries.budgetplan.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material3.*
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.puzzle.industries.budgetplan.R
import com.puzzle.industries.budgetplan.theme.BudgetPlanTheme
import com.puzzle.industries.budgetplan.theme.spacing

@Composable
fun ModifiableItemWrapper(modifier: Modifier, content: @Composable (modifier: Modifier) -> Unit) {
    val defaultMargin = MaterialTheme.spacing.medium

    ConstraintLayout(modifier = modifier) {
        val (cardConstraints, optionsConstraints) = createRefs()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(cardConstraints) {
                    linkTo(start = parent.start, end = parent.end)
                },
            content = {
                content(
                    modifier = Modifier
                        .padding(all = defaultMargin)
                )
            }
        )

        ModifyOptionsHolder(modifier = Modifier.constrainAs(optionsConstraints) {
            linkTo(top = cardConstraints.bottom, bottom = cardConstraints.bottom)
            end.linkTo(anchor = cardConstraints.end, margin = defaultMargin)
        })
    }
}

@Composable
fun TitleAndDescription(title: String, description: String = "") {
    Text(
        text = title,
        maxLines = 1,
        overflow = TextOverflow.Ellipsis,
        style = MaterialTheme.typography.titleMedium
    )

    if (description.isNotBlank()) {
        Spacer(modifier = Modifier.height(height = MaterialTheme.spacing.extraSmall))
        Text(
            text = description,
            style = MaterialTheme.typography.labelSmall,
            maxLines = 4,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Composable
fun MiniCaption(modifier: Modifier = Modifier, imageVector: ImageVector, message: String) {
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier.size(size = 12.dp),
            imageVector = imageVector,
            contentDescription = stringResource(id = R.string.desc_income_frequency),
            tint = MaterialTheme.colorScheme.secondary
        )

        Spacer(modifier = Modifier.width(width = MaterialTheme.spacing.small))

        Text(
            text = message,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
private fun ModifyOptionsHolder(
    modifier: Modifier,
    onDeleteClick: () -> Unit = {},
    onEdit: () -> Unit = {}
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondary)
    ) {
        Row(
            modifier = Modifier.padding(all = MaterialTheme.spacing.small),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.width(width = MaterialTheme.spacing.small))
            Icon(
                modifier = Modifier.clickable { onDeleteClick() },
                imageVector = Icons.Rounded.Delete,
                contentDescription = stringResource(id = R.string.desc_delete_icon),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(width = MaterialTheme.spacing.medium))
            Icon(
                modifier = Modifier.clickable { onEdit() },
                imageVector = Icons.Rounded.Edit,
                contentDescription = stringResource(id = R.string.desc_edit_icon),
                tint = Color.White
            )
            Spacer(modifier = Modifier.width(width = MaterialTheme.spacing.small))
        }
    }
}


@Preview
@Composable
private fun PreviewModifiableItemWrapper() {
    BudgetPlanTheme(dynamicColor = false) {
        ModifiableItemWrapper(modifier = Modifier.fillMaxWidth()) {
            Text(modifier = it, text = "Hello")
        }
    }
}