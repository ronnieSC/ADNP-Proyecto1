package com.c1ctech.jetpackcomposeexp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import com.c1ctech.jetpackcomposeexp.ui.theme.JetpackComposeExpTheme
import kotlinx.android.parcel.Parcelize
import androidx.compose.foundation.Image as Image

val distrito_name_alto_selva_alegre = "Alto Selva Alegre"
val distrito_name_cayma = "Cayma"
val distrito_name_cerro_colorado = "Cerro Colorado"
val distrito_name_jlb = "José Luis Bustamante y Rivero"
val distrito_name_paucarpata = "Paucarpata"
val distrito_name_socabaya = "Socabaya"
val distrito_name_yanahuara = "Yanahuara"

val distrito_description_alto_selva_alegre = "3 gimnasios"
val distrito_description_cayma = "4 gimnasios"
val distrito_description_cerro_colorado = "3 gimnasios"
val distrito_description_jlb = "2 gimnasios"
val distrito_description_paucarpata = "3 gimnasios"
val distrito_description_socabaya = "2 gimnasios"
val distrito_description_yanahuara = "3 gimnasios"

//Aquí vendrá la lista
val distritos_lista: List<Distrito> = listOf(
    Distrito(R.drawable.distrito_alto_selva_alegre, distrito_name_alto_selva_alegre, distrito_description_alto_selva_alegre),
    Distrito(R.drawable.distrito_cayma, distrito_name_cayma, distrito_description_cayma),
    Distrito(R.drawable.distrito_cerro_colorado, distrito_name_cerro_colorado, distrito_description_cerro_colorado),
    Distrito(R.drawable.distrito_jlbyr, distrito_name_jlb, distrito_description_jlb),
    Distrito(R.drawable.distrito_paucarpata, distrito_name_paucarpata, distrito_description_paucarpata),
    Distrito(R.drawable.distrito_socabaya, distrito_name_socabaya, distrito_description_socabaya),
    Distrito(R.drawable.distrito_yanahuara, distrito_name_yanahuara, distrito_description_yanahuara),
)

class DistritosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeExpTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    //Material Design top app bar displays information and actions relating to the current screen.
                    TopAppBar(title = {
                        Text("Distritos y Gimnasios")
                    })
                    DistritoList(distritos_lista, this@DistritosActivity)
                }
            }
        }
    }
}

@Parcelize
data class Distrito(
    @DrawableRes val imageResource: Int,
    val distrito_name: String,
    val distrito_description: String
) : Parcelable

@Composable
fun DistritoList(distritos: List<Distrito>, context: Context) {
    //The vertically scrolling list that only composes and lays out the currently visible items.
    LazyColumn() {
        items(distritos) { distrito ->
            DistritoListItem(distrito, context)
        }
    }
}

@Composable
fun DistritoListItem(distrito: Distrito, context: Context) {
    //used to make a CardView.
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                //open DetailActivity on item click
                val intent = Intent(context, GimnasiosActivity::class.java)
                intent.putExtra("distritoData", distrito)
                startActivity(context, intent, null)

            }
    ) {
        //places its children in a horizontal sequence.
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            DistritoImage(distrito)
            //places its children in a vertical sequence.
            Column(
                modifier = Modifier
                    .weight(6f, true)
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
            ) {
                //used to display text
                Text(
                    text = distrito.distrito_name,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Red
                )
                Text(
                    text = "${distrito.distrito_description}",
                    style = MaterialTheme.typography.subtitle2,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue,
                )

            }
        }
    }
}


@Composable
fun DistritoImage(distrito: Distrito?) {
    //used to display an image.
    Image(
        painter = painterResource(distrito!!.imageResource),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(8.dp)))
    )
}

//Preview can be applied to @Composable methods with no parameters
//to show them in the Android Studio preview.
@Preview
@Composable
fun distritoListPreview() {
    JetpackComposeExpTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text("Escoja el distrito")
            })
            DistritoList(
                distritos_lista,
                LocalContext.current
            )
        }
    }
}


