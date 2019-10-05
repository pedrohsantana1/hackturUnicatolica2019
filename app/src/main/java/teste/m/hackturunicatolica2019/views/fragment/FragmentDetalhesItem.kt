package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_fragment_detalhes_item.view.*

import teste.m.hackturunicatolica2019.R

class FragmentDetalhesItem : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_fragment_detalhes_item, container, false)
        val viewDescricao = inflater.inflate(R.layout.layout_descricao,container,false)
        val viewFotos = inflater.inflate(R.layout.layout_fotos,container,false)
        val viewAgencias = inflater.inflate(R.layout.layout_agencias,container,false)
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
