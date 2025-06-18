package com.example.practice.core_ui

import android.service.credentials.Action
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.StateFlow

abstract class AbstractViewModel : ViewModel() {

    abstract val state: StateFlow<Lifecycle.State>

    open fun doAction(action: Action) = Unit
}