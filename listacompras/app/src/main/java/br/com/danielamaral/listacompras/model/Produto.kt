package br.com.danielamaral.listacompras.model

import java.io.Serializable

data class Produto(
    val nome: String,
    val marca: String,
    val preco: Double
):Serializable