package com.rosen.strido.presentation

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rosen.strido.R
import com.rosen.strido.ui.components.Shoe
import com.rosen.strido.ui.components.getDrawableResourceId
import com.rosen.strido.ui.theme.Black
import com.rosen.strido.ui.theme.IvoryWhite
import com.rosen.strido.ui.theme.OrangeBrown
import com.rosen.strido.ui.theme.Peach
import com.rosen.strido.ui.theme.Periwinkle
import com.rosen.strido.ui.theme.StridoTheme
import com.rosen.strido.ui.theme.Tangerine
import com.rosen.strido.ui.theme.TextBlack
import com.rosen.strido.ui.theme.TransparentOrange
import com.rosen.strido.ui.theme.Vermilion
import com.rosen.strido.ui.theme.White
import kotlin.random.Random

@Composable
fun ProductDetails(productId: String?) {
    var isFavorite by remember { mutableStateOf(false) }

    Column(
        Modifier.fillMaxSize()
    ) {
        ProductDetails()
    }
}

@Composable
fun ProductNavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.home_default
                    ),
                    contentDescription = null
                )
            }
        }

        Box(
            modifier = Modifier
                .size(40.dp)
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(
                        id = R.drawable.shopping_bag_default
                    ),
                    contentDescription = null,
                )
            }
        }
    }
}

@Composable
fun ProductDetails() {
    var isFavorite by remember { mutableStateOf(false) }

    val shoe = getRandomShoe()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            Column {
                ProductNavBar()

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            text = shoe.name,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = Black,
                                fontSize = 40.sp
                            ),
                        )

                        Text(
                            text = "Best Selling Brand",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Medium,
                                color = TextBlack,
                                fontSize = 18.sp
                            ),
                        )
                    }
                }
            }
        }

        Box (
            modifier = Modifier
                .weight(2f)
                .padding(top = 16.dp)
                .fillMaxHeight()
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(
                        color = Black,
                        shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 100.dp)
                        .fillMaxSize(),
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = shoe.name,
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = White,
                                fontSize = 24.sp
                            ),
                        )

                        Box(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable(
                                    interactionSource = remember { MutableInteractionSource() },
                                    indication = rememberRipple(bounded = false),
                                    onClick = { isFavorite = !isFavorite }
                                )
                                .background(TransparentOrange, shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = if (isFavorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                                contentDescription = null,
                                tint = if (isFavorite) OrangeBrown else Black,
                                modifier = Modifier.size(20.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "SNEAKERS 2023 EDITION",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 12.sp,
                            color = IvoryWhite
                        )
                    )

                    Spacer(modifier = Modifier.size(8.dp))

                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                                "Sed do eiusmod tempor incididunt ut labore magna aliqua.",
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontSize = 12.sp,
                            color = IvoryWhite
                        )
                    )

                    Spacer(modifier = Modifier.size(30.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Text(
                            text = "Select Color:",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Normal,
                                color = White,
                                fontSize = 16.sp
                            ),
                        )

                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(12.dp)
                                .background(White, shape = RoundedCornerShape(8.dp))
                        )

                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(12.dp)
                                .background(Peach, shape = RoundedCornerShape(8.dp))
                        )

                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(12.dp)
                                .background(Periwinkle, shape = RoundedCornerShape(8.dp))
                        )

                        Box(
                            modifier = Modifier
                                .width(34.dp)
                                .height(12.dp)
                                .background(Vermilion, shape = RoundedCornerShape(8.dp))
                        )

                    }

                    Spacer(modifier = Modifier.size(30.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = "$${shoe.price}",
                            style = MaterialTheme.typography.bodyLarge.copy(
                                fontWeight = FontWeight.Bold,
                                color = Tangerine,
                                fontSize = 24.sp
                            ),
                        )

                        Spacer(modifier = Modifier.height(20.dp))

                        Button(
                            onClick = { /* Handle button click */ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 8.dp),
                            colors = ButtonDefaults.buttonColors(
                                contentColor = Black,
                                containerColor = White
                            )
                        ) {
                            Text(
                                text = "ADD TO CART",
                                style = MaterialTheme.typography.bodyLarge.copy(
                                    fontWeight = FontWeight.Bold,
                                    color = Black,
                                    fontSize = 24.sp
                                ),
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .offset(0.dp, (-200).dp),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.shoe14),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                        .padding(horizontal = 16.dp)
                        .align(Alignment.Center)
                )
            }
        }
    }
}

private fun getRandomShoe(): Shoe {
    val index = Random.nextInt(1, 15)
    return Shoe(
        id = System.currentTimeMillis().toString(),
        name = listOf(
            "Nike",
            "Adidas",
            "Vans",
            "Converse",
            "Clarks",
            "Puma",
            "New Balance",
            "Timberland",
            "Sperry",
            "Skechers"
        ).shuffled().random(),
        price = (234 + index).toDouble(), // Generate random prices
        imageResId = getDrawableResourceId("shoe$index")
    )
}

@Preview(showBackground = true)
@Composable
fun ProductDetailsPreview() {
    StridoTheme {
        ProductDetails("")
    }
}