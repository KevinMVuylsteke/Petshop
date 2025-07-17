package ar.edu.ort.parcial.screens.notifications
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.AccionDerechaNotificacion
import ar.edu.ort.parcial.ui.components.AvatarNotificacion
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ar.edu.ort.parcial.ui.components.MyTopBar


enum class TabNotificacion {
    Actividad, ModoVendedor
}

@Composable
fun NotificationScreen(navController: NavController,tabInicial: TabNotificacion = TabNotificacion.Actividad) {
    var tabSeleccionado by remember { mutableStateOf(tabInicial) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        MyTopBar(
            title = stringResource(id = R.string.notification_title),
            onBackClick = { navController.popBackStack() }
        )
        TabsNotificacion(tabSeleccionado) { tabSeleccionado = it }
        when (tabSeleccionado) {
            TabNotificacion.Actividad -> ContenidoActividad()
            TabNotificacion.ModoVendedor -> ContenidoModoVendedor()
        }
    }
}

@Composable
fun TabsNotificacion(tabSeleccionado: TabNotificacion, onTabSeleccionado: (TabNotificacion) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        BotonTab("Activity", tabSeleccionado == TabNotificacion.Actividad) {
            onTabSeleccionado(TabNotificacion.Actividad)
        }
        Spacer(modifier = Modifier.width(8.dp))
        BotonTab("Seller Mode", tabSeleccionado == TabNotificacion.ModoVendedor) {
            onTabSeleccionado(TabNotificacion.ModoVendedor)
        }
    }
}

@Composable
fun BotonTab(texto: String, seleccionado: Boolean, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (seleccionado) Color(0xFF7A50E3) else Color.LightGray.copy(0.3f),
            contentColor = if (seleccionado) Color.White else Color.Black
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Text(texto)
    }
}

data class Notificacion(
    val titulo: String,
    val subtitulo: String,
    val imagenPerfil: Int,
    val imagenProducto: Int,
    val conFlechaDerecha: Boolean = false
)

@Composable
fun ContenidoActividad() {
    val items = List(4) {
        Notificacion(
            titulo = "¡50% de descuento!",
            subtitulo = "¡Mirá los detalles!",
            imagenPerfil = R.drawable.comidaparagatos2,
            imagenProducto = R.drawable.comidaparagatos2
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(items) { notificacion ->
            ItemNotificacionVendedor(notificacion)
            Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)
        }
    }
}

@Composable
fun ContenidoModoVendedor() {
    val notificaciones = listOf(
        Notificacion("You Got New Order!", "Please arrange delivery", R.drawable.fotocomidagatos, R.drawable.comidaparagatos2, conFlechaDerecha = true),
        Notificacion("Momon", "Liked your Product", R.drawable.fotoavatar2, R.drawable.comidaparagatos2),
        Notificacion("Ola", "Liked your Product", R.drawable.fotoavatar3, R.drawable.comidaparagatos2),
        Notificacion("Raul", "Liked your Product", R.drawable.fotoavatar, R.drawable.comidaparagatos2),
        Notificacion("You Got New Order!", "Please arrange delivery", R.drawable.fotocomidagatos, R.drawable.comidaparagatos2, conFlechaDerecha = true),
        Notificacion("You Got New Order!", "Please arrange delivery", R.drawable.fotocomidagatos, R.drawable.comidaparagatos2, conFlechaDerecha = true),
        Notificacion("You Got New Order!", "Please arrange delivery", R.drawable.fotocomidagatos, R.drawable.comidaparagatos2, conFlechaDerecha = true),
        Notificacion("Vito", "Liked your Product", R.drawable.fotoavatar3, R.drawable.comidaparagatos2)
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(notificaciones) { notificacion ->
            ItemNotificacionVendedor(notificacion)
            Divider(color = Color(0xFFE0E0E0), thickness = 1.dp)
        }
    }
}

@Composable
fun ItemNotificacionVendedor(notificacion: Notificacion) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AvatarNotificacion(imagenRes = notificacion.imagenPerfil)

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(notificacion.titulo, fontWeight = FontWeight.Bold, fontSize = 14.sp)
            Text(notificacion.subtitulo, color = Color.Gray, fontSize = 12.sp)
        }

        Spacer(modifier = Modifier.width(8.dp))

        AccionDerechaNotificacion(
            conFlecha = notificacion.conFlechaDerecha,
            imagenProducto = notificacion.imagenProducto
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NotificationScreenModoVendedorPreview() {
    val navController = rememberNavController()
    NotificationScreen(navController,tabInicial = TabNotificacion.ModoVendedor)
}
