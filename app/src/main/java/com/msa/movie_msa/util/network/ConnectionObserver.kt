package com.msa.movie_msa.util.network

import android.content.Context
import android.content.Context.CONNECTIVITY_SERVICE
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities.NET_CAPABILITY_INTERNET
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory


class ConnectionObserver(context: Context) {


    private val cManager = context.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

    @Suppress("DEPRECATION")
    suspend fun hasInternetConnection(): Boolean {
        return if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            val activeNetwork = cManager.activeNetwork ?: return false
            checkNetworkInternetConnection(activeNetwork)
        } else {
            val networkInfo = cManager.activeNetworkInfo ?: return false
            if (networkInfo.isConnectedOrConnecting)
                DoesNetworkHaveInternet.execute(SocketFactory.getDefault())
            else
                false
        }

    }

    private suspend fun checkNetworkInternetConnection(network: Network): Boolean {
        val networkCapabilities =
            cManager.getNetworkCapabilities(network) ?: return false

        val hasInternetCapability =
            networkCapabilities.hasCapability(NET_CAPABILITY_INTERNET)

        return if (hasInternetCapability) {
            // check if this network actually has internet
            DoesNetworkHaveInternet.execute(network.socketFactory)
        } else
            false
    }

    /**
     * Send a ping to googles primary DNS.
     * If successful, that means we have internet.
     */
    object DoesNetworkHaveInternet {
        // Make sure to execute this on a background thread.
        suspend fun execute(socketFactory: SocketFactory): Boolean = withContext(Dispatchers.IO) {
            runCatching {
                try {
                    val socket =
                        socketFactory.createSocket() ?: throw IOException("Socket is null.")
                    socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
                    socket.close()
                    true
                } catch (e: IOException) {
                    false
                }
            }.isSuccess
        }
    }

}