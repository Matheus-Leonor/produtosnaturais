package com.mleonor.produtosnaturais.ui.activity

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mleonor.produtosnaturais.R
import com.mleonor.produtosnaturais.dao.ProdutosDao
import com.mleonor.produtosnaturais.databinding.ActivityFormularioProdutoBinding
import com.mleonor.produtosnaturais.databinding.ActivityListaProdutoBinding
import com.mleonor.produtosnaturais.ui.dialog.FormularioImagemDialog
import com.mleonor.produtosnaturais.ui.recyclerview.adapter.ListaProdutosAdapter

//Activity tem um ciclo de vida;
class ListaProdutosActivity : AppCompatActivity() {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.buscaTodos())
    private val binding by lazy {
        ActivityListaProdutoBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        title = "Produtos"
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityListaProdutoFab
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView =  binding.activityListaProdutoRecyclerView
        recyclerView.adapter = adapter
    }
}