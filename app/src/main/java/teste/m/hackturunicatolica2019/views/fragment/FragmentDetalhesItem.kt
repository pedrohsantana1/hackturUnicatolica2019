package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_detalhes_item.view.*
import kotlinx.android.synthetic.main.layout_agencias.view.*
import kotlinx.android.synthetic.main.layout_fotos.view.*

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
        val viewDescricao = inflater.inflate(R.layout.layout_descricao,container,false)
        val viewFotos = inflater.inflate(R.layout.layout_fotos,container,false)
        val viewAgencias = inflater.inflate(R.layout.layout_agencias,container,false)
        viewFotos.recycleFotos.layoutManager = LinearLayoutManager(activity)
        viewFotos.recycleFotos.adapter = AdapterFotos(arrayListOf(ModelListFotos(1),ModelListFotos(1),ModelListFotos(1),ModelListFotos(1)))
        viewAgencias.recycleAgencias.layoutManager =LinearLayoutManager(activity)
        viewAgencias.recycleAgencias.adapter = AdapterAgencias(arrayListOf(ModelListAngencias(null,"nasdnsd","sadaskdjaksjdkal"),ModelListAngencias(null,"nasdnsd","sadaskdjaksjdkal"),ModelListAngencias(null,"nasdnsd","sadaskdjaksjdkal"),ModelListAngencias(null,"nasdnsd","sadaskdjaksjdkal")))

        view.frameLayout.addView(viewDescricao)
        view.buttonDireita.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewDescricao)
        }
        view.buttonCentro.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewFotos)
        }
        view.buttonEsquerda.setOnClickListener {
            view.frameLayout.removeAllViews()
            view.frameLayout.addView(viewAgencias)
        }
        return view
    }

}