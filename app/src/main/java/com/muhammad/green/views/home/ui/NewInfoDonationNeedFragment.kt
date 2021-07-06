package com.muhammad.green.views.home.ui

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.muhammad.green.databinding.FragmentNewInfoDonationNeedBinding
import net.Aqua_waterfliter.joborder.base.BaseFragment

class NewInfoDonationNeedFragment : BaseFragment<FragmentNewInfoDonationNeedBinding>() {

    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ) = FragmentNewInfoDonationNeedBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendBtn.setOnClickListener {

        }

/*        val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult())
        { result: ActivityResult ->
            if (result.resultCode == Activity.RESULT_OK) {
                //  you will get result here in result.data
            }

        }          startForResult.launch(chooser)*/

/*
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT;
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.type = "application/pdf";
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);

        val chooser = Intent.createChooser(intent, "Select Your .pdf File")
*/

        val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            // Handle the returned Uri
            Log.d(TAG, "uri: $uri")

        }

        binding.nwAccNdDonAttachmentBtn.setOnClickListener(){

            getContent.launch("application/pdf")
        }




    }

    companion object {
        private const val TAG = "NewInfoDonationNeedFrag"
    }


}