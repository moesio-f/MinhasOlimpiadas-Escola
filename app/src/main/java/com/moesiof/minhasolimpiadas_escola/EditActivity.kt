package com.moesiof.minhasolimpiadas_escola

import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.moesiof.minhasolimpiadas_escola.database.Database
import com.moesiof.minhasolimpiadas_escola.ui.home.Olympics
import kotlinx.android.synthetic.main.activity_edit.*

class EditActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)

        val olympics = intent?.getParcelableExtra<Olympics>("olympics")!!
        Glide.with(baseContext).load(olympics.imgURL).apply(RequestOptions.fitCenterTransform()).into(logo)
        labelName.text = olympics.name
        registrationOpen_text.text = olympics.registrationOpen
        registrationClose_text.text = olympics.registrationClose
        day_text.text = olympics.day
        description_text.text = Editable.Factory().newEditable(olympics.description)
        teacher_text.text = Editable.Factory().newEditable(olympics.teacher)

        saveBtn.setOnClickListener {
            if(verifyInputs())
            {
                olympics.teacher = teacher_text.text.toString()
                Database().updateToDatabase(Database.schoolCollection, "relation", olympics.name, olympics.teacher).addOnSuccessListener {
                    finish()
                }
            }
        }
    }

    private fun verifyInputs(): Boolean {

        var isValidInput = true

        if (teacher_text.text.toString().trim().isEmpty()) {
            teacher_input.error = "O campo não pode ser vazio!"
            isValidInput = false
        }

        return isValidInput
    }
}