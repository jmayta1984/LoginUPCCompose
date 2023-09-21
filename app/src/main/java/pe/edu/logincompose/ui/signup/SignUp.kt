package pe.edu.logincompose.ui.signup

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import pe.edu.logincompose.data.remote.UserRequest
import pe.edu.logincompose.repository.UserRepository
import pe.edu.logincompose.utils.Result

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUp(viewModel: SignUpViewModel) {
    val username: String by viewModel.username.observeAsState("")
    val password: String by viewModel.password.observeAsState("")
    val confirmPassword: String by viewModel.confirmPassword.observeAsState("")


    Column(
        modifier = Modifier.fillMaxSize(),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(

            value = username,
            onValueChange = { newValue ->
                viewModel.updateUsername(newValue)
            },
            placeholder = { Text("Username") }, modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = password,
            onValueChange = { newValue ->
                viewModel.updatePassword(newValue)
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text("Password") }, modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { newValue ->
                viewModel.updateConfirmPassword(newValue)
            },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text("Confirm password") }, modifier = Modifier.fillMaxWidth()
        )


        Button(onClick = {


        }) {
            Text("Register")
        }

        TextButton(onClick = { }) {
            Text("Login")
        }
    }

}

@Preview
@Composable
fun SignUpPreview() {

}