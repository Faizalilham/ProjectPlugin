package com.example.tugas10.model.realm

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class realm: RealmObject() {

    private  var id : Int? = null
    private var Judul : String? = null
    private var Kalimat: String? = null


    fun setid(id : Int){
        this.id = id
    }
    fun getid():Int?{
        return id
    }

    fun setInputt(judul : String){
        this.Judul = judul
    }
    fun getInputt():String?{
        return Judul
    }

    fun setInput(Kalimat : String){
        this.Kalimat = Kalimat
    }
    fun getInput():String?{
        return Kalimat
    }

}