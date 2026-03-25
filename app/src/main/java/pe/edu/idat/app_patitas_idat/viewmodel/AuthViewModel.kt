package pe.edu.idat.app_patitas_idat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.app_patitas_idat.repository.AuthRepository
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin

class AuthViewModel : ViewModel() {

    var responseLogin: LiveData<ResponseLogin>
    private var repository = AuthRepository()
    init {
        responseLogin = repository.loginResponse
    }
    fun autenticacion(usuario: String, password: String){
        responseLogin = repository.autenticacion(
            RequestLogin(usuario, password))
    }

}