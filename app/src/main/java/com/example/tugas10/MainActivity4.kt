package com.example.tugas10

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.tugas10.model.realm.realm
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main4.*


class MainActivity4 : AppCompatActivity() {

    lateinit var realm1 : Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        View()
        getdata()
        updatedata()
       deletedata()
        back()
    }

    private fun View(){
        realm1 = Realm.getDefaultInstance()
    }

    private fun getdata() {
        et3.setText(intent.getStringExtra("kata"))
        et4.setText(intent.getStringExtra("kata2"))
    }

    private fun updatedata() {
        button6.setOnClickListener {
            realm1.beginTransaction()
            realm1.where(realm::class.java).equalTo("id",intent.getIntExtra("id",1)).findFirst().let {
                it!!.setInputt(et4.text.toString())
                it!!.setInput(et3.text.toString())
            }
            realm1.commitTransaction()
            Toast.makeText(this,"Catatan telah ter update",Toast.LENGTH_SHORT).show()
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }

    }

    private fun deletedata() {
        button8.setOnClickListener {
            realm1.beginTransaction()
            realm1.where(realm::class.java).equalTo("id", intent.getIntExtra("id", 1)).findFirst().let {
                it!!.deleteFromRealm()
                realm1.commitTransaction()
                Toast.makeText(this,"Catatan telah ter hapus",Toast.LENGTH_SHORT).show()
                startActivity(Intent(this,MainActivity::class.java))
                finish()

            }
        }
    }

    private fun back() {
        button7.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }


    }






}