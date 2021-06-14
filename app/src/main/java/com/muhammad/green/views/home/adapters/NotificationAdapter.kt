package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.NotificationData
import com.muhammad.green.views.home.response.UserCasePay

class NotificationAdapter(private var list: ArrayList<NotificationData>, private val listener: (NotificationData) -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    fun addData(myCases: ArrayList<NotificationData>){
        list.addAll(myCases)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DonationCasesVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.notification_item, parent, false))

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
    }

    override fun getItemCount() = list.size
}


class NotificationVH(itemView: View) : RecyclerView.ViewHolder(itemView){

}

