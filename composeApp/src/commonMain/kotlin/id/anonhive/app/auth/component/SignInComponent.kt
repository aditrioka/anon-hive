package id.anonhive.app.auth.component

import com.arkivanov.decompose.ComponentContext
import id.anonhive.app.auth.event.SignInEvent

class SignInComponent(
    componentContext: ComponentContext,
    private val navigateToMain: () -> Unit
) : ComponentContext by componentContext {

    fun onEvent(event: SignInEvent) {
        when (event) {
            SignInEvent.OnSignInClick -> navigateToMain()
        }
    }
}