package pe.edu.idat.app_patitas_idat.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import pe.edu.idat.app_patitas_idat.retrofit.PatitasCliente
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AuthRepository {

    var loginResponse = MutableLiveData<ResponseLogin>()

    fun autenticacion(requestLogin: RequestLogin): MutableLiveData<ResponseLogin>{
        val call: Call<ResponseLogin> = PatitasCliente.retrofitService
            .login(requestLogin);
        call.enqueue(object : Callback<ResponseLogin>{
            override fun onResponse(
                call: Call<ResponseLogin?>,
                response: Response<ResponseLogin?>
            ) {
                loginResponse.value = response.body()
            }

            override fun onFailure(
                call: Call<ResponseLogin?>,
                t: Throwable
            ) {
                Log.e("ErrorLogin", t.message.toString())
            }

        })
        return loginResponse
    }


}