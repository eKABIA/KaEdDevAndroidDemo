package com.kaeddev.kaeddevdemo.login.presentation

import android.content.res.Configuration
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
fun LoginScreen(
    navigate : (navigateToRegister : Boolean) -> Unit,
    viewModel : LoginViewModel = hiltViewModel()
){

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Spacing.SpacingLarge)
            .padding(
                top = Spacing.SpacingLarge,
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
                text = stringResource(id = R.string.login_title),
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingLarge))

            StandardTextField(
                text = viewModel.userName.value,
                hint = stringResource(id = R.string.login_hint),
                isError = viewModel.isUsernameError.value,
                keyboardType = KeyboardType.Email,
                errorValue = viewModel.userNameErrorValue.value,
                onValueChange = {
                    viewModel.setUsernameText(it)
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
                onPasswordToggleClick = {
                    viewModel.setShowPassWord(it)
                },
                onValueChange = {
                    viewModel.setPasswordText(it)
                }
            )

            Spacer(modifier = Modifier.height(Spacing.SpacingMedium))

            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    navigate(false)
                }

            ) {
                Text(
                    text = stringResource(id = R.string.login_title)
                )
            }

        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.dont_have_account_yet))
                append(" ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green
                    ),
                    block = {
                        append(stringResource(id = R.string.sign_up))
                    }
                )
            },
            style = MaterialTheme.typography.labelLarge,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .clickable {
                    navigate(true)
                }
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun LoginScreenLightPreview() {
    LoginScreen({})
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun LoginScreenDarkPreview() {
    LoginScreen({})
}