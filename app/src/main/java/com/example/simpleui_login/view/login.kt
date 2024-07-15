package com.example.simpleui_login.view

import android.annotation.SuppressLint
import android.media.Image
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
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.simpleui_login.R
import com.example.simpleui_login.ui.theme.Purple80

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "ResourceType")
@Composable
fun LoginPage(navController: NavController) {
    val context= LocalContext.current
    val scaffoldState= rememberScaffoldState()
    val emailVal= remember {
        mutableStateOf("")
    }
    val passwordVal= remember {
        mutableStateOf("")
    }
    val passwordVisibility= remember {
        mutableStateOf(false)
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.White), contentAlignment = Alignment.Center){


            Column(horizontalAlignment = Alignment.CenterHorizontally
            , verticalArrangement =Arrangement.Center
                , modifier = Modifier.fillMaxWidth()
            ) {
                Box(modifier = Modifier.background(Color.White),
                    contentAlignment = Alignment.TopCenter
                    ){
                    androidx.compose.foundation.Image(modifier = Modifier
                        .width(400.dp)
                        .height(350.dp),
                       painter =  painterResource(R.drawable.lock)
                           , contentDescription = "Login Image"
                        , contentScale = ContentScale.Fit
                    )
                }
                Spacer(modifier =Modifier.padding(5.dp))

                Scaffold(modifier = Modifier.fillMaxSize(),scaffoldState=scaffoldState) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally
                    ,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(10.dp)
                        ) {
                        Text(text = "Sign In"
                        , fontSize = 30.sp,
                            fontWeight = FontWeight.Bold
                            , color = Black

                        )
                        Spacer(modifier =Modifier.padding(20.dp))
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            OutlinedTextField(value = emailVal.value, onValueChange ={emailVal.value=it},
                                label = {Text(text = "Email Address", color = Black)},
                                placeholder = {Text(text = "Email Address", color = Black)},
                                singleLine = true
                                , modifier = Modifier.fillMaxWidth(0.8f),
                                colors = TextFieldDefaults.outlinedTextFieldColors(unfocusedBorderColor = Black, textColor = Black)

                                )
                        }
                        OutlinedTextField(
                            value =passwordVal.value
                            , onValueChange ={passwordVal.value=it}
                        , colors = TextFieldDefaults.outlinedTextFieldColors(
                            unfocusedBorderColor = Black, textColor = Black
                        ),
                            trailingIcon = {
                                IconButton(onClick = {
                                    passwordVisibility.value=!passwordVisibility.value
                                }) {
                                    Icon(
                                        painter = painterResource(R.drawable.baseline_face_retouching_natural_24)
                                        , contentDescription ="Password",
                                        tint = if (passwordVisibility.value) Purple80 else Gray
                                        )

                                }
                            },
                            label = { Text(text = "Password", color = Black)},
                            placeholder = { Text(text = "Password", color = Black)},
                            singleLine = true,
                            visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                            modifier = Modifier.fillMaxWidth(0.8f)
                            )

                        Spacer(modifier = Modifier.padding(10.dp))
                        Button(colors =androidx.compose.material.ButtonDefaults.buttonColors(backgroundColor = White),
                            onClick  ={
                                when{
                                    emailVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please,enter email address",Toast.LENGTH_LONG).show()
                                    }
                                    passwordVal.value.isEmpty()->{
                                        Toast.makeText(context,"Please,enter password",Toast.LENGTH_LONG).show()
                                    }
                                    else-> Toast.makeText(context,"Logged Successfully",Toast.LENGTH_LONG).show()

                                }
                        }
                            , modifier = Modifier
                                .fillMaxWidth(0.8f)
                                .height(50.dp)
                            ) {
                            Text(text = "Sign In", fontSize = 20.sp, color = Black)
                        }

                        Spacer(modifier = Modifier.padding(13.dp))
                        Text(
                            text = "Create and Account?",
                            color = Black,
                            modifier = Modifier.clickable { navController.navigate("register_page") })

                        Spacer(modifier = Modifier.padding(14.dp))
                    }


                }

            }

    }
}