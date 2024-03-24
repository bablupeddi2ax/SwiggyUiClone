package com.example.swiggyclone

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter(private val carouselItems: MutableList<String>,private val context: Context) : RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {

    inner class CarouselViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textEventContent: TextView = itemView.findViewById(R.id.textEventContent)
        val buttonNavigateEvent: Button = itemView.findViewById(R.id.buttonNavigateEvent)
        val deadlineEventContent:TextView = itemView.findViewById(R.id.textDeadline)
        val imageEvent:ImageView = itemView.findViewById(R.id.imgEventImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.carousel_item, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        val eventContent = carouselItems[position]
        holder.textEventContent.text = eventContent
        holder.deadlineEventContent.text = eventContent
        holder.buttonNavigateEvent.setOnClickListener {
            context.startActivity(Intent(context,EventActivity::class.java))
            // Handle button click event here
        }
    }

    override fun getItemCount(): Int {
        return carouselItems.size
    }
}
