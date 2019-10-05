package teste.m.hackturunicatolica2019.views.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import teste.m.hackturunicatolica2019.R

class FragmentCadastroUserDados : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_cadastro_user_dados, container, false)

        view.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        return view
    }

}
