package com.muhammad.green.views.landing.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhammad.green.R
import com.muhammad.green.views.landing.response.Article
import com.muhammad.green.views.landing.response.Slider

class OnBoardingFragment : Fragment() {
    private var position = 0

    private lateinit var articles: ArrayList<Article>
    private lateinit var images: ArrayList<Slider>

/*    @StringRes
    private val PAGE_TEXT =
        intArrayOf(R.string.intro_text_1, R.string.intro_text_2, R.string.intro_text_3)

    @StringRes
    private val PAGE_IMAGE =
        intArrayOf(R.drawable.landing1, R.drawable.landing1, R.drawable.landing1)*/

    companion object {
        private const val ARG_POSITION = "slider-position"
        private const val ARG_ARTICLES = "articles"
        private const val ARG_IMAGES = "images"

        fun newInstance(position: Int,
                        articles: ArrayList<Article>,
                        images: ArrayList<Slider> ): OnBoardingFragment {
            val fragment = OnBoardingFragment()
            val args = Bundle()
            args.putInt(ARG_POSITION, position)
            args.putSerializable(ARG_ARTICLES, articles)
            args.putSerializable(ARG_IMAGES, images)
            fragment.arguments = args

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            position = requireArguments().getInt(ARG_POSITION)
            articles = requireArguments().getSerializable(ARG_ARTICLES) as ArrayList<Article>
            images = requireArguments().getSerializable(ARG_IMAGES) as ArrayList<Slider>
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
        val introImg = view.findViewById<ImageView>(R.id.onbording_img)
        val title = view.findViewById<TextView>(R.id.onboarding_title_tv)
        val content = view.findViewById<TextView>(R.id.onboarding_content_tv)

        title.text = articles[position].title
        content.text = articles[position].content

        Glide.with(requireContext())
            .load(images[position].url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.landing1)
                    .error(R.drawable.landing1))
            .into(introImg)
//        introImg.setImageResource(PAGE_IMAGE[position])

    }


}