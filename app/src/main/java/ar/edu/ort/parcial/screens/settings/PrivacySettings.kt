import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PrivacyScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Privacidad", fontSize = 20.sp) },
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
                .padding(paddingValues) // Aplicar el padding del Scaffold (para no superponerse con la TopAppBar)
                .padding(horizontal = 16.dp) // Padding horizontal para el contenido general
                .verticalScroll(rememberScrollState()) // Habilita el desplazamiento vertical
        ) {
            // Sección "Term of Use"
            Text(
                text = "Términos de Uso",
                style = MaterialTheme.typography.titleLarge, // Estilo para el título de sección
                modifier = Modifier.padding(top = 24.dp, bottom = 8.dp) // Espaciado superior e inferior para el título
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris interdum sapien sodales mi sagittis hendrerit. Curabitur ut lectus nec orci cursus rhoncus. Donec a ultrices risus. Mauris ut erat ut urna rhoncus facilisis a eu neque. Ut iaculis viverra laoreet. In interdum, augue non auctor pharetra, felis ante gravida ante, quis mattis quam eros non quam. Vivamus scelerisque ante nec dapibus convallis. Vestibulum quis scelerisque leo. Vestibulum quis porttitor tellus, non finibus nibh. Quisque ut tempor nulla, sed consectetur tortor. Mauris volutpat viverra arcu non laoreet. Duis eu arcu nunc. Pellentesque ultricies facilisis faucibus. Duis magna sem, ultricies sed scelerisque efficitur, hendrerit at arcu.\n\n" +
                        "Fusce sit amet ex in nisi bibendum finibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec a odio at neque dictum fringilla. Nullam eget enim vel justo volutpat tristique. Aliquam erat volutpat. Sed et massa et mauris volutpat convallis. Donec nec ex ut lorem gravida facilisis. Sed id nisi sed justo facilisis vehicula. Donec eu sapien vitae odio volutpat eleifend. Nulla facilisi. Praesent consectetur, libero non facilisis rhoncus, nulla nisl tincidunt turpis, id aliquet sapien nisi eu felis.",
                style = MaterialTheme.typography.bodyMedium, // Estilo para el texto del contenido
                modifier = Modifier.padding(bottom = 16.dp) // Espaciado inferior para el texto
            )

            // Sección "PetApp Service"
            Text(
                text = "Servicio PetApp",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(top = 16.dp, bottom = 8.dp) // Espaciado similar al anterior
            )
            Text(
                text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris interdum sapien sodales mi sagittis hendrerit. Curabitur ut lectus nec orci cursus rhoncus. Donec a ultrices risus. Mauris ut erat ut urna rhoncus facilisis a eu neque. Ut iaculis viverra laoreet. In interdum, augue non auctor pharetra, felis ante gravida ante, quis mattis quam eros non quam. Vivamus scelerisque ante nec dapibus convallis. Vestibulum quis scelerisque leo.\n\n" +
                        "Duis eu arcu nunc. Pellentesque ultricies facilisis faucibus. Duis magna sem, ultricies sed scelerisque efficitur, hendrerit at arcu. Fusce sit amet ex in nisi bibendum finibus. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Donec a odio at neque dictum fringilla.",
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.padding(bottom = 24.dp) // Espaciado inferior para el último texto
            )


        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPrivacyScreen() {
    MaterialTheme { // Envuelve la vista previa con tu tema de Material
        PrivacyScreen()
    }
}