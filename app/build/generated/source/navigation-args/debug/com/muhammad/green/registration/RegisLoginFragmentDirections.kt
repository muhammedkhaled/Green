package com.muhammad.green.registration

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class RegisLoginFragmentDirections private constructor() {
  public companion object {
    public fun actionRegisLoginFragmentToRegisUserTypeFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_regisLoginFragment_to_regisUserTypeFragment)
  }
}
