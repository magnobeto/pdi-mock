package com.example.retrofitdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.presentation.mvc.IMainAcitivity
import com.example.retrofitdemo.presentation.mvc.MainController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity(), IMainAcitivity {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    lateinit var mainController: MainController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        mainController = MainController()
        mainController.start(::initRecyclerView) // Chama o método responsável por dizer a View o que deve ser inicializado.
    }

    override fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter()
        binding.mainRecyclerView.adapter = adapter
        getAlbums()
        observe()
    }

    override fun getAlbums() {
        CoroutineScope(Dispatchers.IO).launch {
            mainController.getAlbums()
        }
    }

    override fun observe() {
        binding.mainProgressBar.visibility = View.VISIBLE
        mainController.albums.observe(this) {
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.mainProgressBar.visibility = View.GONE
            } else {
                binding.mainProgressBar.visibility = View.GONE
            }
        }
    }
}