package id.anonhive.app.auth.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class SignedOutComponent(
    componentContext: ComponentContext,
    private val onSignedIn: () -> Unit
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Landing,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.Landing -> Child.Landing(
                LandingComponent(
                    componentContext = context,
                    navigateToSignIn = { navigation.pushNew(Configuration.SignIn) },
                    navigateToSignUp = { navigation.pushNew(Configuration.SignUp) },
                )
            )
            Configuration.SignIn -> Child.SignIn(
                SignInComponent(
                    componentContext = context,
                    navigateToMain = { onSignedIn() }
                )
            )
            Configuration.SignUp -> Child.SignUp(
                SignUpComponent(
                    componentContext = context
                )
            )
        }
    }

    sealed class Child {
        data class SignIn(val component: SignInComponent) : Child()
        data class SignUp(val component: SignUpComponent) : Child()
        data class Landing(val component: LandingComponent) : Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object SignIn : Configuration()

        @Serializable
        data object SignUp : Configuration()

        @Serializable
        data object Landing : Configuration()
    }
}
