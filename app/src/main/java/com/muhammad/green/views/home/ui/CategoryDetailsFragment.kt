package com.muhammad.green.views.home.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.content.res.AppCompatResources.getColorStateList
import androidx.core.view.children
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.chip.Chip
import com.muhammad.green.R
import com.muhammad.green.data.PreferenceHelper
import com.muhammad.green.data.network.CategoryAPi
import com.muhammad.green.data.network.RemoteDataSource
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.databinding.FragmentDetailsBinding
import com.muhammad.green.views.ViewModelFactory
import com.muhammad.green.views.home.adapters.TypeDetailsAdapter
import com.muhammad.green.views.home.repository.CategoryRepository
import com.muhammad.green.views.home.response.CategoryData
import com.muhammad.green.views.home.viewModels.CategoryViewModel
import kotlinx.coroutines.flow.collect
import net.Aqua_waterfliter.joborder.utiles.visible


class CategoryDetailsFragment : Fragment() {

    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: CategoryViewModel
    private lateinit var adapter: TypeDetailsAdapter
    private lateinit var pref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = PreferenceHelper.customPrefs(requireContext(), "green")

        setUpViewModel()

        val args = CategoryDetailsFragmentArgs.fromBundle(requireArguments())
        val categoryId = args.categoryId
        viewModel.getSubCategories(categoryId)
        observeData()

        /*val list = mutableListOf("قلب مفتوح", "عيون", "عمليات اطفال")
        setTag(list)*/

        val manager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
        binding.detailsDonationCasesRv.layoutManager = manager

        adapter = TypeDetailsAdapter(arrayListOf()){
            Toast.makeText(requireContext(), "clicked", Toast.LENGTH_SHORT).show()

            findNavController().navigate(
                CategoryDetailsFragmentDirections.actionDetailsFragmentToCaseDetailsFragment(it.id)
            )
        }

        binding.detailsDonationCasesRv.adapter = adapter

//        binding.detailsCasesCategoriesChipGroup

        binding.detailsCasesCategoriesChipGroup.setOnCheckedChangeListener { chipGroup, id ->
            Log.d(TAG, "id: $id")
            viewModel.getSubCategoryCases(id)
        }
    }

    private fun setTag(tagList: MutableList<CategoryData>) {
        for (index in tagList.indices) {
            val chip = Chip(binding.detailsCasesCategoriesChipGroup.context)
            chip.text= "${tagList[index]}"
            chip.id = tagList[index].id
            Log.d(TAG, "setTag: ${tagList[index].name}")
            chip.chipBackgroundColor = getColorStateList(requireContext(), R.color.white)
            // necessary to get single selection working
            chip.isClickable = true
            chip.isCheckable = true
            if (tagList[0] != null && index == 0){
                chip.isChecked = true
                Log.d(TAG, "id: ${tagList[0].id}")
            }
            binding.detailsCasesCategoriesChipGroup.addView(chip)
        }
    }

    private fun setUpViewModel() {
        //        val token = pref["token"]
        val token = ""
//        val token = "QeNqvDYdMOCN2ZkXeZzSfXf441cbnckkjfM5P3rV5axP66MqkB5YRekLLjle"
        val remoteDataSource = RemoteDataSource.buildApi(CategoryAPi::class.java, token)
        val repository = CategoryRepository(remoteDataSource)
        val factory = ViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(CategoryViewModel::class.java)
    }


    private fun observeData() {
        lifecycleScope.launchWhenCreated {
            viewModel.subCategories.collect {
                binding.loadingProgress.visible(false)
                when (it) {
                    is ResultWrapper.Loading -> {
                        binding.loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgress.visible(false)
                        setTag(it.value.data)
                        Log.d("observeData", "data: ${it.value.data}")
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgress.visible(false)
                    }
                }
            }
        }

        lifecycleScope.launchWhenCreated {
            viewModel.subCategoryCases.collect {
                binding.loadingProgress.visible(false)
                when (it) {
                    is ResultWrapper.Loading -> {
                        binding.loadingProgress.visible(true)
                    }
                    is ResultWrapper.Success -> {
                        binding.loadingProgress.visible(false)
                        adapter.addData(it.value.data)
                        Log.d("observeData", "cases: ${it.value.data}")
                    }
                    is ResultWrapper.GenericError -> {
                        binding.loadingProgress.visible(false)
                    }
                }
            }
        }

    }

    companion object {
        private const val TAG = "CategoryDetailsFragment"
    }

}