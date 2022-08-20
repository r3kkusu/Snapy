package com.snapy.app.features

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.snapy.app.features.common.NavigationControl

@Composable
fun SnapyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        NavigationControl()
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    SnapyApp()
}