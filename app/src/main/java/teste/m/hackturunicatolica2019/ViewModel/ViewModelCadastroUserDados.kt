package teste.m.hackturunicatolica2019.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import teste.m.hackturunicatolica2019.entity.UserEntity
import teste.m.hackturunicatolica2019.repositorio.RepositorioDB

class ViewModelCadastroUserDados(application: Application):AndroidViewModel(application) {
    private val userRepositorio:RepositorioDB
    init {
        userRepositorio = RepositorioDB(application)
    }

    fun addNewUser(user:UserEntity){
        userRepositorio.insertUser(user)
    }
}