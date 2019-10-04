package teste.m.hackturunicatolica2019.dp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Update
import teste.m.hackturunicatolica2019.entity.UserEntity

@Dao
interface dao_user {
@Insert
fun insertUser(userEntity: UserEntity)

@Update
fun updateUser(userEntity: UserEntity)

}