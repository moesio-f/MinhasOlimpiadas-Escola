package com.moesiof.minhasolimpiadas_escola.database

class School (val name : String, val principal : String, val email : String, val phone : String, val address : String, val inepCode : String, val idCode : String, val password : String) {
    //Relação professores + olimpiadas
    //Comentários/Sugestões

    fun hashMap() : HashMap<String, String>
    {
        return hashMapOf(
            "name" to name,
            "principal" to principal,
            "email" to email,
            "phone" to phone,
            "address" to address,
            "inepCode" to inepCode,
            "idCode" to idCode,
            "password" to password
        )
    }
}