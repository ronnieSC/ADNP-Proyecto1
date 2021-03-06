package com.c1ctech.jetpackcomposeexp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class GimnasioDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //passing plate instance from composable function
            GimnasioImageFullScreen(intent.getParcelableExtra("gimnasioData"))
        }
    }
}

@Composable
fun GimnasioImageFullScreen(gimnasio: Gimnasio?) {
    Image(
        painter = painterResource(gimnasio!!.imageResource),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    )
}
