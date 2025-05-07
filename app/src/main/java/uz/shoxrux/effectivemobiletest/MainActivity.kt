package uz.shoxrux.effectivemobiletest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import uz.shoxrux.core.cache.LocaleCache
import uz.shoxrux.effectivemobiletest.ui.theme.EffectiveMobileTestTheme
import uz.shoxrux.presentation.components.AppNavHost
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var cache: LocaleCache

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EffectiveMobileTestTheme {
                AppNavHost(cache)
            }
        }
    }
}