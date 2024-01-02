package com.rosen.strido.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.rosen.strido.R
import com.rosen.strido.ui.theme.BabyBlue
import com.rosen.strido.ui.theme.Black
import com.rosen.strido.ui.theme.BlushPink
import com.rosen.strido.ui.theme.SilverGray
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.strido.ui.theme.Tangerine
import com.rosen.strido.ui.theme.TextBlack
import com.rosen.strido.ui.theme.White
import kotlin.math.pow
import kotlin.math.roundToLong

@Composable
fun FeaturedProducts(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {

        Text(
            text = "Featured",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            ),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        ShoeBrands()
        Spacer(modifier = Modifier.height(8.dp))

        Shoes(navController = navController)
    }

}

@Composable
fun Shoes(navController: NavController) {
    val shoes = listOf(
        "Prism Pumps",
        "Timberland ",
        "Nike",
        "Adidas",
        "Reebok",
        "Fila",
        "ASICS",
        "Vans",
        "Converse",
        "Clarks",
        "Puma",
        "New Balance",
        "Timberland",
        "Sperry",
        "Skechers"
    )
    val products = (1..15).map {
        Shoe(
            id = it.toString(),
            name = shoes[it - 1],
            price = (120.0 + it).roundTo(2), // Generate random prices
            imageResId = getDrawableResourceId("shoe$it")
        )
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp)
    ) {
        itemsIndexed(products) { _, shoe ->
            ShoeItem(shoe = shoe, navController = navController)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoeItem(shoe: Shoe, navController: NavController) {
    var isFavorite by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .width(280.dp)
            .height(300.dp)
            .padding(end = 24.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (shoe.id.toInt() % 2 == 0) BlushPink else BabyBlue
        ),
        shape = RoundedCornerShape(24.dp),
        onClick = {
            navController.navigate("productDetails/${shoe.id}")
        }
    ) {

        Column {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(3f),
                contentAlignment = Alignment.TopEnd
            ) {
                Image(
                    painter = painterResource(id = shoe.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Inside,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                )

                Box(
                    modifier = Modifier
                        .size(30.dp)
                        .offset((-12).dp, (12).dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = false),
                            onClick = { isFavorite = !isFavorite }
                        )
                        .background(Tangerine, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f),
                contentAlignment = Alignment.Center
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = shoe.name,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Black,
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold
                        ),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(
                        text = "$${shoe.price}",
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Tangerine,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        ),
                    )
                    Spacer(modifier = Modifier.height(4.dp))

                    Button(
                        onClick = { /* Handle button click */ },
                        colors = ButtonDefaults.buttonColors(
                            contentColor = White,
                            containerColor = Black
                        )
                    ) {
                        Text(text = "ADD TO CART")
                    }
                }
            }

        }

    }
}

data class Shoe(
    val id: String,
    val name: String,
    val price: Double,
    val imageResId: Int
)

private fun Double.roundTo(decimals: Int): Double {
    val factor = 10.0.pow(decimals.toDouble())
    return (this * factor).roundToLong() / factor
}

fun getDrawableResourceId(name: String): Int {
    return try {
        R.drawable::class.java.getField(name).getInt(null)
    } catch (e: Exception) {
        R.drawable.ic_launcher_foreground // Placeholder drawable ID
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoeBrands() {
    val products = listOf("Pumpies", "Sneakers", "Joggers", "Trainers", "Adidas")

    var selectedItem by remember {
        mutableStateOf(products[0])
    }

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 10.dp)
    ) {
        itemsIndexed(products) { _, product ->
            FilterChip(
                modifier = Modifier
                    .padding(horizontal = 6.dp),
                selected = (product == selectedItem),
                onClick = {
                    selectedItem = product
                },
                label = {
                    Text(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        text = product,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            fontWeight = FontWeight.Medium,
                            fontSize = 20.sp
                        ),
                    )
                },
                colors = FilterChipDefaults.filterChipColors(
                    containerColor = SilverGray,
                    selectedContainerColor = Black,
                    selectedLabelColor = White,
                    labelColor = TextBlack
                ),
                shape = RoundedCornerShape(16.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeaturedProductsPreview() {
    StridoTheme {
        val navController = rememberNavController()
        FeaturedProducts(navController)
    }
}