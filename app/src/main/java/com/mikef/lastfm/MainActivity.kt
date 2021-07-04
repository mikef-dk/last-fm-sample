package com.mikef.lastfm

import android.os.Bundle
import com.mikef.lastfm.databinding.ActivityMainBinding
import com.mikef.lastfm.shared.navigation.NavigationDelegate
import org.koin.androidx.scope.ScopeActivity
import org.koin.core.parameter.parametersOf

class MainActivity : ScopeActivity() {

    private val navigationDelegate by scope.inject<NavigationDelegate> {
        parametersOf(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ActivityMainBinding.inflate(layoutInflater).also {
            setContentView(it.root)
        }

        navigationDelegate.initialize()
    }

}