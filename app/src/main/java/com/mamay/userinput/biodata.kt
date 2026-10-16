package com.mamay.userinput

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Biodata(
    modifier: Modifier
){
    // variable untuk menyimpan data input dari user
    var textNamaDepan by remember { mutableStateOf("") }
    var textNamaBelakang by remember { mutableStateOf("") }
    var textEmail by remember { mutableStateOf("") }
    var textTanggalLahir by remember { mutableStateOf("") }
    var textPengalaman by remember { mutableStateOf("") }
    var textSkill by remember { mutableStateOf("") }

    // variable untuk pengganti db
    var namaDepan by remember { mutableStateOf("") }
    var namaBelakang by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var tanggalLahir by remember { mutableStateOf("") }
    var pengalaman by remember { mutableStateOf("") }
    var skill by remember { mutableStateOf("") }

    // membuat list pengalaman dan skill
    val listPengalaman: List<String> = listOf("< 1tahun", "1-2 tahun", "3-5 tahun", "5-10 tahun", "> 10 tahun")
    val listSkill: List<String> = listOf("UI/UX", "Programming", "Networking")
}

