package com.muhammad.green

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class PageFragment : Fragment() {
    private var lblPage: TextView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_page, container, false)
        lblPage = view.findViewById<View>(R.id.lbl_page) as TextView
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val page = requireArguments().getInt("page", 0)
        if (requireArguments().containsKey("isLast")) lblPage!!.text = "You're done!" else lblPage!!.text =
            page.toString()
    }

    companion object {
        fun newInstance(page: Int, isLast: Boolean): PageFragment {
            val args = Bundle()
            args.putInt("page", page)
            if (isLast) args.putBoolean("isLast", true)
            val fragment = PageFragment()
            fragment.arguments = args
            return fragment
        }
    }
}