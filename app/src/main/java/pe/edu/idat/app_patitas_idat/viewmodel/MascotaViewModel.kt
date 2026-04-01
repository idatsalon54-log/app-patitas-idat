package pe.edu.idat.app_patitas_idat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.app_patitas_idat.repository.MascotaRepository
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseRegistro

class MascotaViewModel : ViewModel() {
    private var repository = MascotaRepository()
    var responseRegistro: LiveData<ResponseRegistro> = repository.responseRegistro

    fun listarMascotas(): LiveData<List<ResponseMascota>>
    {
        return repository.listarMascotas()
    }

    fun registrarVoluntario(idPersona : Int) {
        responseRegistro = repository.registrarVoluntario(idPersona)
    }

}