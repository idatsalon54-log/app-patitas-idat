package pe.edu.idat.app_patitas_idat.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.idat.app_patitas_idat.R
import pe.edu.idat.app_patitas_idat.databinding.FragmentHomeBinding
import pe.edu.idat.app_patitas_idat.view.adapters.MascotaAdapter
import pe.edu.idat.app_patitas_idat.viewmodel.MascotaViewModel


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var mascotaViewModel: MascotaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater,
            container, false)
        binding.rvmascota.layoutManager = LinearLayoutManager(
            requireActivity())
        mascotaViewModel = ViewModelProvider(requireActivity())
            .get(MascotaViewModel::class.java)
        listarMascotas()
        return binding.root
    }

    fun listarMascotas(){
        mascotaViewModel.listarMascotas()
            .observe(viewLifecycleOwner,
                Observer{
                    listMascota ->
                binding.rvmascota.adapter = MascotaAdapter(listMascota)
            })
    }

}