package com.example.retrofitdemo.presentation.mvp

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
    }
}
