package teste.m.hackturunicatolica2019.model

import android.os.Parcel
import android.os.Parcelable

class ModelChat(val idDrawable:Int?=null, val  mensagem:String?=null, val layoutType:Int?=null):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(idDrawable)
        parcel.writeString(mensagem)
        parcel.writeValue(layoutType)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelChat> {
        override fun createFromParcel(parcel: Parcel): ModelChat {
            return ModelChat(parcel)
        }

        override fun newArray(size: Int): Array<ModelChat?> {
            return arrayOfNulls(size)
        }
    }
}