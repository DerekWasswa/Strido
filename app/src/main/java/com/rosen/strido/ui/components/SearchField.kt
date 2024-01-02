package com.rosen.strido.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rosen.strido.R
import com.rosen.strido.ui.theme.SilverGray
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.strido.ui.theme.TextBlack

@Composable
fun SearchTextField(
    modifier: Modifier,
    value: String,
    onValueChange: (String) -> Unit
) {
    var isHintDisplayed by remember { mutableStateOf(value.isEmpty()) }

    TextField(
        value = value,
        onValueChange = {
            onValueChange(it)
            isHintDisplayed = it.isEmpty()
        },
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(SilverGray),
        textStyle = LocalTextStyle.current.copy(color = TextBlack),
        placeholder = {
            if (isHintDisplayed) {
                Text(
                    text = "Search Shoes here",
                    color = TextBlack,
                    fontWeight = FontWeight.Medium
                )
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null, modifier = Modifier.size(24.dp))
        },
        trailingIcon = {
            Icon(painter = painterResource(id = R.drawable.filter), contentDescription = null, modifier = Modifier.size(24.dp))
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            focusedContainerColor = SilverGray,
            unfocusedContainerColor = SilverGray
        )
    )
}

@Preview
@Composable
fun SearchTextFieldPreview() {
    StridoTheme {
        var textValue by remember { mutableStateOf("") }
        SearchTextField(modifier = Modifier, value = textValue, onValueChange = { textValue = it })
    }
}