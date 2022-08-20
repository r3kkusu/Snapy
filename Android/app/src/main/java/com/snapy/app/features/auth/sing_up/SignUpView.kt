package com.snapy.app.features.auth.sing_up

import androidx.compose.animation.*
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snapy.app.R
import com.snapy.app.features.auth.Screens


@Composable
fun SingUpView(
    screen: Screens,
    action: (screen: Screens) -> Unit
) {
    AnimatedVisibility(
        screen == Screens.SIGN_UP,
        modifier = Modifier.fillMaxSize(),
        enter = slideInVertically(
            initialOffsetY = { it }, // it == fullWidth
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        ),
        exit = slideOutVertically (
            targetOffsetY = { it },
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        )
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                var username by remember {  mutableStateOf("") }

                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text(text = stringResource(id = R.string.username)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                var email by remember {  mutableStateOf("") }

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(text = stringResource(id = R.string.email)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                var password by remember {  mutableStateOf("") }

                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    placeholder = { Text(text = stringResource(id = R.string.password)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                var confirmPassword by remember {  mutableStateOf("") }

                OutlinedTextField(
                    value = confirmPassword,
                    onValueChange = { confirmPassword = it },
                    placeholder = { Text(text = stringResource(id = R.string.confirm_password)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    modifier = Modifier.width(150.dp),
                    onClick = { action(Screens.SIGN_IN) },
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = stringResource(id = R.string.sing_up),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}