package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.maps.GoogleMap
import kotlinx.android.synthetic.main.fragment_fragment_detalhes_item.view.*
import kotlinx.android.synthetic.main.layout_agencias.view.*
import kotlinx.android.synthetic.main.layout_descricao.view.*
import kotlinx.android.synthetic.main.layout_descricao.view.tvDescricao
import kotlinx.android.synthetic.main.layout_fotos.view.*
import kotlinx.android.synthetic.main.layout_item_lista_local.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterAgencias
import teste.m.hackturunicatolica2019.adapter.AdapterFotos
import teste.m.hackturunicatolica2019.model.ModelListAngencias
import teste.m.hackturunicatolica2019.model.ModelListFotos

class FragmentDetalhesItem : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_detalhes_item, container, false)
        val viewDescricao = inflater.inflate(R.layout.layout_descricao, container, false)
        val viewMaps = inflater.inflate(R.layout.layout_fotos, container, false)
        val viewAgencias = inflater.inflate(R.layout.layout_agencias, container, false)


        viewAgencias.recycleAgencias.layoutManager = LinearLayoutManager(activity)
        viewAgencias.recycleAgencias.adapter = AdapterAgencias(
            arrayListOf(
                ModelListAngencias(null, "nasdnsd", "sadaskdjaksjdkal"),
                ModelListAngencias(null, "nasdnsd", "sadaskdjaksjdkal"),
                ModelListAngencias(null, "nasdnsd", "sadaskdjaksjdkal"),
                ModelListAngencias(null, "nasdnsd", "sadaskdjaksjdkal")
            )
        )


        view.frameLayout.addView(viewDescricao)

        arguments?.get("idDrawable").let { view.imgHeader.setImageResource(it as Int) }
        arguments?.get("title").let { viewDescricao.tvTitle.text = it as String }
        arguments?.get("detalhes").let { viewDescricao.tvDescricao.text = it as String }
        view.buttonDireita.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewDescricao)
        }
        view.buttonCentro.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewMaps)
        }
        view.buttonEsquerda.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewAgencias)
        }
        return view
    }

}
