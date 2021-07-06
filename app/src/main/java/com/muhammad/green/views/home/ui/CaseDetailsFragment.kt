package com.muhammad.green.views.home.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.muhammad.green.R
import com.muhammad.green.data.network.CaseDetailsApi
import com.muhammad.green.data.network.CategoryAPi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentCaseDetailsBinding
import com.muhammad.green.databinding.FragmentDetailsBinding
import com.muhammad.green.views.ViewModelFactory
import com.muhammad.green.views.home.adapters.TypeDetailsAdapter
import com.muhammad.green.views.home.repository.CaseDetailsRepo
import com.muhammad.green.views.home.repository.CategoryRepository
import com.muhammad.green.views.home.response.CaseFullData
import com.muhammad.green.views.home.viewModels.CaseDetailsViewModel
import com.muhammad.green.views.home.viewModels.CategoryViewModel
import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.visible

class CaseDetailsFragment : BaseFragment<FragmentCaseDetailsBinding>() {

    private lateinit var viewModel: CaseDetailsViewModel
    private lateinit var pref: SharedPreferences

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentCaseDetailsBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = CaseDetailsFragmentArgs.fromBundle(requireArguments())
        val caseID = args.caseID
        setUpViewModel()
        viewModel.getCaseInfo(caseID)
        observeData()

        binding.caseReportsBtn.setOnClickListener {
            findNavController().navigate(
                CaseDetailsFragmentDirections.actionCaseDetailsFragmentToCaseReportsFragment()
            )
        }
    }

    private fun setUpViewModel() {
        //        val token = pref["token"]
        val token = ""
//        val token = "QeNqvDYdMOCN2ZkXeZzSfXf441cbnckkjfM5P3rV5axP66MqkB5YRekLLjle"
        val remoteDataSource = RemoteDataSource.buildApi(CaseDetailsApi::class.java, token)
        val repository = CaseDetailsRepo(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(CaseDetailsViewModel::class.java)
    }


    private fun observeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.caseInfo.collect {
                binding.loadingProgress.visible(false)
                when (it) {
                    is ResultWrapper.Loading -> {
                        binding.loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgress.visible(false)
                        bindData(it.value)
                        Log.d("observeData", "data: ${it.value}")
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgress.visible(false)
                    }
                }
            }
        }
    }

    private fun bindData(caseFullData: CaseFullData){
        binding.caseDetailsNameTv.text = caseFullData.user.name
//        binding.caseDetailsInfoTv.text = caseFullData.user.
        binding.caseDetailsRemainedTv.text = caseFullData.remain.toString()
        binding.caseDetailsTotalAmountTv.text = caseFullData.total.toString()
        binding.caseDetailsPayedTv.text = (caseFullData.total - caseFullData.remain).toString()


        Glide.with(requireContext())
            .load(caseFullData.user.photo.url)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.landing1)
                    .error(R.drawable.landing1))
            .into(binding.casePImgShapeableImg)
    }

}