package com.kaeddev.kaeddevdemo.login.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val _usernameText = mutableStateOf("")
    val userName : State<String> = _usernameText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _showPasswordText = mutableStateOf(false)
    val showPasswordText : State<Boolean> = _showPasswordText

    private val _isUsernameError = mutableStateOf(false)
    val isUsernameError : State<Boolean> = _isUsernameError

    private val _userNameErrorValue = mutableStateOf("User Name Error Value")
    val userNameErrorValue : State<String> = _userNameErrorValue

    private val _passwordErrorValue = mutableStateOf("Password Error Value")
    val passwordErrorValue : State<String> = _passwordErrorValue

    private val _isPasswordError = mutableStateOf(false)
    val isPasswordError : State<Boolean> = _isPasswordError

    fun setUsernameText(value : String) {
        _usernameText.value = value
    }

    fun setPasswordText(value : String){
        _passwordText.value = value
    }

    fun setShowPassWord(value : Boolean){
        _showPasswordText.value = value
    }

    fun setIsPasswordError(value : Boolean){
        _isPasswordError.value = value
    }

    fun setIsUsernameError(value : Boolean){
        _isUsernameError.value = value
    }

}