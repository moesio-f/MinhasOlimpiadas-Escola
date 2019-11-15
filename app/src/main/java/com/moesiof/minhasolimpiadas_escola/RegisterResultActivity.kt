package com.moesiof.minhasolimpiadas_escola

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.register_result.*


class RegisterResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_result)

        val idCode : String? = intent?.getStringExtra("idCode")
        val password : String? = intent?.getStringExtra("password")
        code.text = "O código da sua escola é: $idCode"
        pass.text = "A senha de acesso para sua escola é $password"
        next.setOnClickListener {
            val nextActivity = Intent(this, HomeActivity::class.java)
            startActivity(nextActivity)
        }
    }

}