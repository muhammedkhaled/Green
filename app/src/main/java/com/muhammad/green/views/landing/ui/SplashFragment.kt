package com.muhammad.green.views.landing.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.muhammad.green.R

class SplashFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val isFirstTime = true
        // wait 1 seconds to show text with app name
        /*Handler().postDelayed({
            //                setAnimations();
        }, 750)

        // wait 3 seconds to do this
        Handler().postDelayed({
            if (isFirstTime) {
                // show on boarding Screens
                (requireActivity() as LandingActivity).hideStarterFragment()
            } else {
                // go to mainActivity
                *//*startActivity(new Intent((LandingActivity)getActivity(), LoginActivity.class));
                        getActivity().finish();*//*
            }
        }, 2000)*/

        (requireActivity() as LandingActivity).hideStarterFragment()
    } //    private void setAnimations() {
    //        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fad_in_splash);
    //        binding.splashAppName.setVisibility(View.VISIBLE);
    //        binding.splashAppName.setAnimation(animation);
    //
    //    }
}