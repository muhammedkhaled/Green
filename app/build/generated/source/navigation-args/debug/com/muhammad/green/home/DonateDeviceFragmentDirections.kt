package com.muhammad.green.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class DonateDeviceFragmentDirections private constructor() {
  public companion object {
    public fun actionDonateDeviceFragmentToStateOfOrderFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_donateDeviceFragment_to_stateOfOrderFragment)
  }
}
