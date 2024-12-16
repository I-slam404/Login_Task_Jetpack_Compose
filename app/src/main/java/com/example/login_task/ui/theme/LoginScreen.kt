@file:Suppress("DEPRECATION")

package com.example.login_task.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.weight
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.login_task.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInScreen() {

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Logo
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Medica Prof Logo",
            modifier = Modifier
                .height(120.dp)
                .width(240.dp)
        )

        // Sign in text
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Start
        ) {
            Text(
                text = "Sign in",
                style = MaterialTheme.typography.headlineMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )
        }

        Text(
            text = "please enter your email or phone number to continue",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray,
            modifier = Modifier.padding(bottom = 24.dp)
        )


        Text(
            text = "Email or phone number",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            modifier = Modifier.align(alignment = Alignment.Start),
            fontSize = 12.sp
        )

        // Email/Phone TextField
        TextField(
            value = email,
            onValueChange = { email = it },
            //label = { Text("Email or phone number") },
            modifier = Modifier
                .background(color = Color.White , shape = RectangleShape)
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),

            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent, 
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                unfocusedLabelColor = Color.Gray
            )
        )

        Text(
            text = "Password",
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black,
            modifier = Modifier.align(alignment = Alignment.Start),
            fontSize = 12.sp
        )

        // Password TextField
        TextField(
            value = password,
            onValueChange = { password = it },
            //label = { Text("Password") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            singleLine = true,
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Hide password" else "Show password"
                    )
                }
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Gray,
                focusedIndicatorColor = Color.Black,
                unfocusedLabelColor = Color.Gray
            )
        )

        // Sign in Button
        Button(
            onClick = {/*onClick*/ },
            modifier = Modifier
                .height(60.dp)
                .fillMaxWidth()
                .padding(4.dp),
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4267B2),
                contentColor = Color.White
            )
        ) {
            Text("Sign in")
        }

        // Forgot password link
        TextButton(
            onClick = { /* forgot password */ },
            modifier = Modifier.padding(vertical = 8.dp)
        ) {
            Text(
                "Forget your account or password",
                color = Color(0xFF6B7CD1)
            )
        }

        // Don't have an account
        Row(
            modifier = Modifier.padding(vertical = 16.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Don't have an account? ")
            TextButton(onClick = { /* Handle sign up */ }) {
                Text("Sign up", color = Color(0xFF6B7CD1))
            }
        }

        // Push Terms and Policy to bottom
        Spacer(modifier = Modifier.weight(1f))

        // Terms and Privacy
        Row(
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(onClick = { /* Handle terms */ }) {
                Text(
                    "Terms of Service",
                    color = Color(0xFF6B7CD1),
                    textAlign = TextAlign.Center
                )
            }
            Text(" & ", modifier = Modifier.padding(top = 16.dp))
            TextButton(onClick = { /* Handle privacy */ }) {
                Text(
                    "privacy policy",
                    color = Color(0xFF6B7CD1),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}