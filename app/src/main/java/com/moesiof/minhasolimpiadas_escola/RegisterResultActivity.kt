package com.moesiof.minhasolimpiadas_escola

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.moesiof.minhasolimpiadas_escola.database.School
import kotlinx.android.synthetic.main.register_result.*


class RegisterResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_result)

        val school : School = intent?.getParcelableExtra("school")!!
        code.text = "O código da sua escola é: ${school.idCode}"
        pass.text = "A senha de acesso para sua escola é ${school.password}"
        next.setOnClickListener {
            val nextActivity = Intent(this, HomeActivity::class.java)
            nextActivity.putExtra("school", school)
            startActivity(nextActivity)
        }
    }

}