package com.example.retrofitdemo.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.RetrofitInstance
import com.example.retrofitdemo.data.api.AlbumService
import com.example.retrofitdemo.databinding.ActivityMainBinding
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by inject()
    private lateinit var retrofitService: AlbumService
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        retrofitService = RetrofitInstance.getRetrofitInstance()
            .create(AlbumService::class.java)
    }

    private fun initRecyclerView() {
        binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter()
        binding.mainRecyclerView.adapter = adapter
        getAlbuns()
    }

    private fun getAlbuns() {
        binding.mainProgressBar.visibility = View.VISIBLE
        val responseLivaData = liveData {
            val response = retrofitService.getAlbums()
            emit(response)
        }
        responseLivaData.observe(this) {

        }
    }
}