package pe.edu.idat.app_patitas_idat.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.MainScope
import pe.edu.idat.app_patitas_idat.R
import pe.edu.idat.app_patitas_idat.databinding.ActivityLoginBinding
import pe.edu.idat.app_patitas_idat.databinding.ActivityMainBinding
import pe.edu.idat.app_patitas_idat.retrofit.response.ResponseLogin
import pe.edu.idat.app_patitas_idat.util.AppMensaje
import pe.edu.idat.app_patitas_idat.viewmodel.AuthViewModel
import kotlin.math.log

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var authViewModel: AuthViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        authViewModel = ViewModelProvider(this)
            .get(AuthViewModel::class.java)
        authViewModel.responseLogin.observe(this, Observer{
            response -> getDatosLogin(response)
        })
        binding.btnlogin.setOnClickListener(this)
    }

    private fun getDatosLogin(login: ResponseLogin) {
        if(login.rpta){
            startActivity(Intent(this,
                MainActivity::class.java))
            finish()
        }else{
            Toast.makeText(this,
                login.mensaje, Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(p0: View) {

        when(p0.id){
            R.id.btnlogin -> autenticarUsuario()
            R.id.btnregistrarme -> startActivity(Intent(applicationContext,
                RegistroActivity::class.java))
        }
    }

    private fun autenticarUsuario() {
        Log.i("CLIC", "DIMOS CLICK")
        authViewModel.autenticacion(binding.etusuario.text.toString(),
            binding.etpassword.text.toString())
    }
}