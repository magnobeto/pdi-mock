package com.example.retrofitdemo.presentation.mvp

import com.example.retrofitdemo.data.model.Albums
import io.reactivex.rxjava3.core.Observer

interface MainContract {
    /**
     * No contrato podemos definir todos os métodos que são mandatórios
     * de implementação pelas camadas View e Presenter de cada uma de nossas
     * Activities ou Fragments
     */
    /**
     * Nossa LoginActivity precisa implementar os métodos definidos abaixo
     */
    interface View : BaseView<MainPresenter> {
        fun initRecyclerView()
        fun getAlbums()
        fun observe()
    }

    /**
     * Nosso Presenter precisa implementar os seguintes métodos
     */
    interface Presenter : BasePresenter {
        fun getAlbums()
        fun getAlbumsObserverRX(): Observer<Albums>
    }
}
