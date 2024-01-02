package com.rosen.strido.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rosen.strido.ui.theme.StridoTheme

@Composable
fun ShoppingCartScreen(
    contentPadding: PaddingValues = PaddingValues()
) {

}

@Preview(showBackground = true)
@Composable
fun ShoppingCartScreenPreview() {
    StridoTheme {
        ShoppingCartScreen()
    }
}