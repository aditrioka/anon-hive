package id.anonhive.app.auth.component

import com.arkivanov.decompose.ComponentContext
import id.anonhive.app.auth.event.LandingEvent

class LandingComponent(
    componentContext: ComponentContext,
    private val navigateToSignIn: () -> Unit,
    private val navigateToSignUp: () -> Unit
) : ComponentContext by componentContext {

    fun onEvent(event: LandingEvent) {
        when (event) {
            LandingEvent.OnSignInClick -> navigateToSignIn()
            LandingEvent.OnSignUpClick -> navigateToSignUp()
        }
    }
}