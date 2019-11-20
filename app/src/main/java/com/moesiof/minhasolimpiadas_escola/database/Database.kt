package com.moesiof.minhasolimpiadas_escola.database

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.Source
import com.google.firebase.storage.FirebaseStorage

class Database {

    val db = FirebaseFirestore.getInstance()
    val storage = FirebaseStorage.getInstance()
    val storageRef = storage.reference


    fun addToDatabase(collection: String, document : String, data: Any) : Task<*>
    {
        return db.collection(collection).document(document).set(data)
    }

    fun getFromDatabase(collection: String, document : String) : Task<DocumentSnapshot>
    {
        return db.collection(collection).document(document).get(Source.SERVER)
    }

    fun getFromDatabase(collection: String) : Task<QuerySnapshot>
    {
        return db.collection(collection).get(Source.SERVER)
    }

    fun getFromDatabase(collection: String, base : String, targetValue : Any) : Task<QuerySnapshot>
    {
        return db.collection(collection).whereEqualTo(base, targetValue).get()
    }

    companion object {
        lateinit var schoolCollection : String
        fun setCollection(collection: String) { schoolCollection = collection }
    }
}