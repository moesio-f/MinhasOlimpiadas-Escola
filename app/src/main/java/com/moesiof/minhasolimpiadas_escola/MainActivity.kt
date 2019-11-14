package com.moesiof.minhasolimpiadas_escola

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val loginBT = findViewById<Button>(R.id.loginBT)
        val registerBT = findViewById<Button>(R.id.registerBT)

        loginBT.setOnClickListener {
            //TODO: Firebase Instance and Check
        }

        registerBT.setOnClickListener {
           val  nextActivity = Intent(this, RegisterActivity::class.java)
            startActivity(nextActivity)
        }
    }
}
