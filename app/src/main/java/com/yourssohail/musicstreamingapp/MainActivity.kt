package com.yourssohail.musicstreamingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.yourssohail.musicstreamingapp.data.songsList
import com.yourssohail.musicstreamingapp.ui.screens.HomeScreen
import com.yourssohail.musicstreamingapp.ui.screens.LoginScreen
import com.yourssohail.musicstreamingapp.ui.theme.MusicStreamingAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicStreamingAppTheme {
                var isLoggedIn by remember { mutableStateOf(false) }

                if (isLoggedIn) {
                    Scaffold(topBar = {
                        TopAppBar(
                            title = { Text(text = "Music Streaming App") },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    }) { innerPadding ->
                        HomeScreen(songsList = songsList, innerPadding)
                    }
                } else {
                    LoginScreen(
                        onLoginSuccess = {
                            isLoggedIn = true
                        }
                    )
                }
            }
        }
    }
}
