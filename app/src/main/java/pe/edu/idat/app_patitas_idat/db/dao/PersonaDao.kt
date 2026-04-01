package pe.edu.idat.app_patitas_idat.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import pe.edu.idat.app_patitas_idat.db.entity.PersonaEntity

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insertar(vararg persona: PersonaEntity)

    @Update
     fun actualizar(vararg persona: PersonaEntity)

     @Query("DELETE FROM persona")
     fun eliminartodo()

    @Query("SELECT * FROM persona LIMIT 1")
    fun obtener(): LiveData<PersonaEntity>

}