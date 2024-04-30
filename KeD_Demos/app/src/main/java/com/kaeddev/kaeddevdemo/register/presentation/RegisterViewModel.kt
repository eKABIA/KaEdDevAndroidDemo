package com.kaeddev.kaeddevdemo.register.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor() : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val userName : State<String> = _usernameText

    private val _emailText = mutableStateOf("")
    val emailText : State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _showPasswordText = mutableStateOf(false)
    val showPasswordText : State<Boolean> = _showPasswordText

    private val _isUsernameError = mutableStateOf(false)
    val isUsernameError : State<Boolean> = _isUsernameError

    private val _isEmailError = mutableStateOf(false)
    val isEmailError : State<Boolean> = _isEmailError

    private val _isPasswordError = mutableStateOf(false)
    val isPasswordError : State<Boolean> = _isPasswordError

    private val _userNameErrorValue = mutableStateOf("User Name Error Value")
    val userNameErrorValue : State<String> = _userNameErrorValue

    private val _emailErrorValue = mutableStateOf("Email Error Value")
    val emailErrorValue : State<String> = _emailErrorValue

    private val _passwordErrorValue = mutableStateOf("Password Error Value")
    val passwordErrorValue : State<String> = _passwordErrorValue



    fun setUsernameText(value : String) {
        _usernameText.value = value
    }

    fun setPasswordText(value : String){
        _passwordText.value = value
    }

    fun setEmailText(value : String){
        _emailText.value = value
    }

    fun setShowPassWord(value : Boolean){
        _showPasswordText.value = value
    }

    fun setIsPasswordError(value : Boolean, reason : String){
        _isPasswordError.value = value
        _passwordErrorValue.value =  if (!value) "" else reason
    }

    fun setIsUsernameError(value : Boolean, reason : String){
        _isUsernameError.value = value
        _userNameErrorValue.value = if(!value) "" else reason
    }

    fun setIsEmailError(value : Boolean, reason : String){
        _isEmailError.value = value
        _emailErrorValue.value = if (!value) "" else reason
    }
}