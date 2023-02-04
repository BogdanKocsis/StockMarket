package com.pdmpa.stockmarketapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.pdmpa.stockmarketapp.ui.theme.Typography
import com.pdmpa.stockmarketapp.ui.theme.md_theme_light_onBackground


@Composable
fun CommonTopBar(
    modifier: Modifier = Modifier,
    title: String
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 24.dp)
    ) {
        androidx.compose.material3.Text(
            text = title,
            fontWeight = FontWeight.Bold,
            style = Typography.h6,
            color = md_theme_light_onBackground,
            modifier = modifier
        )
    }
}