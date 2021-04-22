package com.muhammad.green.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class HomeFragmentDirections private constructor() {
  public companion object {
    public fun actionNavigationHomeToCaseDetailsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_caseDetailsFragment)

    public fun actionNavigationHomeToVolInKindDonationsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_volInKindDonationsFragment)

    public fun actionNavigationHomeToDetailsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_detailsFragment)

    public fun actionNavigationHomeToNeedInKindDonationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_home_to_needInKindDonationFragment)
  }
}
