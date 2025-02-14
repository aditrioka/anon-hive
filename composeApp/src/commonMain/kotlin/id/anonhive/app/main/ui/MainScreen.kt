package id.anonhive.app.main.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import id.anonhive.app.main.component.MainComponent
import id.anonhive.app.main.component.SignedInComponent

@Composable
fun MainScreen(component: MainComponent, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Main Screen", textAlign = TextAlign.Center)
    }
}