package id.anonhive.app.auth.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import id.anonhive.app.auth.component.SignInComponent
import id.anonhive.app.auth.event.SignInEvent

@Composable
fun SignInScreen(component: SignInComponent, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In Screen")
        Button(
            onClick = { component.onEvent(SignInEvent.OnSignInClick) }
        ) {
            Text(text = "Sign In")
        }
    }
}