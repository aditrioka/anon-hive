package id.anonhive.app

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import org.jetbrains.compose.ui.tooling.preview.Preview

import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import com.arkivanov.decompose.extensions.compose.subscribeAsState
import id.anonhive.app.auth.ui.LandingScreen
import id.anonhive.app.auth.ui.SignedOutHost
import id.anonhive.app.main.ui.MainScreen
import id.anonhive.app.main.ui.SignedInHost

@Composable
@Preview
fun App(component: AppComponent) {
    MaterialTheme {
        val childStack by component.childStack.subscribeAsState()
        Children(
            stack = childStack,
            animation = stackAnimation(slide())
        ) { child ->
            when (val instance = child.instance) {
                is AppComponent.Child.SignedOut -> SignedOutHost(instance.component)
                is AppComponent.Child.SignedIn -> SignedInHost(instance.component)
            }
        }
    }
}