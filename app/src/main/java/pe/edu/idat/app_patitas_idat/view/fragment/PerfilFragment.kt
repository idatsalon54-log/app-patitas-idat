package pe.edu.idat.app_patitas_idat.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import pe.edu.idat.app_patitas_idat.R
import pe.edu.idat.app_patitas_idat.databinding.FragmentPerfilBinding
import pe.edu.idat.app_patitas_idat.viewmodel.PersonaViewModel

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null
    private val binding get() = _binding!!

    private lateinit var personaViewModel: PersonaViewModel
     override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         _binding = FragmentPerfilBinding.inflate(inflater, container, false)
         personaViewModel = ViewModelProvider(requireActivity()).get(PersonaViewModel::class.java)
         obtenerUsuarioLogueado()
         return binding.root
    }

    private fun obtenerUsuarioLogueado() {
        personaViewModel.obtener().observe(viewLifecycleOwner) { persona ->
            persona?.let {
                binding.tvNombreCompleto.text = "${it.nombres} ${it.apellidos}"
                binding.tvCorreo.text = it.email
                binding.tvUsuario.text = it.usuario
            }
        }
    }


}