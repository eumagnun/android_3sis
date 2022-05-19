package br.com.danielamaral.jogo_domilhao.model

data class Pergunta
    (
    val texto: String,
    var respostas: List<Resposta>
)
