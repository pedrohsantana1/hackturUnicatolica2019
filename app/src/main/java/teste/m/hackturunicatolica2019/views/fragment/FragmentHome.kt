package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_home.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterListaHome
import teste.m.hackturunicatolica2019.model.ModelListaHome
import teste.m.hackturunicatolica2019.views.dialogFragment.FragmentDialogFiltro

class FragmentHome : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_home, container, false)
        val adapter = AdapterListaHome(arrayListOf(
            ModelListaHome(R.drawable.praiagraciosa,"Praia da Graciosa", "Melhor por do sol", "Praia","Porta de entrada da Capital, a Graciosa é a principal praia da cidade. Revitalizada no primeiro semestre de 2016, conta com uma excelente estrutura para receber turistas e moradores, com estacionamento e rampas de acessibilidade. São 520 metros de orla que comportam bares e restaurantes, quadras de esporte, banheiros, playground, marina com atracadouro, píer e vista para a Ponte da Amizade. No local foi construído um obelisco de 12,38 metros com quatro faces. Cada face do monumento contém um trabalho artístico relacionado a elementos da natureza, sendo a primeira o Monumento à Consciência, a segunda Homem, a terceira Água e Terra e quarta Vento e Fogo. A praia também é ideal para a prática esportiva como stand up, canoagem e caiaque, além de ciclismo, corrida e cooper, já que a " +
                    "estrutura conta com 1200 metros de ciclovia e 500 metros de pista de cooper que abrange toda a orla"),
            ModelListaHome(R.drawable.arnos,"Praia das Arnos","Praia na região norte", "Praia","asds"),
            ModelListaHome(R.drawable.centro,"Centro Geodésico","Centro do Brasil", "Praça","asdsd"),
            ModelListaHome(R.drawable.palacio,"Palácio Araguaia","Maior praça da america latina", "Praça","adsd"),
            ModelListaHome(R.drawable.evilson,"Cachoeira do Evilson","Conheça Taquaruçu", "Cachoeira","dasd"),
            ModelListaHome(R.drawable.macaco,"Cachoeira escorrega macaco","Conheça Taquaruçu", "Cachoeira","")))

        view.recycleViewHome.layoutManager = LinearLayoutManager(activity)
        view.recycleViewHome.adapter = adapter

        view.buttonCentro.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentLogin)
        }
        view.imgFiltros.setOnClickListener {
            FragmentDialogFiltro(){getFiltro(it)}
                .show(this.fragmentManager!!.beginTransaction(),"satrdsd")
        }
        return view
    }

    fun getFiltro(filtro:String){

    }


}
