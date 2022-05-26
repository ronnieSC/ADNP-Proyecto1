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

val gimnasios_alto_selva_alegre_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Leo",
        "Alto Selva Alegre 04003",
        "Lunes a Sábado 06:00 - 21:00",
        "www.gimnasioleo.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "BODY CORP",
        "Alto Selva Alegre 04000",
        "Lunes a Domingo 09:00 - 21:00",
        "body-corp-sauna-y-gimnasio.negio.site (054) 529577"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Club Gym The Rock",
        "Av. Las Torres 16, ASA",
        "Lunes a Domingo 08:00 - 22:00",
        "949908860"
    ),
)

val gimnasios_cayma_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Smart Fit - Mall Plaza Arequipa",
        "Av. Ejército 793 3er piso C.C Mall Plaza Arequipa, Cayma 04000",
        "Lunes a Domingo 06:00 - 22:30",
        "smartfit.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "BODY TRAINING",
        "Jr. Hermanos Humbert Mz M2 Lt 7 Las Malvinas de Alto Cayma (Bs. Aires - Cayma 04018",
        "Lunes a Sábado 06:00 - 22:00",
        "989502326"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Charros Gym",
        "Av. Ramón Castilla 210, Cayma 04018",
        "Lunes a Sábado 06:00 - 22:00, Domingo 06:00 - 09:00, 17:00 - 20:30",
        "959145438"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Sauna Scorpio",
        "Cayma, Huayna Cápac 104, Buenos Aires",
        "Lunes a Domingo 08:00 - 22:00",
        "(054) 458716"
    ),
)

val gimnasios_cerro_colorado_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Revo Sport Cerro Colorado",
        "Ca. Miguel Grau 110, Arequipa 04000",
        "Lunes a Sábado 05:00 - 22:00",
        "https://www.facebook.com/revosportcerrocolorado/ (054) 583555"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Smart Fit Arequipa Center",
        "C.C. Arequipa Center, Av. Aviación 602, Cerro Colorado 04014",
        "Lunes a Viernes 06:00 - 22:30",
        "smartfit.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Nuevo Nivel Fitness & Health Crossfit",
        "Los Pinos, Cerro Colorado 04014",
        "Lunes a Domingo 05:30 - 21:00",
        "nuevonivelcrossfit.fitcoapp.net 982072510"
    ),
)

val gimnasios_yanahuara_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Dynamic Gym",
        "Ca. Vinatea Reynoso #110, Yanahuara 04013",
        "Lunes a Domingo 06:00 - 22:30",
        "991541698"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Club Gym",
        "Av. Emmel 04013",
        "Lunes a Domingo 06:00 - 22:00",
        "(054) 484940"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "DG Gym Madrid",
        "Av. Victor Andrés Belaunde 409, Arequipa 04013",
        "Lunes a Domingo 06:00 - 22:00",
        "(054) 484395"
    ),
)

val gimnasios_socabaya_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gym New Line",
        "Av. Socabaya 402-424, JLByR 04012",
        "Lunes a Sábado 05:30 - 21:30",
        "984616484"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gilmar Gym",
        "Av. Perú 204, Arequipa 04009",
        "Lunes a Sábado 06:00 - 20:30",
        "984616484"
    ),
)

val gimnasios_paucarpata_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gym Revo Sport",
        "Paucarpata 302, Arequipa 04001",
        "Lunes a Sábado 05:00 - 22:00",
        "(054) 201111"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Fire Gym",
        "Ca. Colombia con Honduras 100, Miguel Grau 4ta Etapa",
        "Lunes a Sábado 05:00 - 21:00",
        "951216782"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Ocon Gym",
        "Arequipa 992, Paucarpat 04007",
        "Lunes a Sábado 05:00 - 22:00",
        "991285549"
    ),
)

val gimnasios_jlb_lista: List<Gimnasio> = listOf(
    Gimnasio(
        R.drawable.costa_ceviche,
        "Imperium Fitness",
        "Av. Pizarro 141, José Luis Bustamante y Rivero 04009",
        "Lunes a Sábado 05:00 - 22:30",
        "942605645"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Club Gym",
        "Av. Emmel con, Arequipa 04013",
        "Lunes a Sábado 06:00 - 22:00",
        "(054) 484940"
    ),
)

