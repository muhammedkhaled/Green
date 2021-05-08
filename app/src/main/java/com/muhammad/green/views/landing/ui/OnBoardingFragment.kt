package com.muhammad.green.views.landing.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.muhammad.green.R

class OnBoardingFragment : Fragment() {
    private var position = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            position = requireArguments().getInt(ARG_POSITION)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_boarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
/*        val introImg = view.findViewById<ImageView>(R.id.intro_img)
        val title = view.findViewById<TextView>(R.id.intro_headline)
        val text = view.findViewById<TextView>(R.id.intro_text)
        title.setText(R.string.app_name)
        text.setText(PAGE_TEXT[position])
        introImg.setImageResource(PAGE_IMAGE[position])*/
    }

    companion object {
        private const val ARG_POSITION = "slider-position"

        @StringRes
        private val PAGE_TEXT =
            intArrayOf(R.string.intro_text_1, R.string.intro_text_2, R.string.intro_text_3)

        @StringRes
        private val PAGE_IMAGE =
            intArrayOf(R.drawable.landing1, R.drawable.landing1, R.drawable.landing1)

        fun newInstance(position: Int): OnBoardingFragment {
            val fragment = OnBoardingFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            fragment.arguments = args
            return fragment
        }
    }
}