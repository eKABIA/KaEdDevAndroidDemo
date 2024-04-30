package com.kaeddev.kaeddevdemo.components.text_entry

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.kaeddev.kaeddevdemo.R

@Composable
fun StandardTextField(
    text : String = "",
    hint : String = "",
    isError : Boolean = false,
    errorValue : String = "",
    singleLine : Boolean = true,
    maxLength: Int = 40,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    isPasswordToggleDisplayed : Boolean = keyboardType == KeyboardType.Password,
    showPasswordToggle : Boolean = false,
    onPasswordToggleClick : (Boolean) -> Unit = {},
    onValueChange : (String) -> Unit
){
    TextField(
        value = text,
        shape = MaterialTheme.shapes.large,
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        onValueChange = {
            if(it.count() <= maxLength) onValueChange(it.trim())
        },
        placeholder = {
            Text(
                text = hint,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        leadingIcon = leadingIcon,
        isError = isError,
        singleLine = singleLine,
        visualTransformation =
            if (!showPasswordToggle && isPasswordToggleDisplayed) PasswordVisualTransformation()
            else VisualTransformation.None,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ) ,
        trailingIcon = {
            if(isPasswordToggleDisplayed){
                IconButton(
                    onClick = {
                        onPasswordToggleClick(!showPasswordToggle)
                    },
                    modifier = Modifier
                        .semantics {
                            testTag = "standard_text_field_icon_password"
                        }
                ) {
                    Icon(
                        imageVector =
                            if (showPasswordToggle) Icons.Filled.VisibilityOff
                            else Icons.Filled.Visibility
                        ,
                        contentDescription =
                        if(showPasswordToggle) stringResource(id = R.string.password_visible_content_description)
                        else stringResource(id = R.string.password_hiden_content_description)
                    )
                }
            }
            else trailingIcon?.let { it() }
        },
        supportingText = {
             if(isError){
                 Text(
                     modifier = Modifier.fillMaxSize(),
                     text = errorValue,
                     color = MaterialTheme.colorScheme.error
                 )
             }
        },
        label = {
                Text(text = hint)
        },
        modifier = Modifier
            .fillMaxWidth()
            .semantics {
                testTag = "standard_text_field"
            }
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun StandardTextFieldPreview(){
    StandardTextField(text = "HI", hint = "test", keyboardType = KeyboardType.Password, isError = true) {
    }
}