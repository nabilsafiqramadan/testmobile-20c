package com.uti.pjetpack20c

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uti.pjetpack20c.ui.theme.PJetpack20CTheme

class IO : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PJetpack20CTheme {
//                buat variabel untuk input nilai 1
                var txt_nilai1 by remember {
                    mutableStateOf("")
                }

//                buat variabel untuk input nilai 2
                var txt_nilai2 by remember {
                    mutableStateOf("")
                }
                //buat variabel untuk input hasil
                var txt_hasil by remember {
                    mutableStateOf("")
                }

//                buat avariabel untuk batas karakter
                val limit = 13
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//          BUAT AREA LAYOUT
                    Column(modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp)) {
//                        buat objek textfield gunakan petik dan kurung kurawa seperti pada gambar di bawah
                        OutlinedTextField(label = {
                                          Text(text = "Klik Disini Kak")
                        },value = txt_nilai1, onValueChange ={
//                            Jika Jumlah karakter <= limit 13
                            if (it.length <= limit) {
                                txt_nilai1 = it //it itu artinya menunjuk ke variabel
                            }
                        },





                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors
                            (containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Green,  //garis tabel nya kjadi hijau jika di pencet
                                unfocusedIndicatorColor = Color.Blue,
                            focusedLabelColor = colorResource(id = R.color.Warna1) //fokus ke warna tulisan ketika di pencet
                            ), keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number),
                            placeholder = {
                                Text(text = "Isikan No Hp Pembeli")
                            }
                        )
//                        Buat Spacer
                        Spacer(modifier = Modifier.padding((5.dp)))


//                      Buat Input Nilai 2
                        OutlinedTextField(label = {
                            Text(text = "Klik Disini bang")
                        },value = txt_nilai2, onValueChange ={
//                            Jika Jumlah karakter <= limit 13
                            if (it.length <= limit) {
                                txt_nilai2 = it //it itu artinya menunjuk ke variabel
                            }
                        },





                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors
                                (containerColor = Color.Transparent,
                                focusedIndicatorColor = Color.Green,  //garis tabel nya kjadi hijau jika di pencet
                                unfocusedIndicatorColor = Color.Blue,
                                focusedLabelColor = colorResource(id = R.color.Warna1) //fokus ke warna tulisan ketika di pencet
                            ), keyboardOptions =  KeyboardOptions(keyboardType = KeyboardType.Number),
                            placeholder = {
                                Text(text = "Isikan No Hp Pembeli2")
                            }
                        )


                        //                        Buat Spacer
                        Spacer(modifier = Modifier.padding((5.dp)))


//                      Buat output hasil
                        OutlinedTextField(label = {
                            Text(text = "Hasil")
                        },value = txt_hasil, onValueChange ={

                                txt_hasil = it //it itu artinya menunjuk ke variabel
                        },





                            modifier = Modifier.fillMaxWidth(),
                            colors = TextFieldDefaults.textFieldColors(
                                disabledIndicatorColor = Color.Blue,
                                disabledTextColor = Color.Red//fokus ke warna tulisan ketika di pencet
                            ), enabled = false //karena hasil tidak boleh di input maka jangan sampai bisa di isi
                        )



                        //                        Buat Spacer
                        Spacer(modifier = Modifier.padding((5.dp)))
                        val context = LocalContext.current
                        val operator =
                            arrayOf(
                                "Pilih Operasi",
                                "Tambah (+)",
                                "Kurang (-)",
                                "Kali (x)",
                                "Bagi (/)"
                            )
                        var expanded by remember { mutableStateOf(false) }
                        var selectedText by remember { mutableStateOf(operator[0]) }


                        ExposedDropdownMenuBox(
                            expanded = expanded,
                            onExpandedChange = {
                                expanded = !expanded
                            }
                        ) {
                            OutlinedTextField(
                                value = selectedText,
                                onValueChange = {},
                                readOnly = true,
                                trailingIcon = {
                                    ExposedDropdownMenuDefaults.TrailingIcon(
                                        expanded = expanded
                                    )
                                },
                                modifier = Modifier.fillMaxWidth(),
                                colors = TextFieldDefaults.textFieldColors(
                                    containerColor = Color.Transparent,
                                    disabledIndicatorColor = Color.Black,
                                    focusedIndicatorColor = Color.Red,
                                    unfocusedIndicatorColor = Color.Black
                                )
                            )

                            ExposedDropdownMenu(
                                expanded = expanded,
                                onDismissRequest = { expanded = false }
                            ) {
                                operator.forEach { item ->
                                    DropdownMenuItem(
                                        text = { Text(text = item) },
                                        onClick = {
                                            selectedText = item
                                            expanded = false

                                            if(selectedText == operator[0]) {
                                                Toast.makeText(
                                                    context,
                                                    "Jenis Operasi Belum Dipilih !",
                                                    Toast.LENGTH_SHORT
                                                ).show()
                                            }
                                        }
                                    )

                                }
                            }
                        }

                        Spacer(modifier = Modifier.padding(5.dp))

                        Row(modifier = Modifier.fillMaxWidth()) {
//                            buat  btn hitung
                            Button(modifier =  Modifier.weight(1f), onClick = {

//                                isi proses perhitungan
//                                JIKA DROP DOWN = 1 (TAMBAH)
                                if(selectedText == operator[1]){
                                    txt_hasil=(
                                            txt_nilai1.toInt() + txt_nilai2.toInt()).toString()
                                }

//                                 jika drop down = 2 (Kurang)
                                if(selectedText == operator[2]){
                                    txt_hasil=(
                                            txt_nilai1.toInt() - txt_nilai2.toInt()).toString()
                                }
                                //                                 jika drop down = 3 (Kali)
                                if(selectedText == operator[3]){
                                    txt_hasil=(
                                            txt_nilai1.toInt() * txt_nilai2.toInt()).toString()
                                }
//                                Jika drown = 4 (bagi)
                                if(selectedText == operator[4]){
                                    txt_hasil=(
                                            txt_nilai1.toFloat() / txt_nilai2.toInt()).toString()
                                }
//                                var hasil =0
//                                hasil=  txt_nilai1.toInt() + txt_nilai2.toInt()
//                                txt_hasil=(
//                                    txt_nilai1.toInt() + txt_nilai2.toInt()).toString()
 //                               txt_hasil= hasil.toString()

                            }) {
                                Text(text = "Hitung")

                            }
                            Spacer(modifier = Modifier.padding((5.dp)))
//                            buat  btn Reset
                            Button(modifier =  Modifier.weight(1f), onClick = {
                                txt_hasil= ""
                                txt_nilai1=""
                                txt_nilai2=""
                            }) {
                                Text(text = "Reeset")

                            }


                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    PJetpack20CTheme {

    }
}