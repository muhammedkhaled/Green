package com.muhammad.green.home

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.fragment.app.Fragment
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.muhammad.green.R
import com.muhammad.green.databinding.FragmentDetailsBinding


class DetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // todo this list will get it from backend
        val list = mutableListOf("قلب مفتوح", "عيون", "عمليات اطفال")
        setTag(list);
    }

    private fun setTag(tagList: MutableList<String>) {
        for (index in tagList.indices) {
            val chip = Chip(binding.detailsCasesCategoriesChipGroup.context)
            chip.text= "${tagList[index]}"
            chip.chipBackgroundColor = getColorStateList(requireContext(), R.color.white)
            // necessary to get single selection working
            chip.isClickable = true
            chip.isCheckable = true
            binding.detailsCasesCategoriesChipGroup.addView(chip)
        }
    }

}