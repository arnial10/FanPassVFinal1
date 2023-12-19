package com.example.fanpassvfinal

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fanpassvfinal.adapter.UsuarioAdapter
import com.example.fanpassvfinal.databinding.ActivityPantalla3Binding

class Pantalla3 : AppCompatActivity() {

    private lateinit var binding: ActivityPantalla3Binding
    private var usuarioMutableList: MutableList<Usuario> = UsuariosProvider.usuarioList.toMutableList()
    private lateinit var adapter: UsuarioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPantalla3Binding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = UsuarioAdapter(
            usuarioList = usuarioMutableList,
            onClickListener = { usuario -> onItemSelected(usuario) },
            onClickDelete = { position -> onDeletedItem(position) }
        )
        binding.recyclerUsuario.layoutManager = LinearLayoutManager(this)
        binding.recyclerUsuario.adapter = adapter
    }

    private fun onDeletedItem(position: Int) {
        usuarioMutableList.removeAt(position)
        adapter.notifyItemRemoved(position)
        adapter.notifyItemRangeChanged(position, usuarioMutableList.size)
    }



    private fun onItemSelected(usuario: Usuario) {
        Toast.makeText(this, usuario.realName, Toast.LENGTH_SHORT).show()
    }
}
