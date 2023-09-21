package pe.edu.logincompose.ui.signup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pe.edu.logincompose.data.remote.UserRequest
import pe.edu.logincompose.repository.UserRepository

class SignUpViewModel(val userRepository: UserRepository = UserRepository()) : ViewModel() {
    private var _username = MutableLiveData<String>()
    val username get() = _username

    fun updateUsername (username: String){
        _username.value = username
    }

    private var _password = MutableLiveData<String>()
    val password get() = _password
    fun updatePassword (password: String){
        _password.value = password
    }

    private var _confirmPassword = MutableLiveData<String>()

    val confirmPassword get() = _confirmPassword

    fun updateConfirmPassword(confirmPassword: String){
        _confirmPassword.value = confirmPassword
    }

    fun register() {
        val userRequest = UserRequest(username.value!!, password.value!!)
        userRepository.register(userRequest){

        }
    }
}