package id.anonhive.app.auth.event

sealed interface SignInEvent {
    data object OnSignInClick : SignInEvent
}