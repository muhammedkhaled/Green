package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.UserCasePay
import kotlin.math.roundToInt

class homeDonaCasesAdapter(private var list: ArrayList<UserCasePay>, private val listener: (UserCasePay) -> Unit)
    : RecyclerView.Adapter<DonationCasesVH>(){

    fun addData(myCases: ArrayList<UserCasePay>){
        list.addAll(myCases)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DonationCasesVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_donation_cases_item, parent, false))

    override fun onBindViewHolder(holder: DonationCasesVH, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}


class DonationCasesVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(userCasePay: UserCasePay){
        itemView.findViewById<TextView>(R.id.donationCaseName_tv).text = userCasePay.name
        itemView.findViewById<TextView>(R.id.totalCost_tv).text = userCasePay.total_required
        itemView.findViewById<TextView>(R.id.remainCost_tv).text =
            (userCasePay.total_required.toDouble() - (userCasePay.total_collected)).toString()

        itemView.findViewById<ProgressBar>(R.id.caseDonation_progress).progress =
            (userCasePay.total_collected.div(userCasePay.total_required.toDouble()) / 100).roundToInt()

        itemView.findViewById<TextView>(R.id.results_percent).text =
            ("${userCasePay.total_collected.div(userCasePay.total_required.toDouble()) / 100} %" )
    }
}

