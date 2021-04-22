package com.muhammad.green.registration

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class RegisUserTypeFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisUserTypeFragmentToRegisNeedDonationFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_regisUserTypeFragment_to_regisNeedDonationFragment)

    public fun actionRegisUserTypeFragmentToRegisVolunteerInfoFragmnet(): NavDirections =
        ActionOnlyNavDirections(R.id.action_regisUserTypeFragment_to_regisVolunteerInfoFragmnet)
  }
}
