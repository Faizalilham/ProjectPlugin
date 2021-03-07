package com.example.tugas10.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tugas10.R
import com.example.tugas10.model.realm.realm
import io.realm.RealmResults
import kotlinx.android.synthetic.main.layout.view.*

class adapernotes(private val user : MutableList<realm> = mutableListOf(),private  val Listener : clickAdaper):RecyclerView.Adapter<adapernotes.userViewHolder>() {



    inner class userViewHolder(a : View) : RecyclerView.ViewHolder(a){
        val tv : TextView = a.findViewById(R.id.tv1)
        val tvText : TextView = a.findViewById(R.id.tv2)

        fun bindView( b : realm){
            tvText.text = b.getInput()
            tv.text = b.getInputt()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): userViewHolder {
       return userViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout,parent,false))
    }

    override fun onBindViewHolder(holder: userViewHolder, position: Int) {
        holder.bindView(user[position])
        holder.itemView.setOnClickListener {
            Listener.onClick(user[position])
        }
    }

    override fun getItemCount(): Int {
        return user.size
    }
    interface clickAdaper{
        fun onClick(user : realm)
    }
    fun setData(data : List<realm>){
        user.clear()
        user.addAll(data)
        notifyDataSetChanged()
    }

}