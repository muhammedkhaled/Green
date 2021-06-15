package com.muhammad.green.views.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.google.android.material.imageview.ShapeableImageView
import com.muhammad.green.R
import com.muhammad.green.views.home.response.Category
import com.muhammad.green.views.home.response.VisitorHomeData

class CasesTypeAdapter(private var list: ArrayList<Category>, private val listener: (Category) -> Unit)
    : RecyclerView.Adapter<CasesTypeVH>(){

    fun addData(visitorData: ArrayList<Category>){
        list.addAll(visitorData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CasesTypeVH(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.home_cases_type_item, parent, false))

    override fun onBindViewHolder(holder: CasesTypeVH, position: Int) {
        holder.itemView.setOnClickListener{
            listener(list[position])
        }

        holder.bind(list[position])
    }

    override fun getItemCount() = list.size
}


class CasesTypeVH(itemView: View) : RecyclerView.ViewHolder(itemView){

    fun bind(category: Category){
        itemView.findViewById<TextView>(R.id.title_text).text = category.name
        val image = itemView.findViewById<ShapeableImageView>(R.id.casesType_shapeableimg)

        Glide.with(itemView.context)
            .load(category.photo.url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.landing1)
                    .error(R.drawable.landing1))
            .into(image)

    }
}

