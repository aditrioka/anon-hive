package id.anonhive.app.auth.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.anonhive.app.auth.event.LandingEvent
import id.anonhive.app.auth.component.LandingComponent

@Composable
fun LandingScreen(
    component: LandingComponent,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Landing Screen")
        Button(
            onClick = { component.onEvent(LandingEvent.OnSignInClick) }
        ) {
            Text(text = "Sign In")
        }
        Button(
            onClick = { component.onEvent(LandingEvent.OnSignUpClick) }
        ) {
            Text(text = "Sign Up")
        }
    }
}