package com.kaeddev.kaeddevdemo.register.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kaeddev.kaeddevdemo.R
import com.kaeddev.kaeddevdemo.components.text_entry.StandardTextField
import com.kaeddev.kaeddevdemo.ui.theme.Spacing

@Composable
fun RegisterScreen(
    navigate : (navigateAsRegistered : Boolean) -> Unit,
    viewModel : RegisterViewModel = hiltViewModel()
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.SpacingLarge)
            .padding(
                top =  Spacing.SpacingLarge,
                bottom = 50.dp
            )
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
        ){
            Text(
                text = stringResource(id = R.string.register_title),
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingLarge))

            StandardTextField(
                text = viewModel.userName.value,
                hint = stringResource(id = R.string.user_name_hint),
                isError = viewModel.isUsernameError.value,
                errorValue = viewModel.userNameErrorValue.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
                }
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingMedium))

            StandardTextField(
                text = viewModel.emailText.value,
                hint = stringResource(id = R.string.email_hint),
                isError = viewModel.isEmailError.value,
                errorValue = viewModel.emailErrorValue.value,
                keyboardType = KeyboardType.Email,
                showPasswordToggle = viewModel.showPasswordText.value,
                onValueChange = {
                    viewModel.setEmailText(it)
                }
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingMedium))

            StandardTextField(
                text = viewModel.passwordText.value,
                hint = stringResource(id = R.string.password_hint),
                isError = viewModel.isPasswordError.value,
                errorValue = viewModel.passwordErrorValue.value,
                keyboardType = KeyboardType.Password,
                showPasswordToggle = viewModel.showPasswordText.value,
                onValueChange = {
                    viewModel.setPasswordText(it)
                },
                onPasswordToggleClick = {
                    viewModel.setShowPassWord(it)
                }
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingLarge))

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    navigate(true)
                }

            ) {
                Text(
                    text = stringResource(id = R.string.register)
                )
            }
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.already_have_an_account))
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green
                    )
                ){
                    append(stringResource(id = R.string.sign_in))
                }

            },
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navigate(false)
                }

        )
    } 
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen({})
}