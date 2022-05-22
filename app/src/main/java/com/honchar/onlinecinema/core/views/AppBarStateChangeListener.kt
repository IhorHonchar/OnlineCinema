package com.honchar.onlinecinema.core.views

import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import kotlin.math.abs


abstract class AppBarStateChangeListener : OnOffsetChangedListener {
    sealed interface State {
        object EXPANDED : State
        object COLLAPSED : State
        object IDLE : State
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, i: Int) {
        when {
            i == 0 -> {
                onStateChanged(appBarLayout, State.EXPANDED)
            }
            abs(i) >= appBarLayout.totalScrollRange -> {
                onStateChanged(appBarLayout, State.COLLAPSED)
            }
            else -> {
                onStateChanged(appBarLayout, State.IDLE)
            }
        }
    }

    abstract fun onStateChanged(appBarLayout: AppBarLayout, state: State)
}