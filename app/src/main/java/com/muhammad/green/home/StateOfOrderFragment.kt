package com.muhammad.green.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.muhammad.green.PagerAdapter
import com.muhammad.green.R
import com.muhammad.green.StepperIndicator

class StateOfOrderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state_of_order, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val pager: ViewPager = view.findViewById(R.id.pager)
        pager.adapter = PagerAdapter(parentFragmentManager)

        val indicator: StepperIndicator = view.findViewById(R.id.stepper_indicator)
        // We keep last page for a "finishing" page
        // We keep last page for a "finishing" page
        indicator.setViewPager(pager, true)

        indicator.addOnStepClickListener {
                step -> pager.setCurrentItem(step, true) }
    }

}