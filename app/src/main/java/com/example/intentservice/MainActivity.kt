package com.example.intentservice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: handle")

        /*Intent(this, MyService::class.java).also { intent ->
            startService(intent)
        }*/
        startServiceButton.setOnClickListener {
            Intent(this, MyIntentService::class.java).also { intent ->
                if (MyIntentService.isRunning)
                    Log.d(TAG, "onCreate: service is already Running")
                else
                startService(intent)
            }
        }
        stopServiceButton.setOnClickListener {
            MyIntentService.stopService()
            //Singleton , therefor no need to use the same intent variable.
        }
    }
}