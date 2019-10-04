package teste.m.hackturunicatolica2019.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="user")
class UserEntity(@PrimaryKey(autoGenerate = true) val id:Int, val userName:String, val email:String, val senha:String, val nomeCompleto:String, val idade: String, val statusCivil:String )
