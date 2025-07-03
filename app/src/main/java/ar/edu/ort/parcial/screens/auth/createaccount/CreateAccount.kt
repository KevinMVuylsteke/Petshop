package ar.edu.ort.parcial.screens.auth.createaccount

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ar.edu.ort.parcial.R
import ar.edu.ort.parcial.ui.components.ButtonCom
import ar.edu.ort.parcial.ui.components.CheckTerms
import ar.edu.ort.parcial.ui.components.FieldCom
import ar.edu.ort.parcial.ui.components.TextLink
import ar.edu.ort.parcial.ui.theme.Gris
import ar.edu.ort.parcial.ui.theme.Poppins
import ar.edu.ort.parcial.ui.theme.White
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel

import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController


import androidx.lifecycle.viewmodel.compose.viewModel
import ar.edu.ort.parcial.model.UserApi

@Composable
fun CreateAccount(
    navController: NavHostController,
    viewModel: CreateAccountViewModel = hiltViewModel()
) {

    val state = viewModel.uiState

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
                text = stringResource(id = R.string.create_title),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                fontSize = 40.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = stringResource(id = R.string.create_text),
                fontFamily = Poppins,
                fontWeight = FontWeight.SemiBold,
                color = Gris,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(30.dp))

            FieldCom(
                text = stringResource(id = R.string.field_name),
                value = state.name,
                onValueChange = viewModel::onNameChange
            )

            Spacer(modifier = Modifier.height(18.dp))

            FieldCom(
                text = stringResource(id = R.string.field_email),
                value = state.email,
                onValueChange = viewModel::onEmailChange
            )

            Spacer(modifier = Modifier.height(18.dp))

            FieldCom(
                text = stringResource(id = R.string.field_pass),
                value = state.password,
                onValueChange = viewModel::onPasswordChange
            )

            if (state.showPasswordError) {
                Text(
                    text = "Este campo es obligatorio",
                    color = Color.Red,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 4.dp, top = 2.dp)
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            CheckTerms(
                checked = state.acceptedTerms,
                onCheckedChange = viewModel::onTermsChecked
            )
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextLink(
                text = stringResource(id = R.string.create_textlink1),
                text2 = stringResource(id = R.string.create_textlink2),
                onClickText2 = { navController.navigate("LoginIn") }
            )

            Spacer(modifier = Modifier.height(36.dp))

            ButtonCom(
                text = stringResource(id = R.string.button_get),
                enabled = state.isButtonEnabled,
                onClick = {
                    viewModel.register(
                        onSuccess = {
                            navController.navigate("LoginIn")
                        }
                    )
                }
            )
        }
    }
}

/*
@Preview()
@Composable
fun CreateAccountPreview() {
    val navController = rememberNavController()
    CreateAccount(navController = navController)
}*/