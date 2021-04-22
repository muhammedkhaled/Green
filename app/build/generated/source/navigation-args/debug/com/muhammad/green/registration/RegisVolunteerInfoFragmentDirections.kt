package com.muhammad.green.registration

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class RegisVolunteerInfoFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisVolunteerInfoFragmnetToVerificationCodeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_regisVolunteerInfoFragmnet_to_verificationCodeFragment)
  }
}
