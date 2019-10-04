package teste.m.hackturunicatolica2019.repositorio

import android.app.Application
import teste.m.hackturunicatolica2019.dp.RoomDataBase
import teste.m.hackturunicatolica2019.dp.dao.dao_user

open class RepositorioDB {
    lateinit var dao:dao_user

    constructor(application: Application){
        val roomDatabase = RoomDataBase.userDAO(application)
        dao = roomDatabase.daoUser()
    }


}