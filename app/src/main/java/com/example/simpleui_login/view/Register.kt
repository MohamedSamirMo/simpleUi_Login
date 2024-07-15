package com.example.simpleui_login.view

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simpleui_login.R
import com.example.simpleui_login.ui.theme.Purple80

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Register(navController:NavController){
    val context= LocalContext.current
    val scaffoldState= rememberScaffoldState()
    val nameVal= remember {
        mutableStateOf("")
    }
    val emailVal= remember {
        mutableStateOf("")
    }
    val phoneVal= remember {
        mutableStateOf("")
    }

    val passwordVal= remember {
        mutableStateOf("")
    }
    val confirmPasswordVal= remember {
        mutableStateOf("")
    }
    val passwordVisibility= remember {
        mutableStateOf(false)
    }
    val confirmPasswordVisibility= remember {
        mutableStateOf(false)
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White), contentAlignment = Alignment.Center){


        Column(horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement = Arrangement.Center
            , modifier = Modifier.fillMaxWidth()
        ) {
            Box(modifier = Modifier.background(Color.White),
                contentAlignment = Alignment.TopCenter
            ){
                Image(modifier = Modifier
                    .width(330.dp)
                    .height(300.dp),
                    painter =  painterResource(R.drawable.registers)
                    , contentDescription = "Register Image"
                    , contentScale = ContentScale.Fit
                )
            }

//            Scaffold(modifier = Modifier.fillMaxSize(),scaffoldState=scaffoldState) {
//                Column(horizontalAlignment = Alignment.CenterHorizontally
//                    ,
//                    verticalArrangement = Arrangement.Center,
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(Color.White)
//                        .padding(10.dp)
//                ) {
//                    Text(text = "Sign Up"
//                        , fontSize = 30.sp,
//                        fontWeight = FontWeight.Bold
//                        , color = Color.Black
//
//                    )
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(value = nameVal.value, onValueChange ={nameVal.value=it},
                            label = {Text(text = "User Name", color = Color.Black)},
                            placeholder = {Text(text = "User Name", color = Color.Black)},
                            singleLine = true
                            , modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black, textColor = Color.Black)

                        )
}
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(value = emailVal.value, onValueChange ={emailVal.value=it},
                            label = {Text(text = "Email Address", color = Color.Black)},
                            placeholder = {Text(text = "Email Address", color = Color.Black)},
                            singleLine = true
                                ,    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            modifier = Modifier.fillMaxWidth(0.8f),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black, textColor = Color.Black)

                        )
                }
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        OutlinedTextField(value = phoneVal.value, onValueChange ={phoneVal.value=it},
                            label = {Text(text = "Phone Number", color = Color.Black)},
                            placeholder = {Text(text = "Phone Number", color = Color.Black)},
                            singleLine = true
                            , modifier = Modifier.fillMaxWidth(0.8f),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                            colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Color.Black, textColor = Color.Black)

                        )
        }
                    OutlinedTextField(
                        value =passwordVal.value
                        , onValueChange ={passwordVal.value=it}
                        , colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black, textColor = Color.Black
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                passwordVisibility.value=!passwordVisibility.value
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_face_retouching_natural_24)
                                    , contentDescription ="Password",
                                    tint = if (passwordVisibility.value) Purple80 else Color.Gray
                                )

                            }
                        },
                        label = { Text(text = "Password", color = Color.Black)},
                        placeholder = { Text(text = "Password", color = Color.Black)},
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )

                    OutlinedTextField(
                        value =confirmPasswordVal.value
                        , onValueChange ={confirmPasswordVal.value=it}
                        , colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Color.Black, textColor = Color.Black
                        ),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value=!confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    painter = painterResource(R.drawable.baseline_face_retouching_natural_24)
                                    , contentDescription ="confirmPassword",
                                    tint = if (confirmPasswordVisibility.value) Purple80 else Color.Gray
                                )

                            }
                        },
                        label = { Text(text = "confirmPassword", color = Color.Black)},
                        placeholder = { Text(text = "confirmPassword", color = Color.Black)},
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier.fillMaxWidth(0.8f)
                    )
                    Spacer(modifier = Modifier.padding(5.dp))
                    Button(colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
                        onClick  ={
                            when{
                                nameVal.value.isEmpty()->{
                                    Toast.makeText(context,"Please,enter UserName", Toast.LENGTH_LONG).show()
                                }
                                emailVal.value.isEmpty()->{
                                    Toast.makeText(context,"Please,enter email address", Toast.LENGTH_LONG).show()
                                }
                                phoneVal.value.isEmpty()->{
                                    Toast.makeText(context,"Please,enter Phone Number", Toast.LENGTH_LONG).show()
                                }
                                passwordVal.value.isEmpty()->{
                                    Toast.makeText(context,"Please,enter password", Toast.LENGTH_LONG).show()
                                }
                                confirmPasswordVal.value.isEmpty()->{
                                    Toast.makeText(context,"Please,enter Confirm password", Toast.LENGTH_LONG).show()
                                }
                                else-> Toast.makeText(context,"registered Successfully", Toast.LENGTH_LONG).show()
                                



                            }
                        }
                        , modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .height(50.dp)
                    ) {
                        Text(text = "Sign Up", fontSize = 20.sp, color = Color.Black)
                    }

            Spacer(modifier = Modifier.padding(4.dp))

                    Text(
                        text = "Login Instead",
                        color = Color.Black,
                         fontSize = 16.sp,
                        modifier = Modifier.clickable { navController.navigate("login_page") })




                }}}
//}}