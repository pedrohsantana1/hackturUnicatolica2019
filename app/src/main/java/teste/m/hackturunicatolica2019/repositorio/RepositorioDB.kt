package teste.m.hackturunicatolica2019.repositorio

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import teste.m.hackturunicatolica2019.dp.RoomDataBase
import teste.m.hackturunicatolica2019.dp.dao.dao_user
import teste.m.hackturunicatolica2019.entity.UserEntity

open class RepositorioDB {
    lateinit var dao:dao_user
    private var listaUser: LiveData<List<UserEntity>>

    constructor(application: Application){
        val roomDatabase = RoomDataBase.userDAO(application)
        dao = roomDatabase.daoUser()
        listaUser = dao.getALL()
    }

    fun insertUser(userEntity: UserEntity){
        InserteAsyncTask(dao).execute(userEntity)
    }

    fun getAll():LiveData<List<UserEntity>>{
        return listaUser
    }


    private class InserteAsyncTask internal constructor(private val notaDAOAsyncTask: dao_user) :
        AsyncTask<UserEntity, Void, Void>() {

        override//o metodo abaixo tem como parametro um Array de parametros
        fun doInBackground(vararg userEntities: UserEntity): Void? {
            notaDAOAsyncTask.insertUser(userEntities[0])
            return null
        }
    }

}