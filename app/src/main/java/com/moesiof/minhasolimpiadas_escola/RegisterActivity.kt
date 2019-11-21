package com.moesiof.minhasolimpiadas_escola

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.moesiof.minhasolimpiadas_escola.database.Database
import com.moesiof.minhasolimpiadas_escola.database.School
import kotlinx.android.synthetic.main.register_activity.*

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_activity)

        registerBT.setOnClickListener {
            if(verifyInputs()) {
                val code = createCode()
                val pass = createPassword()
                val school = School(schoolName_edit.text.toString(),
                    schoolPrincipal_edit.text.toString(),
                    schoolEmail_edit.text.toString(),
                    schoolPhone_edit.text.toString(),
                    schoolAddress_edit.text.toString(),
                    schoolINEP_edit.text.toString(),
                    code, pass)

                progressBar.visibility = View.VISIBLE
                Database().addToDatabase(school.idCode, "info", school.hashMap()).addOnCompleteListener { task ->
                    progressBar.visibility = View.GONE
                    if(task.isSuccessful)
                    {
                        Database().getFromDatabase("Main").addOnSuccessListener {result ->
                            var list = mutableListOf<String>()
                            for(document in result)
                            {
                                list.add(document.id)
                            }
                            Database().addToDatabase(school.idCode, "relation", createDeafultMap(list)).addOnSuccessListener {
                                Toast.makeText(baseContext,"Cadastro realizado com sucesso!", Toast.LENGTH_LONG).show()
                                val nextActivity = Intent(this, RegisterResultActivity::class.java)
                                nextActivity.putExtra("school", school)
                                startActivity(nextActivity)
                            }
                        }
                    }
                    else
                    {
                        Toast.makeText(baseContext,"Não foi possível cadastrar sua escola... Tente novamente", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }

    private fun verifyInputs(): Boolean{

        var isValidInput = true

        if (schoolName_edit.text.toString().trim().isEmpty()) {
            schoolName_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if (schoolPrincipal_edit.text.toString().trim().isEmpty()){
            schoolPrincipal_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if(schoolEmail_edit.text.toString().trim().isEmpty()){
            schoolEmail_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        if(schoolPhone_edit.text.toString().trim().isEmpty()){
            schoolPhone_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }
        if(schoolAddress_edit.text.toString().trim().isEmpty()){
            schoolAddress_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }
        if(schoolINEP_edit.text.toString().trim().isEmpty()){
            schoolINEP_edit.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        return isValidInput
    }

    private fun createCode() : String{
        val n1 = (0..9).random().toString()
        val n2 = (0..9).random().toString()
        val char1 = ('A'..'Z').random().toString()
        val char2 = ('A'..'Z').random().toString()

        return char1 + char2 + n1 + n2
    }

    private fun createPassword() : String{
        var result = ""
        for(ch in 0..8)
        {
            result += getRandomChar()
        }
        return result
    }

    private fun getRandomChar() : String{
        val ch = ('A'..'Z').random()
        return ch.toString()
    }

    private fun createDeafultMap(values : MutableList<String>) : HashMap<String, String>
    {
        val hash = HashMap<String, String>()
        for(value in values)
        {
            hash[value] = "Sem Professor"
        }
        return hash
    }
}