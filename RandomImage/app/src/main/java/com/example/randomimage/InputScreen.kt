package com.example.randomimage

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.navigation.NavController
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun InputInformation(navController: NavController) {

    var InputHeight by remember { mutableStateOf("") }
    var InputWidth by remember { mutableStateOf("") }
    var InputCategory by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
        .verticalScroll(rememberScrollState())
        .padding(20.dp)
        .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 32.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        HeightSpace(
            value = InputHeight,
            onValueChange = { InputHeight = it })

        Spacer(modifier = Modifier.height(10.dp))

        WidthSpace(value = InputWidth,
            onValueChange = { InputWidth = it })

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(50.dp)
                .padding(start = 10.dp),
            onClick = {InputCategory = "kitten"},
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category_kitten),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(50.dp)
                .padding(start = 10.dp),
            onClick = {InputCategory = "bunny"},
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category_bunny),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(50.dp)
                .padding(start = 10.dp),
            onClick = {InputCategory = "bird"},
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category_bird),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(50.dp)
                .padding(start = 10.dp),
            onClick = {InputCategory = "sky"},
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category_sky),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(200.dp)
                .height(50.dp)
                .padding(start = 10.dp),
            onClick = {InputCategory = "sea"},
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = stringResource(R.string.category_sea),
                fontSize = 16.sp,
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(500.dp)
                .height(50.dp)
                .padding(start = 8.dp),
            onClick = { navController.navigate("image/$InputHeight/$InputWidth/$InputCategory") },
            shape = RoundedCornerShape(20.dp),
        ) {
            Text(
                text = "Generate Image",
                fontSize = 18.sp,
            )
        }

    }
}