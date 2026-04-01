package pe.edu.idat.app_patitas_idat.retrofit

import pe.edu.idat.app_patitas_idat.retrofit.request.RequestLogin
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestRegistro
import pe.edu.idat.app_patitas_idat.retrofit.request.RequestVoluntario
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseRegistro
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface PatitasServicio {

    @GET("mascotaperdida.php")
    fun listarMascota() : Call<List<ResponseMascota>>

    @POST("login.php")
    fun login(@Body requestLogin: RequestLogin): Call<ResponseLogin>

    @PUT("persona.php")
    fun registro(@Body requestRegistro: RequestRegistro): Call<ResponseRegistro>

    @POST("personavoluntaria.php")
    fun registrarVoluntario(@Body requestVoluntario: RequestVoluntario): Call<ResponseRegistro>
}