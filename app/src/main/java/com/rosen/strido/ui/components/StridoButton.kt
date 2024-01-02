package com.rosen.strido.ui.components

import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.rosen.strido.ui.theme.Black
import com.rosen.strido.ui.theme.CoffeeBrown

@Composable
fun TimeCraftButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    contentColor: Color = Black,
    containerColor: Color = CoffeeBrown,
    cornerRadius: Dp = 8.dp
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = contentColor,
            containerColor = containerColor
        ),
        shape = RoundedCornerShape(corner = CornerSize(cornerRadius))
    ) {
        Text(text = text)
    }
}