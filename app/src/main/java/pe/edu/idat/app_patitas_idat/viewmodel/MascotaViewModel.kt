package pe.edu.idat.app_patitas_idat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import pe.edu.idat.app_patitas_idat.repository.MascotaRepository
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota

class MascotaViewModel : ViewModel() {
    private var repository = MascotaRepository()

    fun listarMascotas(): LiveData<List<ResponseMascota>> {
        return repository.listarMascotas()
    }

}