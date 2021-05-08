package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R

class homeDonaCasesAdapter(private var list: List<String>, private val listener: (String) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DonationCasesVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_donation_cases_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
    }

    override fun getItemCount() = list.size
}


class DonationCasesVH(itemView: View) : RecyclerView.ViewHolder(itemView){

}

