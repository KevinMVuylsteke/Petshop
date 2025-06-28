package ar.edu.ort.parcial.screens.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.navigation.NavRoutes.SELLER
import ar.edu.ort.parcial.navigation.NavRoutes.BESTSELLER
import ar.edu.ort.parcial.ui.components.button.BottomNavBar

import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavController

@Composable
fun ProfileScreen(navController: NavController) {
    Scaffold (bottomBar = { BottomNavBar(navController = navController) }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF0F0F0))
        ) {
            HeaderSection(navController)
            ActionButtonsSection()
            ProductsSection(navController)
        }
    }
}

@Composable
fun HeaderSection(navController: NavController) {
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
                onClick = {  },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7140FD),
                    contentColor = Color.White ),
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
                onClick = { navController.navigate(SELLER) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray,
                    contentColor = Color.DarkGray

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
                .clip(
                    RoundedCornerShape(
                        topStart = 40.dp,
                        topEnd = 40.dp,
                        bottomStart = 40.dp,
                        bottomEnd = 40.dp
                    )
                )
                .background(Color.LightGray),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.mask_group),
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
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.pittashop),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(46.dp),
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Pittashop",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }
    }
}

@Composable
fun ActionButtonsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { /* Acción para "Saved" */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7140FD)),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(120.dp)
        ) {
            Text(text = "Saved", color = Color.White)
        }

        Spacer(modifier = Modifier.width(16.dp))

        OutlinedButton(
            onClick = { /* Acción para "Edit Profile" */ },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Black
            ),
            border = BorderStroke(1.dp, Color.Black),
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier.width(120.dp)
        ) {
            Text(text = "Edit Profile")
        }
    }
}

@Composable
fun ProductsSection(navController: NavController) {
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
                name = "RC Kittan",
                price = "$20,99",
                onClick = { navController.navigate(BESTSELLER) }
            )
            ProductCard(
                imageResId = R.drawable.comidaparagatos2,
                name = "RC Persion",
                price = "$22,99",
                onClick = { navController.navigate(BESTSELLER) }
            )
        }
    }
}

@Composable
fun ProductCard(imageResId: Int, name: String, price: String,onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(160.dp)
            .height(220.dp),
        shape = RoundedCornerShape(8.dp),
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(id = imageResId),
                contentDescription = name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
                contentScale = ContentScale.Fit
            )
            Text(
                text = name,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(top = 8.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = price,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                IconButton(
                    onClick = onClick,
                    modifier = Modifier
                        .size(43.dp)
                        .clip(CircleShape)
                        .background(Color(0xFF7140FD))
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add to Cart",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    val navController = rememberNavController()
    ProfileScreen(navController = navController)
}