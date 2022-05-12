package br.com.danielamaral.jogo_domilhao

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import br.com.danielamaral.jogo_domilhao.databinding.FragmentJogoBinding
import br.com.danielamaral.show_do_milhao.Database

class JogoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentJogoBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_jogo, container, false)

        binding.tvPergunta.text = Database.perguntas[0].texto
        binding.rbResposta1.text = Database.perguntas[0].respostas[0].texto
        binding.rbResposta2.text = Database.perguntas[0].respostas[1].texto
        binding.rbResposta3.text = Database.perguntas[0].respostas[2].texto


        binding.btResponder.setOnClickListener {
            val opcaoSelecionada = binding.rgRespostas.checkedRadioButtonId
            val respostaSelecionada: String

            when (opcaoSelecionada) {
                binding.rbResposta1.id -> respostaSelecionada = binding.rbResposta1.text.toString()
                binding.rbResposta2.id -> respostaSelecionada = binding.rbResposta2.text.toString()
                else -> respostaSelecionada = binding.rbResposta3.text.toString()
            }

            if (validarResposta(respostaSelecionada)) {
                view?.findNavController()?.navigate(R.id.action_jogoFragment_to_ganhouFragment)
            } else {
                view?.findNavController()?.navigate(R.id.action_jogoFragment_to_perdeuFragment)
            }

        }
        return binding.root
    }

    private fun validarResposta(resposta: String): Boolean {
        var isRespostaCorreta = false
        Database.perguntas[0].respostas.forEach { resp ->
            if (resp.texto.equals(resposta) && resp.isCorreta) {
                isRespostaCorreta = true
            }
        }
        return isRespostaCorreta
    }

}