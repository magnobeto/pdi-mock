package com.example.retrofitdemo.presentation.mvp

class LoginPresenter(private val view: MainContract.View) : MainContract.Presenter {

    /**
     * No Presenter podemos definir um método comum a todas as camadas
     * Aqui podemos fazer o Bind das views necessárias na Activity
     * ou qualquer outra inicialização necessária
     */
    override fun start() {
        view.bindViews()
    }

    /**
     * Principal lógica responsável pelo login e senha do nosso aplicativo
     * Simplificando a separação de camadas do software.
     */
    override fun isLoginValid(userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) {
            view.displayErrorMessage()
        } else {
            view.displaySucessToast()
            view.startHomeActivity()
            view.displayErrorMessage()

        }
    }
}