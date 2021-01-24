package com.example.intentservice

import android.app.IntentService
import android.content.Intent
import android.util.Log

class MyIntentService : IntentService("MyIntentService") {
//put the service in the manifest first

    init {
        instance = this
    }

    companion object {
        private lateinit var instance: MyIntentService
        var isRunning = false
        private const val TAG = "MyIntentService"

        fun stopService() {
            Log.d(TAG, "stopService: stopping MyIntentService")
            if (!isRunning)
                Log.d(TAG, "stopService: Cannot stop service , service is not running currently")
            else {
                isRunning = false
                Log.d(TAG, "stopService: service stopped")
                instance.stopSelf()
            }
        }
    }

    override fun onHandleIntent(intent: Intent?) {
        try {
            Thread.sleep(20)
            isRunning = true
            var x = 20
            while (isRunning) {
                Log.d(TAG, "onHandleIntent: Service is Running x= $x")
                Thread.sleep(500)
                if (--x < 0)
                    stopService()
            }
        } catch (e: InterruptedException) {
            Log.d(TAG, "onHandleIntent: error")
            Thread.currentThread().interrupt()
        }
        //stopService()
        //no need for this statement
    }

}