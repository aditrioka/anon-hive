package id.anonhive.app

import androidx.compose.ui.window.ComposeUIViewController
import com.arkivanov.decompose.DefaultComponentContext
import com.arkivanov.essenty.lifecycle.LifecycleRegistry
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    val root = AppComponent(DefaultComponentContext(LifecycleRegistry()))
    return ComposeUIViewController { App(root) }
}