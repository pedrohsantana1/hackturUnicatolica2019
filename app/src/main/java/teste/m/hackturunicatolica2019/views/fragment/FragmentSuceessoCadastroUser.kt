package teste.m.hackturunicatolica2019.views.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fragment_suceesso_cadastro_user.view.*

import teste.m.hackturunicatolica2019.R

class FragmentSuceessoCadastroUser : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_suceesso_cadastro_user, container, false)

        view.btnConfirm.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_fragmentSuceessoCadastroUser_to_fragmentLogin)
        }

        return view
    }
}
