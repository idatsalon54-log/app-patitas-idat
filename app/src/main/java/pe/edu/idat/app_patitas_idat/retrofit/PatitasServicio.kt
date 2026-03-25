package pe.edu.idat.app_patitas_idat.retrofit

import pe.edu.idat.app_patitas_idat.retrofit.request.RequestLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface PatitasServicio {

    @GET("mascotaperdida.php")
    fun listarMascota() : Call<List<ResponseMascota>>

    @POST("login.php")
    fun login(@Body requestLogin: RequestLogin): Call<ResponseLogin>

}