package com.honchar.onlinecinema.core.navigation

import androidx.fragment.app.Fragment

interface NavigationHandler {
    fun displayFragment(frag: Fragment, backStack: String?)
}