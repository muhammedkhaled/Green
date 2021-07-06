package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.Case
import com.muhammad.green.views.home.response.Category
import de.hdodenhof.circleimageview.CircleImageView

class TypeDetailsAdapter(private var list: ArrayList<Case>, private val listener: (Case) -> Unit)
    : RecyclerView.Adapter<TypeDetailsVH>(){

    fun addData(cases: ArrayList<Case>){
        list = cases
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        TypeDetailsVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.donation_cases_item, parent, false))

    override fun onBindViewHolder(holder: TypeDetailsVH, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}


class TypeDetailsVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(case: Case){
        itemView.findViewById<TextView>(R.id.details_caseName_tv).text = case.name
        itemView.findViewById<TextView>(R.id.details_case_surgeryType_tv).text = case.sub_sub_category

        itemView.findViewById<CheckBox>(R.id.item_card_check_favorite).isChecked = case.favorite != 0
        // todo add on checked click listenr when check call api to add to favorate
        //  if ther is a token if the user is vistor show toast "you must register first" or navigat to register activity

        val image = itemView.findViewById<CircleImageView>(R.id.details_casePP_cImg)

        Glide.with(itemView.context)
            .load(case.photo)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.landing1)
                    .error(R.drawable.landing1))
            .into(image)
    }
}

