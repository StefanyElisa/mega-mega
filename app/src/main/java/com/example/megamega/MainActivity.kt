package com.example.megamega

//Stefany Elisa - Maria Eduarda Anunciato

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.megamega.ui.theme.MegaMegaTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MegaMegaTheme {
                // A surface container using the 'background' color from the theme
                MegaSenaApp( modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)

                )
                }
            }
        }
    }


@Composable
fun MegaSenaApp(modifier : Modifier) {
    var numeros by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround

    ) {

        Box(modifier = Modifier.padding(16.dp),

        ) {
            Column(
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.align(Alignment.BottomCenter)
            ) {
                Text(
                    text = "Mega Luck",
                    color = Color.Green,
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Black,

                )
                Spacer(modifier = Modifier.height(3.dp))
                Image(
                    painter = painterResource(id = R.drawable.luck),
                    contentDescription = "Lucky clover ",
                    modifier = Modifier.size(250.dp).padding(all=20.dp),

                )
                Text(
                    text = numeros,
                    color = Color.Black,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Black
                )
            }
        }

        Button(onClick = { numeros = NumerosAleatorios() },
            modifier = Modifier.align(Alignment.CenterHorizontally)) {
            Text(text = "New Numbers!")
    }
}
}


fun NumerosAleatorios(): String {
    val listaNumbs = mutableListOf<Int>()
    while (listaNumbs.size < 6) {
        val randomNumber = Random.nextInt(1, 61)
        if (!listaNumbs.contains(randomNumber)) {
            listaNumbs.add(randomNumber)
        }
    }
    listaNumbs.sort()
    return listaNumbs.joinToString()
}



