package com.rosen.strido.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rosen.strido.R
import com.rosen.strido.ui.components.FeaturedProducts
import com.rosen.strido.ui.components.NewCollections
import com.rosen.strido.ui.components.SearchTextField
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.strido.ui.theme.White

@Composable
fun HomeScreen(navController: NavController) {

    var textValue by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = White)
            .padding(vertical = 10.dp)
    ) {

        // Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                painter = painterResource(id = R.drawable.kamalaharris),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
            )

            Icon(
                painter = painterResource(id = R.drawable.shopping_bag_default),
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )

        }

        // Search bar
        Spacer(modifier = Modifier.height(10.dp))
        SearchTextField(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            value = textValue,
            onValueChange = { textValue = it }
        )


        // Featured products
        Spacer(modifier = Modifier.height(10.dp))
        FeaturedProducts(navController)


        // New collections
        Spacer(modifier = Modifier.height(10.dp))
        NewCollections()

    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    StridoTheme {
        val navController = rememberNavController()
        HomeScreen(navController)
    }
}