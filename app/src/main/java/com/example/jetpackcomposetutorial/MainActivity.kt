package com.example.jetpackcomposetutorial

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        header = getString(R.string.app_name),
                        firstText = getString(R.string.first_text),
                        secondText = getString(R.string.second_text),
                        image = painterResource(R.drawable.bg_compose_background)
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(header: String, firstText: String, secondText: String, modifier: Modifier = Modifier) {
        Text(
            text = header,
            modifier = Modifier.padding(16.dp),
            fontSize = 24.sp
        )
        Text(
            text = firstText,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp),
            textAlign = TextAlign.Justify
        )
        Text(
            text = secondText,
            modifier = Modifier.padding(16.dp),
            textAlign = TextAlign.Justify
        )
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun GreetingImage(header: String, firstText: String, secondText: String, image: Painter, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Image(painter = image, contentDescription = null)
        GreetingText(
            header = header,
            firstText = firstText,
            secondText = secondText
        )
    }
}


@Preview(showBackground = true)
@Composable
fun JetpackComposeTutorialPreview() {
    JetpackComposeTutorialTheme {
        GreetingImage(
            header = stringResource(R.string.app_name),
            firstText = stringResource(R.string.first_text),
            secondText = stringResource(R.string.second_text),
            image = painterResource(R.drawable.bg_compose_background)
        )
    }
}