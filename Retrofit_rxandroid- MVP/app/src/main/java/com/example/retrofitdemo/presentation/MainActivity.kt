package com.example.retrofitdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.databinding.ActivityMainBinding
import com.example.retrofitdemo.presentation.mvp.MainContract
import com.example.retrofitdemo.presentation.mvp.MainPresenter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: MainAdapter

    override lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = MainPresenter()
        presenter.start(::initRecyclerView) // Chama o método responsável por dizer a View o que deve ser inicializado.
    }

    override fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter()
        binding.mainRecyclerView.adapter = adapter
        getAlbums()
        observe()
    }

    override fun getAlbums() {
        presenter.getAlbums()
    }

    override fun observe() {
        binding.mainProgressBar.visibility = View.VISIBLE
        presenter.albums.observe(this) {
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