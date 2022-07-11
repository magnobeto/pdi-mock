package com.example.retrofitdemo.presentation.mvp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.retrofitdemo.data.model.Albums
import com.example.retrofitdemo.domain.GetAlbumsUseCase
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainPresenter : MainContract.Presenter, KoinComponent {

    private var albumsLV = MutableLiveData<Albums>()
    val albums: LiveData<Albums> = albumsLV

    private val getAlbumsUseCase: GetAlbumsUseCase by inject()

    /**
     * No Presenter podemos definir um método comum a todas as camadas
     * Aqui podemos fazer o Bind das views necessárias na Activity
     * ou qualquer outra inicialização necessária
     */
    override fun start(initView: () -> Unit) {
        initView.invoke()
    }

    /**
     * Principal lógica responsável pelo login e senha do nosso aplicativo
     * Simplificando a separação de camadas do software.
     */
    override fun getAlbums() {
        getAlbumsUseCase.execute {
            albumsLV.postValue(it)
        }
    }
}