package com.example.home_task_l15

import android.graphics.Color
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.text.style.UnderlineSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.member_of_list.view.*

class MyAdapter() : RecyclerView.Adapter<ExampleViewHolder>() {
    val values: ArrayList<User> = arrayListOf()
    override fun getItemCount() = values.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.member_of_list, parent, false)
        return ExampleViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        holder.bind(values[position])
    }

    fun addItemToList(item : User){
        values.add(item)
        notifyItemInserted(values.size - 1)
    }
}

class ExampleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(person: User) {
        val line = "${person.firstName} ${person.secondName}"
        val spannableString = SpannableString(line)
        val startIndex = line.indexOf(person.secondName)
        val endIndex = startIndex + person.secondName.length
        val flag = 0
        spannableString.setSpan(ForegroundColorSpan(Color.RED), startIndex, endIndex, flag)
        spannableString.setSpan(UnderlineSpan(), startIndex, endIndex, flag)
        itemView.text_list_item.text = spannableString
    }

}