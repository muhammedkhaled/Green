package com.muhammad.green.views.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.muhammad.green.R


class CaseReportsFragment : Fragment() {

    // todo make grid list for report pictures and on click open gallary view with zoom in and out

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_case_reports, container, false)
    }

}