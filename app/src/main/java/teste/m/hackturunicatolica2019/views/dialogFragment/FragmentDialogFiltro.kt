package teste.m.hackturunicatolica2019.views.dialogFragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import kotlinx.android.synthetic.main.fragment_fragment_dialog_filtro.view.*

import teste.m.hackturunicatolica2019.R

class FragmentDialogFiltro(val filtro:(filtro:String)-> Unit) : DialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.fragment_fragment_dialog_filtro, container, false)
        view.buttonFIltrar.setOnClickListener {
            filtro("dsa")
            this.dismiss()
        }
        return view
    }

}
