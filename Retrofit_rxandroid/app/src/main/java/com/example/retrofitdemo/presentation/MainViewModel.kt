package com.example.retrofitdemo.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable

class MainViewModel(private val getAlbumsUseCase: GetAlbumsUseCase) : ViewModel() {

    private var albumsLV = MutableLiveData<Albums>()
    val albums: LiveData<Albums> = albumsLV

    fun getAlbums() {
        getAlbumsUseCase.execute(getAlbumsObserverRX())
    }

    private fun getAlbumsObserverRX(): Observer<Albums> {
        val observer = object : Observer<Albums> {
            override fun onSubscribe(d: Disposable) {
                // starting showing progress indicator
            }

            override fun onNext(albums: Albums) {
                albumsLV.postValue(albums)
            }

            override fun onError(throwable: Throwable) {
                Log.i("MyTag", throwable.message.toString())
            }

            override fun onComplete() {
                // hide progress indicator
            }

        }
        return observer
    }
}