package id.anonhive.app

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.replaceAll
import id.anonhive.app.auth.component.SignedOutComponent
import id.anonhive.app.main.component.SignedInComponent
import kotlinx.serialization.Serializable

class AppComponent(componentContext: ComponentContext) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.SignedOut,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.SignedOut -> Child.SignedOut(
                SignedOutComponent(
                    componentContext = context,
                    onSignedIn = { navigation.replaceAll(Configuration.SignedIn) }
                )
            )

            Configuration.SignedIn -> Child.SignedIn(
                SignedInComponent(
                    componentContext = context,
                    onSignedOut = { navigation.replaceAll(Configuration.SignedOut) }
                )
            )
        }
    }

    sealed class Child {
        data class SignedIn(val component: SignedInComponent): Child()
        data class SignedOut(val component: SignedOutComponent): Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object SignedIn : Configuration()

        @Serializable
        data object SignedOut : Configuration()
    }
}