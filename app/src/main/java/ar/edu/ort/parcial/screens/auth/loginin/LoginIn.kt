package ar.edu.ort.parcial.screens.auth.loginin

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.ButtonCom
import ar.edu.ort.parcial.ui.components.ButtonIcon
import ar.edu.ort.parcial.ui.theme.Poppins
import ar.edu.ort.parcial.ui.theme.White
import ar.edu.ort.parcial.ui.theme.Gris
import ar.edu.ort.parcial.ui.components.FieldCom
import ar.edu.ort.parcial.ui.components.TextLink
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginIn(navController: NavHostController,
            authViewModel: LoginInViewModel = viewModel()
    ) {

    val state = authViewModel.uiState

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopStart)
                .padding(top = 90.dp, start = 26.dp, end = 26.dp)
        ) {
            Text(
                text = stringResource(id = R.string.login_in_title),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 40.sp,
                lineHeight = 56.sp,
                letterSpacing = 0.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = stringResource(id = R.string.login_in_text),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                color = Gris,
                fontSize = 14.sp,
                lineHeight = 21.sp,
                letterSpacing = 0.sp
            )
            Spacer(modifier = Modifier.height(30.dp))
            FieldCom(
                text = stringResource(id = R.string.field_email),
                value = state.email,
                onValueChange = authViewModel::onEmailChange
            )
            Spacer(modifier = Modifier.height(18.dp))
            FieldCom(
                text = stringResource(id = R.string.field_pass),
                value = state.password,
                onValueChange = authViewModel::onPasswordChange
            )
            if (state.showPasswordError) {
                Text(
                    text = stringResource(id = R.string.field_pass_error),
                    color = Color.Red,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp, top = 4.dp)
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Image(
                painter = painterResource(id = R.drawable.or),
                contentDescription = "Or",
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                ButtonIcon(
                    iconResId = R.drawable.google_icon_png,
                    text = stringResource(id = R.string.google_component)
                )
                ButtonIcon(
                    iconResId = R.drawable.facebook_icon,
                    text = stringResource(id = R.string.facebook_component)
                )
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextLink(
                text = stringResource(id = R.string.field_create),
                text2 = stringResource(id = R.string.field_create_acc),
                onClickText2 = {navController.navigate("CreateAccount") }
            )
            Spacer(modifier = Modifier.height(36.dp))
            ButtonCom(
                text = stringResource(id = R.string.button_get),
                enabled = state.isButtonEnabled,
                onClick = {
                    if (authViewModel.validateCredentials()) {
                        navController.navigate("Home")
                    }
                }
            )
        }
    }
}

@Preview()
@Composable
fun LoginInPreview() {
    val navController = rememberNavController()
    LoginIn(navController = navController)
}