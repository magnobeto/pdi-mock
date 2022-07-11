package com.example.retrofitdemo.presentation.mvc

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainController : IMainController, KoinComponent {

    private var albumsLV = MutableLiveData<Albums>()
    val albums: LiveData<Albums> = albumsLV

    private val getAlbumsUseCase: GetAlbumsUseCase by inject()

    override fun start(initView: () -> Unit) {
        initView.invoke()
    }

    override fun getAlbums() {
        getAlbumsUseCase.execute(getAlbumsObserverRX())
    }

    override fun getAlbumsObserverRX(): Observer<Albums> {
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