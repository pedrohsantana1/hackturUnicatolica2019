package teste.m.hackturunicatolica2019

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import teste.m.hackturunicatolica2019.entity.UserEntity
import teste.m.hackturunicatolica2019.repositorio.RepositorioDB

class ViewModelLogin(application: Application):AndroidViewModel(application) {

    private var listaUser: LiveData<List<UserEntity>>
    private val userRepositorio:RepositorioDB
    private var userTemp:UserEntity?= null

    init {
        userRepositorio = RepositorioDB(application)
        listaUser = userRepositorio.getAll()
    }

    fun getALL():LiveData<List<UserEntity>>{
        return listaUser
    }
}