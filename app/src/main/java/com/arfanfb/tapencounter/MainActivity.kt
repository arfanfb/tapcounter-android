package com.arfanfb.tapencounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tapcounter.ui.theme.TapCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TapCounterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TapCounterApp()
                }
            }
        }
    }
}

@Composable
fun TapCounterApp() {
    // Using rememberSaveable to retain state across configuration changes
    var counter by rememberSaveable { mutableStateOf(0) }

    // The entire column is clickable to increment the counter
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clickable { counter++ },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Display the counter
        Text(
            text = counter.toString(),
            fontSize = 72.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Instructions text
        Text(
            text = "Tap anywhere to count",
            fontSize = 18.sp
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Reset button
        Button(
            onClick = { counter = 0 }
        ) {
            Text("Reset")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TapCounterPreview() {
    TapCounterTheme {
        TapCounterApp()
    }
}