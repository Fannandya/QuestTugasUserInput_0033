package com.mamay.userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Biodata(
    modifier: Modifier = Modifier
) {
    // variable untuk menyimpan data input dari user
    var textNamaDepan by remember {
        mutableStateOf("")
    }
    var textNamaBelakang by remember {
        mutableStateOf("")
    }
    var textEmail by remember {
        mutableStateOf("")
    }
    var textTanggalLahir by remember {
        mutableStateOf("")
    }
    var textPengalaman by remember {
        mutableStateOf("")
    }
    var textSkill by remember {
        mutableStateOf("")
    }

    // variable untuk menyimpan data dari komponen UI
    var namaDepan by remember {
        mutableStateOf("")
    }
    var namaBelakang by remember {
        mutableStateOf("")
    }
    var email by remember {
        mutableStateOf("")
    }
    var tanggalLahir by remember {
        mutableStateOf("")
    }
    var pengalaman by remember {
        mutableStateOf("")
    }
    var skill by remember {
        mutableStateOf("")
    }
    val listPengalaman = listOf(
        "< 1 tahun",
        "1-2 tahun",
        "3-5 tahun",
        "5-10 tahun",
        "> 10 tahun"
    )
    val listSkill = listOf(
        "UI/UX",
        "Programming",
        "Networking"
    )

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.ascii
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp)
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 270.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp
                    )
                )
                .background(
                    color = colorResource(
                        id = R.color.abu
                    )
                )
                .padding(
                    top = 18.dp,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 20.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ElevatedCard(
                modifier = Modifier
                    .fillMaxWidth(),
                shape = RoundedCornerShape(24.dp),
                colors = CardDefaults.elevatedCardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.elevatedCardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            horizontal = 24.dp,
                            vertical = 24.dp
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(id = R.string.greeting),
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.DarkGray
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.subheader),
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        OutlinedTextField(
                            value = textNamaDepan,
                            onValueChange = { textNamaDepan = it },
                            label = { Text(text = stringResource(id = R.string.label_namadepan)) },
                            modifier = Modifier
                                .weight(1f)
                        )
                        Spacer(modifier = Modifier.width(12.dp))
                        OutlinedTextField(
                            value = textNamaBelakang,
                            onValueChange = { textNamaBelakang = it },
                            label = { Text(text = stringResource(id = R.string.label_namabelakang))
                            },
                            modifier = Modifier
                                .weight(1f)
                        )
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                    ) {
                        OutlinedTextField(
                            value = textEmail,
                            onValueChange = { textEmail = it },
                            label = { Text(text = stringResource(id = R.string.label_email)) },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }
