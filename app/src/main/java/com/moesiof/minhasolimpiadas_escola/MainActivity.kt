package com.moesiof.minhasolimpiadas_escola

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.moesiof.minhasolimpiadas_escola.database.Database
import com.moesiof.minhasolimpiadas_escola.database.School
import kotlinx.android.synthetic.main.login_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val loginBT = findViewById<Button>(R.id.loginBT)
        val registerBT = findViewById<Button>(R.id.registerBT)

        loginBT.setOnClickListener {
            if(verifyInputs())
            {
                val code = schoolCode_edit.text.toString()
                val pass = schoolPassword_edit.text.toString()
                progressLogin.visibility = View.VISIBLE
                Database().getFromDatabase(code, "info").addOnCompleteListener{ task ->
                    progressLogin.visibility = View.GONE
                    if(task.isSuccessful)
                    {
                        val data = task.result
                        val school = School(data!!["name"].toString(), data["principal"].toString(),
                            data["email"].toString(), data["phone"].toString(),
                            data["address"].toString(),data["inepCode"].toString(),
                            data["idCode"].toString(),data["password"].toString())

                        if(school.password == pass)
                        {
                            val  nextActivity = Intent(this, HomeActivity::class.java)
                            nextActivity.putExtra("school", school)
                            startActivity(nextActivity)
                        }
                        else
                        {
                            Toast.makeText(baseContext,"Senha e/ou usuário não encontrados...", Toast.LENGTH_LONG).show()
                        }
                    }
                    else
                    {
                        Toast.makeText(baseContext,"Não foi possível conectar-se ao servidor... Tente novamente", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        registerBT.setOnClickListener {
           val  nextActivity = Intent(this, RegisterActivity::class.java)
            startActivity(nextActivity)
        }
    }

    private fun verifyInputs(): Boolean {

        var isValidInput = true

        if (schoolCode_edit.text.toString().trim().isEmpty()) {
            schoolCode_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if (schoolPassword_edit.text.toString().trim().isEmpty()){
            schoolPassword_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        return isValidInput
    }
}
