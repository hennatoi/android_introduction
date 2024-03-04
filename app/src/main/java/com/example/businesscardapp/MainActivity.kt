package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
            name = stringResource(R.string.person_name),
            title = stringResource(R.string.person_title),
            phoneNumber = stringResource(R.string.phone_number),
            contactAddress = stringResource(R.string.contact_address),
            backgroundColor = colorResource(R.color.green),
            modifier = Modifier.padding(/*top = 8.dp, bottom = 8.dp*/)
        )
        ComposablePhoneNumber(
            phoneImage = painterResource(R.drawable.android_logo),
            phoneNumber = stringResource(R.string.phone_number),
            backgroundColor = colorResource(R.color.green),
            modifier = Modifier.padding()/*Modifier.weight(1f)*/
        )
        /*    ComposableContactInfo(
                mediaImage = stringResource(R.string.second_title),
                contactAddress = stringResource(R.string.contact_address),
                modifier = Modifier.weight(1f)
            )  */
    }
}
@Composable
private fun ComposableInfoCard(
    image: Painter,
    phoneImage: Painter,
    shareImage: Painter,
    name: String,
    title: String,
    phoneNumber: String,
    contactAddress: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 170.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = image, contentDescription = null, modifier = Modifier.size(180.dp))
        Text(
            text = name,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
        Text(
            text = title,
            textAlign = TextAlign.Justify
        )
        Spacer(Modifier.weight(0.02f))
        Row {
            Image(painter = phoneImage, contentDescription = null, modifier = Modifier.size(20.dp))
            Text(
                text = phoneNumber,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
        }
        Row {
            Image(painter = shareImage, contentDescription = null, modifier = Modifier.size(20.dp))
            Text(
                text = contactAddress,
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
private fun ComposablePhoneNumber(
    phoneImage: Painter,
    phoneNumber: String,
    backgroundColor: Color,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(top = 150.dp),
     //   verticalArrangement = Arrangement.Center,
        //   horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = phoneImage, contentDescription = null, modifier = Modifier.size(180.dp))
        Text(
            text = phoneNumber,
            modifier = Modifier.padding(bottom = 16.dp),
            fontWeight = FontWeight.Bold
        )
    }

}


@Preview(showBackground = true)
@Composable
fun BusinessCardAppPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}