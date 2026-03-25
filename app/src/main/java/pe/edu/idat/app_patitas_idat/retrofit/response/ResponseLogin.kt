package pe.edu.idat.app_patitas_idat.retrofit.response

data class ResponseLogin(
    var rpta: Boolean,
    var mensaje: String,
    var idpersona: String,
    var nombres: String,
    var apellidos: String,
    var email: String,
    var celular: String,
    var usuario: String,
    var password: String
)