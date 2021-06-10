package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.Category
import com.muhammad.green.views.home.response.VisitorHomeData

class CasesTypeAdapter(private var list: ArrayList<Category>, private val listener: (Category) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun addData(visitorData: ArrayList<Category>){
        list.addAll(visitorData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DonationCasesVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_cases_type_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
    }

    override fun getItemCount() = list.size
}


class CasesTypeVH(itemView: View) : RecyclerView.ViewHolder(itemView){

}

