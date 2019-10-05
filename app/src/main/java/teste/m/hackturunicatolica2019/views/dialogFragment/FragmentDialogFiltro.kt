package teste.m.hackturunicatolica2019.views.dialogFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_fragment_dialog_filtro.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.adapter.AdapterFiltros
import teste.m.hackturunicatolica2019.model.ModelListFiltro

class FragmentDialogFiltro(val filtro:(filtro:String)-> Unit) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_fragment_dialog_filtro, container, false)
        view.RecycleFiltros.layoutManager = LinearLayoutManager(activity)
        view.RecycleFiltros.adapter = AdapterFiltros(arrayListOf(ModelListFiltro(null,"djsadjksda"),ModelListFiltro(null,"djsadjksda"),ModelListFiltro(null,"djsadjksda")))

        view.buttonFIltrar.setOnClickListener {
            filtro("dsa")
            this.dismiss()
        }
        return view
    }

}
