package com.example.tugas10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.tugas10.model.realm.realm
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {

    lateinit var realm1 : Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        View()
        addnotes()
        back()



        }


    private fun View() {
        realm1 = Realm.getDefaultInstance()
    }

    private fun addnotes() {
        button5.setOnClickListener {
            realm1.beginTransaction()
            try {
                val dataa = realm1.createObject(realm::class.java)
                dataa.setInputt(text2.text.toString())
                dataa.setInput(text3.text.toString())
                realm1.commitTransaction()
                Toast.makeText(this,"Catatan Berhasil Ditambahkan",Toast.LENGTH_SHORT).show()

            }catch (e:Exception){
                Toast.makeText(this,"Eror",Toast.LENGTH_SHORT).show()
            }
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }
    private fun back() {
        button4.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }



}







