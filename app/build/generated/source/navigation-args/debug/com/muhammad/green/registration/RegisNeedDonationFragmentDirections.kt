package com.muhammad.green.registration

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class RegisNeedDonationFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisNeedDonationFragmentToVerificationCodeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_regisNeedDonationFragment_to_verificationCodeFragment)
  }
}
