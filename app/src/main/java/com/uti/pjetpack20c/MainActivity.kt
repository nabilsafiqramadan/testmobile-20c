package com.uti.pjetpack20c

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uti.pjetpack20c.ui.theme.PJetpack20CTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PJetpack20CTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
//                    Greeting("Android")
//                    Text(text = "Coba Jetpack Compose")
//                    Kesamping Pake row(horizontal) kebawah pake colum(vertikal)
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Yellow)) {
//                        Text(text = "Coba Jetpack Compose")
//                        Greeting("Android")
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(start = 10.dp, end = 10.dp)) {
                            Text(text = "Coba Jetpack Compose")
                            Greeting("Android")
                        }
//                        jarak pake spacer atau margin(padding
                        Spacer(modifier = Modifier.padding(10.dp))

                        
                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Cyan)
                            .padding(start = 10.dp, end = 10.dp)) {
                            Text(text = "Coba Jetpack Compose")
                            Greeting("Android 2")
                            val context = LocalContext.current

//                            konstanta nilai yang tak bisa berubah atau tetap/ bisa di rubah tapi pas perogram di jalankan
                            //        buatt Botton
                            Button(onClick = {
//                                isi event untuk click
//                                 Buat Variiabel
//                                             val (imutable) Tidak bisa berubah
//                                             var (mutabel) Bisa Berubah ubah
//                                             var test = "Oke"
//                                            test = "Yes"
//                                            test = "Ya"

                                             val nilai1 = 10
                                             val nilai2 = 3
                                            var nilai3 = nilai1.toFloat() / nilai2

//                                  buat variabel untuk konteks


                                Toast.makeText(context, nilai3.toString(),Toast.LENGTH_SHORT).show();




                            }, modifier = Modifier.fillMaxWidth().height(35.dp),colors = ButtonDefaults.buttonColors(Color.Black),
                            ) {
//                                isi teks pada tombol/button
                                Text(text = "Proses",color = Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PJetpack20CTheme {
        Greeting("Android")
    }
}