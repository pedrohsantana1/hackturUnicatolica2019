package teste.m.hackturunicatolica2019.views.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_home.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterListaHome
import teste.m.hackturunicatolica2019.model.ModelListaHome

class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_home, container, false)
        val adapter = AdapterListaHome(arrayListOf(
            ModelListaHome(R.drawable.icon_graciosa ,"Praia da Graciosa", "Melhor por do sol", "Praia"),
            ModelListaHome(R.drawable.icon_arnos,"Praia das Arnos","Praia na região norte", "Praia"),
            ModelListaHome(R.drawable.icon_geodesico,"Centro Geodésico","Centro do Brasil", "Praça"),
            ModelListaHome(R.drawable.icon_palacio,"Palácio Araguaia","Maior praça da america latina", "Praça"),
            ModelListaHome(R.drawable.icon_evilson,"Cachoeira do Evilson","Conheça Taquaruçu", "Cachoeira"),
            ModelListaHome(R.drawable.icon_macaco,"Cachoeira escorrega macaco","Conheça Taquaruçu", "Cachoeira")))

        view.recycleViewHome.layoutManager = LinearLayoutManager(activity)
        view.recycleViewHome.adapter = adapter
        return view
    }

}
