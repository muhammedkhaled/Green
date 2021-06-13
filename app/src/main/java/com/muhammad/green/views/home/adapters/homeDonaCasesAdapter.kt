package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.UserCasePay

class homeDonaCasesAdapter(private var list: ArrayList<UserCasePay>, private val listener: (UserCasePay) -> Unit)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun addData(myCases: ArrayList<UserCasePay>){
        list.addAll(myCases)
        notifyDataSetChanged()
    }

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

