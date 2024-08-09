package com.mleonor.produtosnaturais.dao

import com.mleonor.produtosnaturais.model.Produto
import java.math.BigDecimal

class ProdutosDao {


    fun adiciona(produto: Produto) {
        produtos.add(produto)
    }

    fun buscaTodos(): List<Produto> {
        return produtos.toList()
    }

    companion object {
        private val produtos = mutableListOf<Produto>(
            Produto(
                nome = "salada de frutas",
                descricao = "kiwi, manga e pitaya",
                valor = BigDecimal("19.83")
            )
        )

    }
}