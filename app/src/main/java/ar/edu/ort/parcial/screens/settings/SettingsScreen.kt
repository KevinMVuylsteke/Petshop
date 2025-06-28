import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Define algunos colores para la consistencia
val Purple80 = Color(0xFFD0BCFF)
val LightGray = Color(0xFFF2F2F2)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreenSlightlyLarger() { // Nombre ajustado para diferenciar
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Página de Configuración", fontSize = 20.sp) }, // Título un poco más grande
                navigationIcon = {
                    IconButton(onClick = { /* Manejar clic del botón de retroceso */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            modifier = Modifier.size(28.dp) // Ícono de retroceso un poco más grande
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(horizontal = 20.dp, vertical = 12.dp) // Más padding general, pero no tanto
        ) {
            // Sección de Cuenta
            Text(
                text = "Cuenta",
                style = MaterialTheme.typography.titleLarge, // Usar titleLarge para un poco más de tamaño
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp) // Padding un poco más grande
            )
            SettingsItemSlightlyLarger(icon = Icons.Default.Person, text = "Cuenta") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.Home, text = "Dirección") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.Notifications, text = "Notificaciones") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.AccountBalanceWallet, text = "Método de Pago") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.Visibility, text = "Privacidad") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.Lock, text = "Seguridad") { /* Manejar clic */ }

            // Sección de Ayuda
            Text(
                text = "Ayuda",
                style = MaterialTheme.typography.titleLarge, // Usar titleLarge
                modifier = Modifier.padding(top = 36.dp, bottom = 12.dp) // Padding un poco más grande
            )
            SettingsItemSlightlyLarger(icon = Icons.Default.Call, text = "Contáctanos") { /* Manejar clic */ }
            SettingsItemSlightlyLarger(icon = Icons.Default.Info, text = "FAQ") { /* Manejar clic */ }

            Spacer(modifier = Modifier.weight(1f))

            // Botón de Cerrar Sesión
            Button(
                onClick = { /* Manejar clic de Cerrar Sesión */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp) // Botón un poco más alto
                    .padding(bottom = 20.dp), // Padding desde la parte inferior un poco más grande
                shape = RoundedCornerShape(14.dp), // Bordes un poco más redondeados
                colors = ButtonDefaults.buttonColors(containerColor = Purple80)
            ) {
                Text(text = "Cerrar Sesión", color = Color.White, fontSize = 20.sp) // Texto del botón un poco más grande
            }
        }
    }
}

@Composable
fun SettingsItemSlightlyLarger(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 15.dp), // Más padding vertical para mayor altura de la fila
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            modifier = Modifier.size(28.dp) // Íconos de elementos un poco más grandes
        )
        Spacer(modifier = Modifier.width(20.dp)) // Más espacio entre ícono y texto
        Text(text = text, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)) // Texto del elemento un poco más grande
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(28.dp) // Flecha un poco más grande
        )
    }
    // Puedes añadir un Divider aquí si quieres separación
    // Divider(modifier = Modifier.padding(start = 52.dp))
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewSettingsScreenSlightlyLarger() {
    MaterialTheme {
        SettingsScreenSlightlyLarger()
    }
}