package teste.m.hackturunicatolica2019.entity

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName ="user")
class UserEntity(@PrimaryKey(autoGenerate = true) val id:Int, val userName:String?=null, val email:String?=null, val senha:String?=null, val nomeCompleto:String?=null, val idade: String?=null, val cpf:String?=null )
