package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_home_logim.view.*
import kotlinx.android.synthetic.main.layout_chat.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterChat
import teste.m.hackturunicatolica2019.model.ModelChat

class FragmentHomeLogim : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_home_logim, container, false)
        val viewChat = inflater.inflate(R.layout.layout_chat,container,false)
        viewChat.recycleChat.layoutManager = LinearLayoutManager(activity)
        viewChat.recycleChat.adapter = AdapterChat(
            arrayListOf(
                ModelChat(null, "sdjasdhkajs", 1),
                ModelChat(null, "sdjasdhkajs", 1),
                ModelChat(null, "sdjasdhkajs", 2)
            ))

        view.frameLayout.addView(viewChat)
        return view
    }
}
