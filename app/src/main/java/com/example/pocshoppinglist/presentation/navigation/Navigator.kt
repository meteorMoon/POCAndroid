package com.example.pocshoppinglist.presentation.navigation

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object Navigator {
    private val navChannel = Channel<Screen>()
    val navChannelEvent = navChannel.receiveAsFlow()

    fun navigateTo(navTarget: Screen) {
        navChannel.trySend(navTarget)
    }
}