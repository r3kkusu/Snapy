package com.snapy.app.features.auth

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.snapy.app.features.auth.getting_started.WelcomeView
import com.snapy.app.features.auth.sign_in.SingInView
import com.snapy.app.features.auth.sing_up.SingUpView

enum class Screens {
    SIGN_UP,
    SIGN_IN,
    WELCOME
}

@Composable
fun AuthScreen() {

    var screen by remember {
        mutableStateOf(Screens.WELCOME)
    }

    WelcomeView(screen) {
        screen = it
    }

    SingInView(screen) {
        screen = it
    }

    SingUpView(screen) {
        screen = it
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    AuthScreen()
}