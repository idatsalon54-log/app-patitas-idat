package pe.edu.idat.app_patitas_idat.retrofit

import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota
import retrofit2.Call
import retrofit2.http.GET

interface PatitasServicio {

    @GET("mascotaperdida.php")
    fun listarMascota() : Call<List<ResponseMascota>>

}