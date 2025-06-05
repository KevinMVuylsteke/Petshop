package ar.edu.ort.parcial.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

@Composable
fun HeaderSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .background(Color(0xFFF0F0F0)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Botones superiores
        Row(
            modifier = Modifier
                .padding(top = 24.dp)
                .background(Color(0xFFEFEFEF), shape = RoundedCornerShape(30.dp))
                .padding(4.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier = Modifier
                    .width(120.dp)
                    .height(36.dp)
            ) {
                Text("Profile", color = Color.Black, fontSize = 14.sp)
            }

            Spacer(modifier = Modifier.width(8.dp))

            Button(
                onClick = { },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF7140FD)),
                shape = RoundedCornerShape(20.dp),
                elevation = ButtonDefaults.buttonElevation(0.dp),
                modifier = Modifier
                    .width(120.dp)
                    .height(36.dp)
            ) {
                Text("Seller Mode", color = Color.White, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // --- Banner con fondo gris separado ---
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
                painter = painterResource(id = R.drawable.fondomarron),
                contentDescription = "Header Background Banner",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        // --- Avatar y nombre superpuestos ---
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-60).dp), // lo sube más
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(110.dp) // agranda el contenedor
                    .shadow(12.dp, shape = CircleShape)
                    .clip(CircleShape)
                    .background(Color.White)
                    .border(4.dp, Color(0xFF7140FD), CircleShape), // borde más grueso
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.fotoavatar),
                    contentDescription = "Profile Picture",
                    modifier = Modifier
                        .size(115.dp) // agranda la imagen
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }

            // REDUCIMOS O QUITAMOS ESTE SPACER
            Spacer(modifier = Modifier.height(4.dp)) // Antes 12.dp, ahora 4.dp o incluso 0.dp

            Text(
                text = "Carlos",
                fontSize = 24.sp, // fuente más grande
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        }


        // Estadísticas centradas y visualmente equilibradas
        // MOVEMOS ESTE CONTENEDOR MÁS HACIA ARRIBA USANDO OFFSET
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-40).dp) // *** NUEVO: Offset negativo para subir las estadísticas ***
                .padding(vertical = 1.dp), // Mantener el padding vertical existente si lo necesitas
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "109",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text("Followers", color = Color.Gray, fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "992",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text("Following", color = Color.Gray, fontSize = 14.sp)
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "80",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 2.dp)
                )
                Text("Sales", color = Color.Gray, fontSize = 14.sp)
            }
        }

        // Tabs: Product / Sold / Stats
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TabButton(text = "Product", selected = true)
            TabButton(text = "Sold", selected = false)
            TabButton(text = "Stats", selected = false)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Lista de productos
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductCard(
                title = "RC Kitten",
                price = "$20,99",
                imageRes = R.drawable.fotocomidaperros
            )
            ProductCard(
                title = "RC Persian",
                price = "$22,99",
                imageRes = R.drawable.comidaparagatos2
            )
        }
    }
}

@Composable
fun TabButton(text: String, selected: Boolean) {
    val backgroundColor = if (selected) Color(0xFF7140FD) else Color(0xFFF3F3F3)
    val textColor = if (selected) Color.White else Color.Gray

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        Text(text = text, color = textColor, fontSize = 14.sp)
    }
}

@Composable
fun ProductCard(title: String, price: String, imageRes: Int) {
    Column(
        modifier = Modifier
            .width(160.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "Product Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(16.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = title, fontSize = 14.sp)
        Spacer(modifier = Modifier.height(4.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = price, fontWeight = FontWeight.Bold)
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .background(Color(0xFF7140FD), shape = CircleShape)
                        .padding(4.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HeaderSectionPreview() {
    MaterialTheme {
        Surface {
            HeaderSection()
        }
    }
}