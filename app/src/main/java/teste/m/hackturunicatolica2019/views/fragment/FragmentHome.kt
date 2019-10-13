package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import android.os.PatternMatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SearchEvent
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_home.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.ViewModel.ViewModelHome
import teste.m.hackturunicatolica2019.adapter.AdapterListaHome
import teste.m.hackturunicatolica2019.model.ModelListaHome
import teste.m.hackturunicatolica2019.views.dialogFragment.FragmentDialogFiltro
import java.util.regex.Pattern

class FragmentHome : Fragment() {
 lateinit var viewModel: ViewModelHome
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelHome::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_home, container, false)
        val adapter = AdapterListaHome(viewModel.getListHome())

        view.recycleViewHome.layoutManager = LinearLayoutManager(activity)
        view.recycleViewHome.adapter = adapter

        view.buttonCentro.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentHome_to_fragmentLogin)
        }
        view.imgFiltros.setOnClickListener {
            FragmentDialogFiltro(){getFiltro(it)}
                .show(this.fragmentManager!!.beginTransaction(),"satrdsd")
        }

        view.searchView.setOnQueryTextListener(
            object : SearchView.OnQueryTextListener{
                override fun onQueryTextSubmit(p0: String?): Boolean {
                   return true
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    if(p0!!.isNotEmpty()){
                        adapter.atualizarLista(viewModel.getPlanoSearch(p0,viewModel.getListHome()))
                    } else{
                        adapter.atualizarLista(viewModel.getListHome())
                    }
                    return true
                }

            }
        )
        return view
    }

    fun getFiltro(filtro:String){

    }


}
