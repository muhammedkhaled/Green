package com.muhammad.green.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class VolInKindDonationsFragmentDirections private constructor() {
  public companion object {
    public fun actionVolInKindDonationsFragmentToDonateDeviceFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_volInKindDonationsFragment_to_donateDeviceFragment)
  }
}
