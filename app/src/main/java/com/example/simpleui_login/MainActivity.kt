package com.example.simpleui_login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.simpleui_login.ui.theme.SimpleUi_LoginTheme
import com.example.simpleui_login.view.LoginPage
import com.example.simpleui_login.view.Register

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            SimpleUi_LoginTheme {
             navigatePage()
            }
        }
    }
}
@Composable
fun navigatePage(){
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination = "login_page",
        builder = {

            composable("login_page", content = { LoginPage(navController = navController)})
            composable("register_page", content = { Register(navController = navController) })
        })
}