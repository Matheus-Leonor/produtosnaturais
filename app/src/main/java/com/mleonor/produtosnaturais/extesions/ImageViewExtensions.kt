package com.mleonor.produtosnaturais.extesions

import android.widget.ImageView
import coil.load
import com.mleonor.produtosnaturais.R

fun ImageView.tentaCarregarImagem(url: String? = null) {
    load(url) {
        fallback(R.drawable.erro)
        error(R.drawable.erro)
        placeholder(R.drawable.placeholder)

    }
}