val gimnasios_lista: List<Gimnasio> = listOf(
    //ASA
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Leo",
        "Alto Selva Alegre 04003",
        "Lunes a Sábado 06:00 - 21:00",
        "www.gimnasioleo.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "BODY CORP",
        "Alto Selva Alegre 04000",
        "Lunes a Domingo 09:00 - 21:00",
        "body-corp-sauna-y-gimnasio.negio.site (054) 529577"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Club Gym The Rock",
        "Av. Las Torres 16, ASA",
        "Lunes a Domingo 08:00 - 22:00",
        "949908860"
    ),

    //Cayma
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Smart Fit - Mall Plaza Arequipa",
        "Av. Ejército 793 3er piso C.C Mall Plaza Arequipa, Cayma 04000",
        "Lunes a Domingo 06:00 - 22:30",
        "smartfit.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "BODY TRAINING",
        "Jr. Hermanos Humbert Mz M2 Lt 7 Las Malvinas de Alto Cayma (Bs. Aires - Cayma 04018",
        "Lunes a Sábado 06:00 - 22:00",
        "989502326"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Charros Gym",
        "Av. Ramón Castilla 210, Cayma 04018",
        "Lunes a Sábado 06:00 - 22:00, Domingo 06:00 - 09:00, 17:00 - 20:30",
        "959145438"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Sauna Scorpio",
        "Cayma, Huayna Cápac 104, Buenos Aires",
        "Lunes a Domingo 08:00 - 22:00",
        "(054) 458716"
    ),

    //Cerro Colorado
    Gimnasio(
        R.drawable.costa_ceviche,
        "Revo Sport Cerro Colorado",
        "Ca. Miguel Grau 110, Arequipa 04000",
        "Lunes a Sábado 05:00 - 22:00",
        "https://www.facebook.com/revosportcerrocolorado/ (054) 583555"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Smart Fit Arequipa Center",
        "C.C. Arequipa Center, Av. Aviación 602, Cerro Colorado 04014",
        "Lunes a Viernes 06:00 - 22:30",
        "smartfit.com.pe"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Nuevo Nivel Fitness & Health Crossfit",
        "Los Pinos, Cerro Colorado 04014",
        "Lunes a Domingo 05:30 - 21:00",
        "nuevonivelcrossfit.fitcoapp.net 982072510"
    ),

    //Yanahuara
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Dynamic Gym",
        "Ca. Vinatea Reynoso #110, Yanahuara 04013",
        "Lunes a Domingo 06:00 - 22:30",
        "991541698"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Club Gym",
        "Av. Emmel 04013",
        "Lunes a Domingo 06:00 - 22:00",
        "(054) 484940"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "DG Gym Madrid",
        "Av. Victor Andrés Belaunde 409, Arequipa 04013",
        "Lunes a Domingo 06:00 - 22:00",
        "(054) 484395"
    ),

    //Socabaya
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gym New Line",
        "Av. Socabaya 402-424, JLByR 04012",
        "Lunes a Sábado 05:30 - 21:30",
        "984616484"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gilmar Gym",
        "Av. Perú 204, Arequipa 04009",
        "Lunes a Sábado 06:00 - 20:30",
        "984616484"
    ),

    //Paucarpata
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gym Revo Sport",
        "Paucarpata 302, Arequipa 04001",
        "Lunes a Sábado 05:00 - 22:00",
        "(054) 201111"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Fire Gym",
        "Ca. Colombia con Honduras 100, Miguel Grau 4ta Etapa",
        "Lunes a Sábado 05:00 - 21:00",
        "951216782"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Ocon Gym",
        "Arequipa 992, Paucarpat 04007",
        "Lunes a Sábado 05:00 - 22:00",
        "991285549"
    ),

    //JLByR
    Gimnasio(
        R.drawable.costa_ceviche,
        "Imperium Fitness",
        "Av. Pizarro 141, José Luis Bustamante y Rivero 04009",
        "Lunes a Sábado 05:00 - 22:30",
        "942605645"
    ),
    Gimnasio(
        R.drawable.costa_ceviche,
        "Gimnasio Club Gym",
        "Av. Emmel con, Arequipa 04013",
        "Lunes a Sábado 06:00 - 22:00",
        "(054) 484940"
    ),

)


class GimnasiosActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            /*JetpackComposeExpTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    //Material Design top app bar displays information and actions relating to the current screen.
                    TopAppBar(title = {
                        Text("Platillos")
                    })
                    PlateList(platos_lista, this@MainActivity)
                }
            }*/
            DistritoListIntent(intent.getParcelableExtra("distritoData"))
        }
    }
}

@Parcelize
data class Gimnasio(
    @DrawableRes val imageResource: Int,
    val gimnasio_name: String,
    val gimnasio_address: String,
    val gimnasio_hours: String,
    val gimnasio_contact: String
) : Parcelable

@Composable
fun GimnasioList(gimnasios: List<Gimnasio>, context: Context) {
    //The vertically scrolling list that only composes and lays out the currently visible items.
    LazyColumn() {
        items(gimnasios) { gimnasio ->
            GimnasioListItem(gimnasio, context)
        }
    }
}

@Composable
fun GimnasioListItem(gimnasio: Gimnasio, context: Context) {
    //used to make a CardView.
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier
            .padding(16.dp)
            .clickable {
                //open DetailActivity on item click
                val intent = Intent(context, GimnasioDetailActivity::class.java)
                intent.putExtra("gimnasioData", gimnasio)
                startActivity(context, intent, null)

            }
    ) {
        //places its children in a horizontal sequence.
        Row(
            modifier = Modifier
                .padding(8.dp)
        ) {
            GimnasioImage(gimnasio)
            //places its children in a vertical sequence.
            Column(
                modifier = Modifier
                    .weight(6f, true)
                    .padding(20.dp, 0.dp, 0.dp, 0.dp),
            ) {
                //used to display text
                Text(
                    text = gimnasio.gimnasio_name,
                    style = MaterialTheme.typography.subtitle1,
                    color = Color.Red
                )
                Text(
                    text = "${gimnasio.gimnasio_address}",
                    style = MaterialTheme.typography.subtitle2,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    color = Color.Blue
                )
                Text(
                    text = "${gimnasio.gimnasio_hours}",
                    style = MaterialTheme.typography.body1,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray
                )
                Text(
                    text = "${gimnasio.gimnasio_contact}",
                    style = MaterialTheme.typography.body2,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                )

            }
        }
    }
}


@Composable
fun GimnasioImage(gimnasio: Gimnasio?) {
    //used to display an image.
    Image(
        painter = painterResource(gimnasio!!.imageResource),
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
fun GimnasioListPreview() {
    JetpackComposeExpTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text("Gimnasios")
            })
            GimnasioList(
                gimnasios_lista,
                LocalContext.current
            )
        }
    }
}

@Composable
fun DistritoListIntent(distrito: Distrito?) {
    /*Image(
        painter = painterResource(region!!.imageResource),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(16.dp)
    )*/

    JetpackComposeExpTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            TopAppBar(title = {
                Text("Gimnasios en ${distrito!!.distrito_name}")
            })
            GimnasioList(
                obtenerLista(distrito),
                LocalContext.current
            )
        }
    }
}

fun obtenerLista(distrito: Distrito?): List<Gimnasio> {
    var lista_de_gimnasios: List<Gimnasio> = gimnasios_alto_selva_alegre_lista

    if(distrito!!.distrito_name == distrito_name_alto_selva_alegre) {
        lista_de_gimnasios = gimnasios_alto_selva_alegre_lista
    }

    if(distrito!!.distrito_name == distrito_name_cayma) {
        lista_de_gimnasios = gimnasios_cayma_lista
    }

    if(distrito!!.distrito_name == distrito_name_cerro_colorado) {
        lista_de_gimnasios = gimnasios_cerro_colorado_lista
    }

    if(distrito!!.distrito_name == distrito_name_yanahuara) {
        lista_de_gimnasios = gimnasios_yanahuara_lista
    }

    if(distrito!!.distrito_name == distrito_name_socabaya) {
        lista_de_gimnasios = gimnasios_socabaya_lista
    }

    if(distrito!!.distrito_name == distrito_name_paucarpata) {
        lista_de_gimnasios = gimnasios_paucarpata_lista
    }

    if(distrito!!.distrito_name == distrito_name_jlb) {
        lista_de_gimnasios = gimnasios_jlb_lista
    }

    return lista_de_gimnasios
}