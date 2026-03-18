package pe.edu.idat.app_patitas_idat.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import okhttp3.internal.wait
import pe.edu.idat.app_patitas_idat.databinding.ItemMascotaBinding
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseMascota

class MascotaAdapter (private var listMascotas: List<ResponseMascota>)
    : RecyclerView.Adapter<MascotaAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemMascotaBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MascotaAdapter.ViewHolder {
        val binding = ItemMascotaBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MascotaAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listMascotas[position]){
                binding.tvnommascota.text = nommascota
                binding.tvcontacto.text = contacto
                binding.tvfecha.text = fechaperdida
                binding.tvlugar.text = lugar
                urlimagen = "https://imoments.pe/apps"+urlimagen.substring(24)
                Glide.with(holder.itemView.context)
                    .load(urlimagen)
                    .into(binding.ivmascota)
            }
        }
    }

    override fun getItemCount() = listMascotas.size


}