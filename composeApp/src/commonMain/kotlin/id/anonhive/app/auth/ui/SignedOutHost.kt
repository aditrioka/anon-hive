package id.anonhive.app.auth.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation

import id.anonhive.app.auth.component.SignedOutComponent

@Composable
fun SignedOutHost(component: SignedOutComponent, modifier: Modifier = Modifier) {

    Children(
        stack = component.childStack,
        animation = stackAnimation(slide())
    ) {
        when (val child = it.instance) {
            is SignedOutComponent.Child.Landing -> LandingScreen(child.component)
            is SignedOutComponent.Child.SignIn -> SignInScreen(child.component)
            is SignedOutComponent.Child.SignUp -> SignUpScreen(child.component)
        }
    }
}