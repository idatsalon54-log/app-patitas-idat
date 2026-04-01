package pe.edu.idat.app_patitas_idat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.app_patitas_idat.repository.AuthRepository
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestLogin
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestRegistro
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseRegistro

class AuthViewModel : ViewModel() {

    var responseLogin: LiveData<ResponseLogin>
    private var repository = AuthRepository()
    var responseRegistro: LiveData<ResponseRegistro>

    init {
        responseLogin = repository.loginResponse
        responseRegistro = repository.registroResponse

    }
    fun autenticacion(usuario: String, password: String){
        responseLogin = repository.autenticacion(
            RequestLogin(usuario, password))
    }
    fun registrarUsuario(nombres: String, apellidos: String,email: String,
                         celular: String,usuario: String, password: String)
    {
        responseRegistro = repository.registrarUsuario(
            RequestRegistro(nombres, apellidos, email, celular,
                usuario, password)
        )
    }

}