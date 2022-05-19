package br.com.danielamaral.show_do_milhao

import br.com.danielamaral.jogo_domilhao.model.Jogador
import br.com.danielamaral.jogo_domilhao.model.Pergunta
import br.com.danielamaral.jogo_domilhao.model.Resposta

class Database {

    companion object {
        val perguntas = mutableListOf<Pergunta>()
        val jogador:Jogador = Jogador("")

        init {
            val perguntaA = "Qual time não tem mundial?"
            val respostaA1 = Resposta("Corinthians", false)
            val respostaA2 = Resposta("Palmeiras", true)
            val respostaA3 = Resposta("Vasco", false)
            val listaRespostasA = listOf(respostaA1, respostaA2, respostaA3)
            perguntas.add(Pergunta(perguntaA, listaRespostasA))

            val perguntaB = "Qual a melhor banda do mundo?"
            val respostaB1 = Resposta("Coldplay", false)
            val respostaB2 = Resposta("Metallica", true)
            val respostaB3 = Resposta("Chiclete com Banana", false)
            val listaRespostasB = listOf(respostaB1, respostaB2, respostaB3)
            perguntas.add(Pergunta(perguntaB, listaRespostasB))

            val perguntaC = "Qual o sexto planeta mais próximo do sol?"
            val respostaC1 = Resposta("Jupiter", false)
            val respostaC2 = Resposta("Marte", false)
            val respostaC3 = Resposta("Saturno", true)
            val listaRespostasC = listOf(respostaC1, respostaC2, respostaC3)
            perguntas.add(Pergunta(perguntaC, listaRespostasC))
        }
    }
}