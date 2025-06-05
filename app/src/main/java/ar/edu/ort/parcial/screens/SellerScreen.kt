package ar.edu.ort.parcial.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.navigation.NavRoutes.BESTSELLER
import ar.edu.ort.parcial.navigation.NavRoutes.PROFILE

@Composable
fun SellerScreen(navController: NavController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF0F0F0))
        ) {
            SellerHeaderSection(navController)
            SellerActionButtonsSection(navController)
            SellerProductsSection(navController)
        }
    }
}

@Composable
fun SellerHeaderSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFFF0F0F0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .background(Color(0xFFF0F0F0), shape = RoundedCornerShape(30.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { navController.navigate(PROFILE) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier = Modifier
                    .width(130.dp)
                    .height(36.dp)
            ) {
                Text("Profile", fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { /* Ya estás en Seller */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7140FD),
                    contentColor = Color.White

                ),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier = Modifier
                    .width(130.dp)
                    .height(36.dp)
            ) {
                Text("Seller Mode", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.fotoperfil),
                contentDescription = "Header Background Banner",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-50).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .shadow(10.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .background(Color.LightGray),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.rectangle),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(95.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Abduldul",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun SellerActionButtonsSection(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
        .padding(horizontal = 16.dp, vertical = 8.dp),
    horizontalArrangement = Arrangement.SpaceBetween,
    verticalAlignment = Alignment.CenterVertically
    ) {
        Text( text = "Best Seller",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            lineHeight = 29.sp, // 180% of 16px = 28.8px ≈ 29.sp
            letterSpacing = 0.sp,
            fontFamily = FontFamily.Default )
        /*Text(
            text = "View All",
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 19.sp,
            letterSpacing = 0.sp,
            color = Color(0xFF7140FD), // opcional: color distinto
            fontFamily = FontFamily.Default, // Reemplazar por Poppins si corresponde
            modifier = Modifier.clickable { navController.navigate(BESTSELLER) }
        )*/
    }
}

@Composable
fun SellerProductsSection(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            ProductCard(
                imageResId = R.drawable.fotocomidaperros,
                name = "RC Kitten",
                price = "$20,99",
                onClick = { navController.navigate(BESTSELLER) }
            )
            ProductCard(
                imageResId = R.drawable.comidaparagatos2,
                name = "RC Persian",
                price = "$22,99",
                onClick = { navController.navigate(BESTSELLER) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSellerScreen() {
    val navController = rememberNavController()
    SellerScreen(navController = navController)
}