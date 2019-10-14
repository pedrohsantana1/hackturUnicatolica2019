package teste.m.hackturunicatolica2019.views.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_fragment_cadastro_user_dados.view.*

import teste.m.hackturunicatolica2019.R
import teste.m.hackturunicatolica2019.viewModel.ViewModelCadastroUserDados
import teste.m.hackturunicatolica2019.entity.UserEntity

class FragmentCadastroUserDados : Fragment() {
    lateinit var viewModel:ViewModelCadastroUserDados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ViewModelCadastroUserDados::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_fragment_cadastro_user_dados, container, false)
        val userName = arguments?.get("userName")
        val email = arguments?.get("email")
        val senha = arguments?.get("senha")

        view.imgComfirm.setOnClickListener {
            if(view.etNomeCompleto.text.isEmpty()){
                view.etNomeCompleto.error = "Campo obrigatorio"
            } else if(view.etCpf.text.isEmpty()){
                view.etNomeCompleto.error = "Campo obrigatorio"
            } else {
                val user = UserEntity(0,userName.toString(),email.toString(),senha.toString(),view.etNomeCompleto.text.toString(),view.etIdade.toString(),view.etCpf.text.toString())
                Navigation.findNavController(view).navigate(R.id.action_fragmentCadastroUserDados_to_fragmentSuceessoCadastroUser)
                viewModel.addNewUser(user)
            }
        }


        view.imgReturn.setOnClickListener {
            Navigation.findNavController(view).popBackStack()
        }
        return view
    }

}
