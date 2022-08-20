package com.snapy.app.features.auth.getting_started

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snapy.app.R
import com.snapy.app.features.auth.Screens

@Composable
fun WelcomeView(
    screen: Screens,
    action: (screen: Screens) -> Unit
) {
    AnimatedVisibility(
        screen == Screens.WELCOME,
        modifier = Modifier.fillMaxSize(),
        enter = slideInHorizontally(
            initialOffsetX = { -300 }, // small slide 300px
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearEasing // interpolator
            )
        ),
        exit = slideOutHorizontally(
            targetOffsetX = { -600 },
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
                Image(
                    modifier = Modifier.size(150.dp, 150.dp),
                    painter = painterResource(id = R.drawable.ic_baseline_message_24),
                    contentDescription = stringResource(id = R.string.snapy_image),
                    colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
                )
                Text(
                    modifier = Modifier.padding(10.dp),
                    textAlign = TextAlign.Center,
                    text = stringResource(id = R.string.welcome_to_snapy),
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
                Button(
                    modifier = Modifier.padding(top = 10.dp),
                    onClick = {
                        action(Screens.SIGN_IN)
                    }) {
                    Text(text = stringResource(id = R.string.get_started))
                }
            }
        }
    }
}
