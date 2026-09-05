package com.example.notesapp.ui.theme.screens

import android.app.Activity
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notesapp.getGoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.example.notesapp.viewmodel.AuthState
import com.example.notesapp.viewmodel.AuthViewModel

@Composable
fun LoginScreen(navController: NavController, viewModel: AuthViewModel) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authState by viewModel.authState.collectAsState()
    val context = LocalContext.current

    val googleSignInClient = getGoogleSignInClient(context)

    val googleSignInLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        Log.d("GoogleSignIn", "Result code: ${result.resultCode}")
        try {
            val task = GoogleSignIn.getSignedInAccountFromIntent(result.data)
            task.addOnCompleteListener { completedTask ->
                if (completedTask.isSuccessful) {
                    val account = completedTask.result
                    val idToken = account?.idToken
                    Log.d("GoogleSignIn", "Success! Token: ${idToken?.take(20)}...")
                    if (idToken != null) {
                        viewModel.signInWithGoogle(idToken)
                    } else {
                        Log.e("GoogleSignIn", "No idToken in account")
                    }
                } else {
                    Log.e("GoogleSignIn", "Task failed: ${completedTask.exception?.message}")
                }
            }
        } catch (e: Exception) {
            Log.e("GoogleSignIn", "Exception: ${e.message}", e)
        }
    }

    LaunchedEffect(authState) {
        if (authState is AuthState.Authenticated) {
            navController.navigate("home") {
                popUpTo("login") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text("Login", style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))

        if (authState is AuthState.Error) {
            Text(
                (authState as AuthState.Error).message,
                color = MaterialTheme.colorScheme.error
            )
            Spacer(Modifier.height(8.dp))
        }

        Button(
            onClick = { viewModel.login(email, password) },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            if (authState is AuthState.Loading) {
                CircularProgressIndicator(Modifier.size(20.dp))
            } else {
                Text("Login")
            }
        }

        Spacer(Modifier.height(12.dp))
        Text("OR", modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        Spacer(Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                googleSignInClient.signOut()
                val signInIntent = googleSignInClient.signInIntent
                googleSignInLauncher.launch(signInIntent)
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = authState !is AuthState.Loading
        ) {
            Text("Sign in with Google")
        }

        TextButton(onClick = { navController.navigate("signup") }) {
            Text("Don't have an account? Create one")
        }
    }
}