import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Key
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecuritySettingsItem(icon: androidx.compose.ui.graphics.vector.ImageVector, text: String, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 15.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null, // Descripción para accesibilidad
            modifier = Modifier.size(28.dp) // Tamaño del ícono
        )
        Spacer(modifier = Modifier.width(20.dp)) // Espacio entre ícono y texto
        Text(text = text, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 18.sp)) // Texto del elemento
        Spacer(modifier = Modifier.weight(1f)) // Empuja la flecha al final
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            modifier = Modifier.size(28.dp) // Tamaño de la flecha
        )
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SecurityScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Seguridad", fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { /* TODO: Manejar el clic de retroceso, e.g., navController.popBackStack() */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Volver",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Aplicar el padding del Scaffold
                .padding(horizontal = 16.dp) // Padding horizontal para el contenido
        ) {
            // Título de la sección "Security"
            Text(
                text = "Seguridad",
                style = MaterialTheme.typography.titleLarge, // Estilo para el título de sección
                modifier = Modifier.padding(top = 24.dp, bottom = 12.dp) // Espaciado superior e inferior
            )

            // Elemento "Change Password"
            SecuritySettingsItem(
                icon = Icons.Default.Key, // Ícono de llave para contraseña
                text = "Cambiar Contraseña"
            ) {
                /* TODO: Acción al hacer clic en "Cambiar Contraseña" */
            }

            // Elemento "Change Email"
            SecuritySettingsItem(
                icon = Icons.Default.Email, // Ícono de correo para email
                text = "Cambiar Correo Electrónico"
            ) {
                /* TODO: Acción al hacer clic en "Cambiar Correo Electrónico" */
            }


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecurityScreen() {
    MaterialTheme {
        SecurityScreen()
    }
}