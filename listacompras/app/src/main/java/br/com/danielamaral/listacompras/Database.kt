package br.com.danielamaral.listacompras

import br.com.danielamaral.listacompras.model.Produto

class Database {
    companion object{
        val listaCompras = mutableListOf<Produto>()
    }
}