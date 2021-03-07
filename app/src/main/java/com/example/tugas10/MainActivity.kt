package com.example.tugas10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.tugas10.Adapter.adapernotes
import com.example.tugas10.databinding.ActivityMainBinding
import com.example.tugas10.model.realm.realm
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var realm1 : Realm
    lateinit var adapter : adapernotes
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getall()
        phars()

    }

    private fun getall() {
        binding.rcy.layoutManager = LinearLayoutManager(this)
        adapter = adapernotes(mutableListOf(), object : adapernotes.clickAdaper{
            override fun onClick(user: realm) {
                startActivity(Intent(this@MainActivity, MainActivity4::class.java)
                    .putExtra("kata", user.getInput())
                    .putExtra("kata2", user.getInputt())
                )
                finish()
            }
        })
        binding.rcy.adapter = adapter
        realm1 = Realm.getDefaultInstance()
        realm1.where(realm::class.java).findAll().let {
            adapter.setData(it)
        }
    }
    private fun phars() {
        button2.setOnClickListener {
            finish()
        }
        button3.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
            finish()

        }
    }
}