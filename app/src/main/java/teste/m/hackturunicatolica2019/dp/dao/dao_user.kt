package teste.m.hackturunicatolica2019.dp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface dao_user {
@Insert
fun insertUser()

@Update
fun updateUser()

}