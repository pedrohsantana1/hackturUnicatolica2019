package teste.m.hackturunicatolica2019.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import teste.m.hackturunicatolica2019.entity.UserEntity
import teste.m.hackturunicatolica2019.model.ModelChat
import teste.m.hackturunicatolica2019.repositorio.RepositorioDB

class ViewModelDashBoard(application: Application):AndroidViewModel(application) {
    private val repositorioDb = RepositorioDB(application)
    fun getUser(id:Int):LiveData<UserEntity>{
        return repositorioDb.getUser(id)
    }

    fun getListChatBoot():ArrayList<ModelChat>{
        return arrayListOf(
            ModelChat(null, "Ola", 1),
            ModelChat(null, "Tudo bem?", 1),
            ModelChat(null, "sim, e você... como esta?", 2)
        )
    }
}