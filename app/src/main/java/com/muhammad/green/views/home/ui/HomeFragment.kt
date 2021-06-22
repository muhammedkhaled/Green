package com.muhammad.green.views.home.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.muhammad.green.R
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.PreferenceHelper.get
import com.muhammad.green.data.PreferenceHelper.set
import com.muhammad.green.data.network.HomeApi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentHomeBinding
import com.muhammad.green.views.home.adapters.CasesTypeAdapter
import com.muhammad.green.views.home.adapters.homeDonaCasesAdapter
import com.muhammad.green.utiles.CenterZoomLinearLayoutManager
import com.muhammad.green.views.home.repository.HomeRepository
import com.muhammad.green.views.home.response.UserCasePay
import com.muhammad.green.views.home.viewModels.HomeViewModel
import com.muhammad.green.views.registration.viewModels.ViewModelFactory
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.base.BaseFragment
import net.Aqua_waterfliter.joborder.utiles.visible
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private lateinit var pref: SharedPreferences
    private lateinit var viewModel: HomeViewModel
    private lateinit var casesAdapter: homeDonaCasesAdapter
    private lateinit var categoryAdapter: CasesTypeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        pref = PreferenceHelper.customPrefs(requireContext(), "green")
        setUpViewModel()
        observeData()
        setTodayDate()

        binding.inKindDonationBtn.setOnClickListener{
            findNavController().navigate(
                HomeFragmentDirections.actionNavigationHomeToVolInKindDonationsFragment()
            )
        }

        val manager1 = LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false)
        binding.casesOfDonationsRv.layoutManager = manager1

        casesAdapter = homeDonaCasesAdapter(arrayListOf()){
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToCaseDetailsFragment())
        }
        binding.casesOfDonationsRv.adapter = casesAdapter

        val center = CenterZoomLinearLayoutManager(requireContext())
//        val snapHelper: SnapHelper = LinearSnapHelper()
//        snapHelper.attachToRecyclerView(binding.casesTypeRv)
        binding.categoriesRv.layoutManager = center

        categoryAdapter = CasesTypeAdapter(arrayListOf()){
            findNavController().navigate(HomeFragmentDirections.actionNavigationHomeToDetailsFragment())
        }
        binding.categoriesRv.adapter = categoryAdapter
    }

    private fun setTodayDate() {
        val currentDate = SimpleDateFormat("dd MMMM yyyy ", Locale.US).format(Date())
        binding.todayDateTv.text = "Today, $currentDate"
    }

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentHomeBinding.inflate(inflater, container, false)

    override fun onPrepareOptionsMenu(menu: Menu) {
        menu.findItem(R.id.share).isVisible = true
        super.onPrepareOptionsMenu(menu)
    }

    private fun setUpViewModel() {
//        val token = pref["token"]
        val token = ""
//        val token = "QeNqvDYdMOCN2ZkXeZzSfXf441cbnckkjfM5P3rV5axP66MqkB5YRekLLjle"
//        Log.d("HomeFragment", "onViewCreated: ${token}")

        val remoteDataSource = RemoteDataSource.buildApi(HomeApi::class.java, token)
        val repository = HomeRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(HomeViewModel::class.java)

        if (token.isNullOrEmpty()) {
            viewModel.getVisitorData()
            Log.d("HomeFragment", "getData: visitor")
        } else {
            viewModel.getMyCases()
            viewModel.getVisitorData()
            Log.d("HomeFragment", "getData: my cases")
        }
    }


    private fun observeData(){
        lifecycleScope.launchWhenCreated {
            viewModel.profile.collect {
                binding.loadingProgressCases.visible(false)
                when(it){
                    is ResultWrapper.Loading -> {
                        binding.loadingProgressCases.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        casesAdapter.addData(it.value.user_case_pay)
                        binding.loadingProgressCases.visible(false)
                        val user = Gson().toJson(it.value.user)
                        // todo make static keywords for all pref
                        pref["user_profile"] = user
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgressCases.visible(false)
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.visitorData.collect {
                binding.loadingProgressCases.visible(false)
                when(it){
                    is ResultWrapper.Loading -> {
                        Log.d("HomeFragment", "Loading")
                        binding.loadingProgressCases.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgressCases.visible(false)
                        Log.d("HomeFragment", "observeData: cases ${it.value}")
                        casesAdapter.addData(it.value.cases)
                        categoryAdapter.addData(it.value.categories)
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgressCases.visible(false)
                        Log.d("HomeFragment", "error ${it.error}")
                    }
                }
            }
        }
    }
}