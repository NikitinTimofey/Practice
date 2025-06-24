package com.example.practice.core.common

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class AbstractViewModel : ViewModel() {

    abstract val state: StateFlow<State>

    open fun doAction(action: Action) = Unit
}