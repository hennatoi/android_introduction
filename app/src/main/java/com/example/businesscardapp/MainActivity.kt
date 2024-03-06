package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        ComposableInfoCard(
            image = painterResource(R.drawable.android_logo),
            phoneImage = painterResource(R.drawable.baseline_phone_black_24),
            shareImage = painterResource(R.drawable.baseline_share_black_18),
            emailImage = painterResource(R.drawable.baseline_email_black_18),
            name = stringResource(R.string.person_name),
            title = stringResource(R.string.person_title),
            phoneNumber = stringResource(R.string.phone_number),
            contactAddress = stringResource(R.string.contact_address),
            emailAddress = stringResource(R.string.email_address),
            backgroundColor = colorResource(R.color.green),
            fontColor = colorResource(R.color.white),
            modifier = Modifier.padding()
        )
    }
}

@Composable
private fun ComposableInfoCard(
    image: Painter,
    phoneImage: Painter,
    shareImage: Painter,
    emailImage: Painter,
    name: String,
    title: String,
    phoneNumber: String,
    emailAddress: String,
    contactAddress: String,
    backgroundColor: Color,
    fontColor: Color,
    modifier: Modifier = Modifier
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(backgroundColor)
                .padding(top = 170.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(painter = image, contentDescription = null, modifier = Modifier.size(180.dp))
            Text(
                text = name,
                modifier = Modifier.padding(bottom = 16.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                fontFamily = FontFamily.Serif
            )
            Text(
                text = title,
                textAlign = TextAlign.Justify,
                color = fontColor,
                fontSize = 19.sp
            )
            Spacer(Modifier.weight(0.02f))
        }
        Column(
            modifier = Modifier.align(Alignment.BottomCenter)
                .padding(bottom = 32.dp)
        ) {
            Row(
                modifier = modifier
                    .padding()
            ) {
                Image(
                    painter = phoneImage,
                    contentDescription = "Phone number",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = phoneNumber,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Bold
                )
            }
            Row(
                modifier = modifier
                    .padding()
            ) {
                Image(
                    painter = shareImage,
                    contentDescription = "Share the contact info",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = contactAddress,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }
            Row(
                modifier = modifier
                    .padding()
            ) {
                Image(
                    painter = emailImage,
                    contentDescription = "E-mail address",
                    modifier = Modifier.size(20.dp)
                )
                Text(
                    text = emailAddress,
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Left
                )
            }
        }

    }
}
@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}