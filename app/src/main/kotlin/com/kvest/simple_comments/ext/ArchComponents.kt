package com.kvest.simple_comments.ext

import android.arch.lifecycle.*
import android.support.v7.app.AppCompatActivity

/**
 * Created by kvest on 3/20/18.
 */
inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(): T {
    return ViewModelProviders.of(this)[T::class.java]
}

inline fun <reified T : ViewModel> AppCompatActivity.withViewModel(body: T.() -> Unit): T {
    val vm = getViewModel<T>()
    vm.body()
    return vm
}

fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}

inline fun <reified T : ViewModel> AppCompatActivity.withViewModel(
        crossinline factory: () -> T,
        body: T.() -> Unit
): T {
    val vm = getViewModel(factory)
    vm.body()
    return vm
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel(crossinline factory: () -> T): T {
    val vmFactory = object : ViewModelProvider.Factory {
        override fun <U : ViewModel> create(modelClass: Class<U>) = factory() as U
    }

    return ViewModelProviders.of(this, vmFactory)[T::class.java]
}