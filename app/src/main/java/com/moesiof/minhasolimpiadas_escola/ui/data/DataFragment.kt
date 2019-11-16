package com.moesiof.minhasolimpiadas_escola.ui.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.moesiof.minhasolimpiadas_escola.R
import com.moesiof.minhasolimpiadas_escola.database.School

class DataFragment : Fragment() {

    private lateinit var dataViewModel: DataViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        dataViewModel = ViewModelProviders.of(this).get(DataViewModel::class.java)

        val root = inflater.inflate(R.layout.fragment_data, container, false)
        val schoolName: TextView = root.findViewById(R.id.schoolName_text)
        val schoolEmail: TextView = root.findViewById(R.id.schoolEmail_text)
        val schoolPrincipal: TextView = root.findViewById(R.id.schoolPrincipal_text)
        val schoolPhone: TextView = root.findViewById(R.id.schoolPhone_text)
        val schoolAddress: TextView = root.findViewById(R.id.schoolAddress_text)
        val schoolINEP: TextView = root.findViewById(R.id.schoolINEP_text)
        val schoolCode: TextView = root.findViewById(R.id.schoolCode_text)
        val schoolPassword: TextView = root.findViewById(R.id.schoolPassword_text)
        val progressBar: ProgressBar = root.findViewById(R.id.progressbar_data)
        val schoolIMG: ImageView = root.findViewById(R.id.schoolIMG)


        dataViewModel.getSchool().observe(this, Observer<School> {
            progressBar.visibility = View.GONE
            schoolIMG.visibility = View.VISIBLE

            schoolName.text = it.name
            schoolName.visibility = View.VISIBLE

            schoolEmail.text = "Email: ${it.email}"
            schoolEmail.visibility = View.VISIBLE

            schoolPrincipal.text = "Gestor(a): ${it.principal}"
            schoolPrincipal.visibility = View.VISIBLE

            schoolPhone.text = "Telefone: ${it.phone}"
            schoolPhone.visibility = View.VISIBLE

            schoolAddress.text = "Endereço: ${it.address}"
            schoolAddress.visibility = View.VISIBLE

            schoolINEP.text = "Código Inep: ${it.inepCode}"
            schoolINEP.visibility = View.VISIBLE

            schoolCode.text = "Código da escola: ${it.idCode}"
            schoolCode.visibility = View.VISIBLE

            schoolPassword.text = "Senha da escola: ${it.password}"
            schoolPassword.visibility = View.VISIBLE
        })

        return root
    }
}