  package com.muhammad.green.registration

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.muhammad.green.R
import com.muhammad.green.databinding.RegisLoginFragmentBinding
import com.muhammad.green.home.MainActivity
import net.Aqua_waterfliter.joborder.utiles.startNewActivity

  class RegisLoginFragment : Fragment() {

    private lateinit var binding: RegisLoginFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = RegisLoginFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginBtn.setOnClickListener{
            requireActivity().startNewActivity(MainActivity::class.java)
        }

        binding.signInTv.setOnClickListener{
            findNavController().navigate(
                RegisLoginFragmentDirections.actionRegisLoginFragmentToRegisUserTypeFragment()
            )
        }
    }

}