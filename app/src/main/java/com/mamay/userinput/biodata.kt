package com.mamay.userinput

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.TimeZone

@Composable
fun Biodata(
    modifier: Modifier = Modifier
) {
    // variable untuk menyimpan data input dari user
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggalLahir by remember { mutableStateOf("") }
    var textPengalaman by remember { mutableStateOf("") }
    var textSkill by remember { mutableStateOf("") }

    // variable untuk menyimpan data dari komponen UI
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }
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
    // variable untuk menampilkan date picker
    val datePickerState = rememberDatePickerState()
    var isDatePickerOpen by remember { mutableStateOf(false) }

    // variable untuk menampilkan snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()
    val snackbarActionLabel = stringResource(id = R.string.OK)

    // membuat state untuk mengatur buka/tutup dropdown
    var isExpDropdownExpanded by remember { mutableStateOf(false) }

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
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = stringResource(id = R.string.subheader),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(id = R.color.black)
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
                        Spacer(modifier = Modifier.width(10.dp))
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
                            .padding(
                                top = dimensionResource(id = R.dimen.padding_10),
                                bottom = dimensionResource(id = R.dimen.padding_10)),
                    ) {
                        OutlinedTextField(
                            value = textEmail,
                            onValueChange = { textEmail = it },
                            label = { Text(text = stringResource(id = R.string.label_email)) },
                            modifier = Modifier
                                .fillMaxWidth()
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            OutlinedTextField(
                                value = textTanggalLahir,
                                onValueChange = {textTanggalLahir = it},
                                label = { Text(stringResource(id = R.string.label_tanggallahir), fontSize = 12.sp) },
                                trailingIcon = {
                                    Icon(Icons.Default.DateRange, contentDescription = "Kalender")
                                },
                                readOnly = true,
                                modifier = Modifier.fillMaxWidth(),
                                singleLine = true
                            )
                            Spacer(
                                modifier = Modifier
                                    .matchParentSize()
                                    .clickable(onClickLabel = stringResource(id = R.string.label_tanggallahir)) {
                                        isDatePickerOpen = true
                                    }
                            )
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        ExposedDropdownMenuBox(
                            expanded = isExpDropdownExpanded,
                            onExpandedChange = { isExpDropdownExpanded = !isExpDropdownExpanded },
                            modifier = Modifier.weight(1f)
                        ) {
                            OutlinedTextField(
                                value = textPengalaman,
                                onValueChange = { textPengalaman = it },
                                readOnly = true, //agar tidak bisa diketik manual
                                label = { Text(stringResource(id = R.string.label_pengalaman), fontSize = 12.sp) },
                                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpDropdownExpanded)},
                                modifier = Modifier
                                    .menuAnchor() // untuk menghubungkan dibawah text field
                            )
                            ExposedDropdownMenu(
                                expanded = isExpDropdownExpanded,
                                onDismissRequest = { isExpDropdownExpanded = false }
                            ){
                                listPengalaman.forEach { exp ->
                                    DropdownMenuItem(
                                        text = {Text(exp)},
                                        onClick = {
                                            textPengalaman = exp
                                            isExpDropdownExpanded = false
                                        }
                                    )
                                }
                            }
                        }

                    }
                    if (isDatePickerOpen) {
                        DatePickerDialog(
                            onDismissRequest = { isDatePickerOpen = false },
                            confirmButton = {
                                TextButton(onClick = {
                                    datePickerState.selectedDateMillis?.let { millis ->
                                        textTanggalLahir = SimpleDateFormat(
                                            "dd/MM/yyyy",
                                            Locale.getDefault()
                                        ).apply {
                                            timeZone = TimeZone.getTimeZone("UTC")
                                        }.format(Date(millis))
                                    }
                                    isDatePickerOpen = false
                                }) {
                                    Text(stringResource(id = R.string.OK))
                                }
                            },
                            dismissButton = {
                                TextButton(onClick = { isDatePickerOpen = false }) {
                                    Text(stringResource(id = R.string.Cancel))
                                }
                            }
                        ) {
                            DatePicker(state = datePickerState)
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = stringResource(id = R.string.label_skill),
                            fontSize = 20.sp,
                            modifier = Modifier
                                .padding(top = dimensionResource(id = R.dimen.padding_20), bottom = dimensionResource(id = R.dimen.padding_20)),
                        )

                        Row {
                            listSkill.forEach { item ->
                                Row(
                                    modifier = Modifier
                                        //.padding(all = dimensionResource(id = R.dimen.padding_10))
                                        .weight(1f)
                                        .selectable(
                                            selected = textSkill == item,
                                            onClick = { textSkill = item}
                                        ),
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Checkbox(
                                        checked = textSkill == item,
                                        onCheckedChange = { textSkill = item}
                                    )
                                    Text(
                                        text = item,
                                        fontSize = 10.sp,
                                        fontWeight = FontWeight.Black,
                                        modifier = Modifier,
                                        textAlign = TextAlign.Left,
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 10.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Button(
                            modifier = Modifier
                                .fillMaxWidth(),
                            enabled = textEmail.isNotEmpty() && textTanggalLahir.isNotEmpty() && textNamaDepan.isNotEmpty() && textNamaBelakang.isNotEmpty() && textPengalaman.isNotEmpty(),
                            onClick = {
                                scope.launch {
                                    val skillList = if (textSkill.isEmpty()){
                                        "Belum memilih skill"
                                    } else{
                                        textSkill
                                    }
                                    val infoBiodata = """ 
                                        Nama Depan: $textNamaDepan
                                        Nama Belakang: $textNamaBelakang
                                        Email: $textEmail
                                        Tanggal Lahir: $textTanggalLahir
                                        Pengalaman: $textPengalaman
                                        Skill: $skillList
                                    """.trimIndent()
                                    snackbarHostState.showSnackbar(
                                        message = infoBiodata,
                                        actionLabel = snackbarActionLabel,
                                        withDismissAction = true
                                    )
                                }
                            },
                        ) {
                            Text(stringResource(id = R.string.button_submit),
                                color = Color.Black

                            )
                        }
                    }

                }

                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
}
