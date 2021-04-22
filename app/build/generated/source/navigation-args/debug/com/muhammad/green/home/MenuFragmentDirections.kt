package com.muhammad.green.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class MenuFragmentDirections private constructor() {
  public companion object {
    public fun actionNavigationMenuToMyNeedsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_menu_to_myNeedsFragment)

    public fun actionNavigationMenuToNewInfoDonationNeedFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_menu_to_newInfoDonationNeedFragment)

    public fun actionNavigationMenuToAboutUsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_menu_to_aboutUsFragment)

    public fun actionNavigationMenuToAdministrationWordFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_menu_to_administrationWordFragment)

    public fun actionNavigationMenuToEditeMyInfoFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_navigation_menu_to_editeMyInfoFragment)
  }
}
