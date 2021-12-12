package com.geekbrains.dictionary

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo


class Tools {
    companion object {
        const val isDebug = BuildConfig.BUILD_TYPE == "debug"

        private val context = App.instance

        fun isOnline(): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetwork: NetworkInfo? = cm.activeNetworkInfo
            return activeNetwork?.isConnectedOrConnecting == true
        }
    }
}