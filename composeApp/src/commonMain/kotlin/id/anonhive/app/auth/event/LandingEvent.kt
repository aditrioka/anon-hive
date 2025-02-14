package id.anonhive.app.auth.event

sealed interface LandingEvent {
    data object OnSignInClick : LandingEvent
    data object OnSignUpClick : LandingEvent
}