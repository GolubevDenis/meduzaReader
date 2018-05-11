package com.golubev.denis.meduzareader.data.android.internetconnection

import android.content.Context
import android.net.ConnectivityManager
import javax.inject.Inject

class NetworkConnectionManagerImpl @Inject constructor(
        val context: Context
) : NetworkConnectionManager {

    override fun haveNetworkConnection(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
    }

}