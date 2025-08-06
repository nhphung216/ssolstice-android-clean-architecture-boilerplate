package com.ssolstice.sample.presentation.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.ssolstice.sample.theme.SampleTheme

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Greeting(
            onNavigateToThemeSettings = {
                navController.navigate("theme_settings")
            },
            name = "Android",
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
    onNavigateToThemeSettings: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Hello $name!",
            modifier = modifier
        )
        Button(onClick = {
            onNavigateToThemeSettings()
        }) {
            Text("Open Theme Settings")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleTheme {
        Greeting("Android")
    }
}