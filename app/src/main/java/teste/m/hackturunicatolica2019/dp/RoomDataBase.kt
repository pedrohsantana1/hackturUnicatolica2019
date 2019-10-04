package teste.m.hackturunicatolica2019.dp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import teste.m.hackturunicatolica2019.entity.UserEntity
import teste.m.hackturunicatolica2019.dp.dao.dao_user

@Database(entities = [UserEntity::class], version = 1)
abstract class RoomDataBase : RoomDatabase() {
    abstract fun daoUser(): dao_user

    companion object {
        @Volatile
        private var INSTANCE: RoomDataBase? = null


        fun userDAO(context: Context): RoomDataBase {
            if (INSTANCE == null) {
                synchronized(RoomDataBase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, RoomDataBase::class.java, "atabase_hackturUnicatolica").build()

                    }
                }
            }

            return INSTANCE!!
        }
    }

}