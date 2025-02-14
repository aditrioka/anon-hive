package id.anonhive.app.main.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import kotlinx.serialization.Serializable

class SignedInComponent(
    componentContext: ComponentContext,
    val onSignedOut: () -> Unit
) : ComponentContext by componentContext{

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Main,
        handleBackButton = true,
        childFactory = ::createChild
    )

    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Child {
        return when (config) {
            Configuration.Main -> Child.Main(
                MainComponent(
                    componentContext = context
                )
            )
        }
    }

    fun signOut() {
        onSignedOut()
    }

    sealed class Child {
        data class Main(val component: MainComponent): Child()
    }

    @Serializable
    sealed class Configuration {

        @Serializable
        data object Main : Configuration()
    }
}
