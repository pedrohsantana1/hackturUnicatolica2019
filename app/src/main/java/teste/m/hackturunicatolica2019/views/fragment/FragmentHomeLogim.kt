package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_home_logim.view.*
import kotlinx.android.synthetic.main.layout_chat.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.ViewModel.ViewModelDashBoard
import teste.m.hackturunicatolica2019.adapter.AdapterChat
import teste.m.hackturunicatolica2019.entity.UserEntity
import teste.m.hackturunicatolica2019.model.ModelChat
import kotlin.random.Random

class FragmentHomeLogim : Fragment() {
   private lateinit var viewModel:ViewModelDashBoard
    private lateinit var userEntity:UserEntity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelDashBoard::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_home_logim, container, false)
        val viewChat = inflater.inflate(R.layout.layout_chat,container,false)

        arguments?.get("userID")?.let {
            val id = it as Int
            viewModel.getUser(id).observe(this, Observer { view.tvNomeUser.text = it.nomeCompleto })
            Log.e("ID", id.toString())
        }
        val adapterChat = AdapterChat(viewModel.getListChatBoot())
        viewChat.recycleChat.layoutManager = LinearLayoutManager(activity)
        viewChat.recycleChat.adapter = adapterChat
        viewChat.imgConfirm.setOnClickListener {
            if(!viewChat.editMensagem.text.isEmpty()){
                viewModel.getListChatBoot().add(ModelChat(null,viewChat.editMensagem.text.toString(),(0..1).shuffled().first()))
                adapterChat.atualizarLista(viewModel.getListChatBoot())
                viewChat.recycleChat.scrollToPosition(viewModel.getListChatBoot().size-1)
            }
        }

        view.frameLayout.addView(viewChat)
        return view
    }


}
