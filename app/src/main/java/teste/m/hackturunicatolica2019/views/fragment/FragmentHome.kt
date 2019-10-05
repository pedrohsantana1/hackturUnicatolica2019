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
            ModelListaHome(R.drawable.praiagraciosa,"Praia da Graciosa", "Melhor por do sol", "Praia","Porta de entrada da Capital, a Graciosa é a principal praia da cidade., banheiros, playground, marina com atracadouro, píer e vista para a Ponte da Amizade. " +
                    "estrutura conta com 1200 metros de ciclovia e 500 metros de pista de cooper que abrange toda a orla"),
            ModelListaHome(R.drawable.arnos,"Praia das Arnos","Praia na região norte", "Praia","Uma ótima opção de lazer para os moradores da região Norte da Capital, a Praia das Arnos está localizada a aproximadamente três quilômetros do Palácio Araguaia. Com uma área de 8.764 m² e dotada de bares e restaurantes de pequeno porte, a praia é hoje referência em beleza na Capital e vem atraindo cada vez mais banhistas. Possui banheiros com duchas, quiosques," +
                    " quadra de esportes, estacionamento, dentre outros equipamentos."),
            ModelListaHome(R.drawable.centro,"Centro Geodésico","Centro do Brasil", "Praça","O Centro Geodésico do Brasil fica no hall de entrada do Palácio Araguaia e é marcado pela Rosa dos Ventos. É o ponto central entre os extremos do nosso país (norte-sul, leste-oeste). Entretanto, para dar maior destaque ao monumento, foi criada a Roda dos Ventos em tamanho maior, do lado de fora " +
                    "do Palácio Araguaia"),
            ModelListaHome(R.drawable.palacio,"Praça dos Girassóis","Maior praça da america latina", "Praça","Com 571 mil metros quadrados, a Praça dos Girassóis é a maior da América latina e a segunda maior praça urbana do mundo, sendo superada apenas pela Praça Merdeka, que fica em Jacarta, na Indonésia. Começou a ser construída em 18 de outubro de 1999 e contou com 800 operários trabalhando para erguer o cartão postal da capital Palmas."),
            ModelListaHome(R.drawable.evilson,"Cachoeira do Evilson","Conheça Taquaruçu", "Cachoeira"," Cachoeira do Evilson é dos principais atrativos turísticos de Taquaruçu. De beleza única, esta cachoeira dispõe de sinalização indicativa e, para acessá-la é cobrado o valor de R\$ 5,00."),
            ModelListaHome(R.drawable.macaco,"Cachoeira escorrega macaco","Conheça Taquaruçu", "Cachoeira","A Cachoeira do Escorrega Macaco juntamente com a Cachoeira da Roncadeira recebem cerca de 400 visitantes por dia em alta temporada. A cachoeira fica em uma propriedade privada, que se encontra dentro de uma APA, por isso a visitação é controlada e é cobrada entrada.")))

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
