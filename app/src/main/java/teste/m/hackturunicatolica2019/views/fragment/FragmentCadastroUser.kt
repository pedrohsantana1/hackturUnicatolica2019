package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fragment_cadastro_user.view.*

import teste.m.hackturunicatolica2019.R


class FragmentCadastroUser : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_cadastro_user, container, false)
        view.btnConfirm.setOnClickListener {
            if(view.etUser.text.isEmpty()){
                view.etUser.error = "O camp tem que ser preenchido"
            } else if(view.etSenha.text.toString() != view.etNovaSenha.text.toString()){
                view.etNovaSenha.error = "As senhas não conferem"
            } else{
                Navigation.findNavController(view).navigate(
                    R.id.action_fragmentCadastroUser_to_fragmentCadastroUserDados,
                    bundleOf(
                        "userName" to view.etUser.text.toString(),
                        "email" to view.etEmail.text.toString(),
                        "senha" to view.etSenha.text.toString()
                    )
                )
            }

        }
        view.imgReturn.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        return view
    }

}
