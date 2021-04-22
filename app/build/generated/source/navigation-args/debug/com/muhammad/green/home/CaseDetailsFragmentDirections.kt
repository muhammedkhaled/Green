package com.muhammad.green.home

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.muhammad.green.R

public class CaseDetailsFragmentDirections private constructor() {
  public companion object {
    public fun actionCaseDetailsFragmentToCaseReportsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_caseDetailsFragment_to_caseReportsFragment)
  }
}
