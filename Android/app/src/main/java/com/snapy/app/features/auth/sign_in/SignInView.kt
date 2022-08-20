package com.snapy.app.features.auth.sign_in

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snapy.app.R
import com.snapy.app.features.auth.Screens

@Composable
fun SingInView(
    screen: Screens,
    action: (screen: Screens) -> Unit
) {
    AnimatedVisibility(
        screen == Screens.SIGN_IN,
        modifier = Modifier.fillMaxSize(),
        enter = slideInHorizontally(
            initialOffsetX = { it },
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        ),
        exit = slideOutVertically (
            targetOffsetY = { -it },
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing
            )
        )
    ) {
        var username by remember {  mutableStateOf("") }
        var password by remember {  mutableStateOf("") }

        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    placeholder = { Text(text = stringResource(id = R.string.username)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    placeholder = { Text(text = stringResource(id = R.string.password)) },
                    shape = RoundedCornerShape(15.dp)
                )

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    modifier = Modifier.width(150.dp),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(30.dp)
                ) {
                    Text(
                        modifier = Modifier.padding(4.dp),
                        text = stringResource(id = R.string.sign_in),
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp
                    )
                }

                Divider(
                    modifier = Modifier
                        .width(250.dp)
                        .padding(20.dp),
                    color = Color.Gray,
                    thickness = 1.dp
                )

                Row {
                    Text(text = stringResource(id = R.string.dont_have_account))
                    ClickableText(
                        text = AnnotatedString(stringResource(id = R.string.sing_up)),
                        modifier = Modifier.padding(start = 4.dp),
                        onClick = { action(Screens.SIGN_UP) },
                        style = TextStyle(fontWeight = FontWeight.Bold)
                    )
                }
            }
        }
    }
}