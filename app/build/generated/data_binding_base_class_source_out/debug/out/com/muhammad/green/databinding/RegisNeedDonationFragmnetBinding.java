// Generated by view binder compiler. Do not edit!
package com.muhammad.green.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;
import com.muhammad.green.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class RegisNeedDonationFragmnetBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CheckBox conditionsCheckbox;

  @NonNull
  public final TextView forgotpassTv;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final Guideline guideline2;

  @NonNull
  public final Guideline guideline3;

  @NonNull
  public final ImageView imageView4;

  @NonNull
  public final ImageView imageView5;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final AutoCompleteTextView regisVolCityActv;

  @NonNull
  public final TextInputLayout regisVolCityTil;

  @NonNull
  public final AutoCompleteTextView regisVolGovActv;

  @NonNull
  public final TextInputLayout regisVolGovTil;

  @NonNull
  public final MaterialButton regisVolLocationBtn;

  @NonNull
  public final EditText regisVolNameEt;

  @NonNull
  public final TextInputLayout regisVolNameTil;

  @NonNull
  public final MaterialButton regisVolNextBtn;

  @NonNull
  public final EditText regisVolPassEt;

  @NonNull
  public final TextInputLayout regisVolPassTil;

  @NonNull
  public final EditText regisVolPhoneEt;

  @NonNull
  public final TextInputLayout regisVolPhoneTil;

  @NonNull
  public final TextView regisVolTitleTv;

  private RegisNeedDonationFragmnetBinding(@NonNull ConstraintLayout rootView,
      @NonNull CheckBox conditionsCheckbox, @NonNull TextView forgotpassTv,
      @NonNull Guideline guideline1, @NonNull Guideline guideline2, @NonNull Guideline guideline3,
      @NonNull ImageView imageView4, @NonNull ImageView imageView5,
      @NonNull ProgressBar progressbar, @NonNull AutoCompleteTextView regisVolCityActv,
      @NonNull TextInputLayout regisVolCityTil, @NonNull AutoCompleteTextView regisVolGovActv,
      @NonNull TextInputLayout regisVolGovTil, @NonNull MaterialButton regisVolLocationBtn,
      @NonNull EditText regisVolNameEt, @NonNull TextInputLayout regisVolNameTil,
      @NonNull MaterialButton regisVolNextBtn, @NonNull EditText regisVolPassEt,
      @NonNull TextInputLayout regisVolPassTil, @NonNull EditText regisVolPhoneEt,
      @NonNull TextInputLayout regisVolPhoneTil, @NonNull TextView regisVolTitleTv) {
    this.rootView = rootView;
    this.conditionsCheckbox = conditionsCheckbox;
    this.forgotpassTv = forgotpassTv;
    this.guideline1 = guideline1;
    this.guideline2 = guideline2;
    this.guideline3 = guideline3;
    this.imageView4 = imageView4;
    this.imageView5 = imageView5;
    this.progressbar = progressbar;
    this.regisVolCityActv = regisVolCityActv;
    this.regisVolCityTil = regisVolCityTil;
    this.regisVolGovActv = regisVolGovActv;
    this.regisVolGovTil = regisVolGovTil;
    this.regisVolLocationBtn = regisVolLocationBtn;
    this.regisVolNameEt = regisVolNameEt;
    this.regisVolNameTil = regisVolNameTil;
    this.regisVolNextBtn = regisVolNextBtn;
    this.regisVolPassEt = regisVolPassEt;
    this.regisVolPassTil = regisVolPassTil;
    this.regisVolPhoneEt = regisVolPhoneEt;
    this.regisVolPhoneTil = regisVolPhoneTil;
    this.regisVolTitleTv = regisVolTitleTv;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static RegisNeedDonationFragmnetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static RegisNeedDonationFragmnetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.regis_need_donation_fragmnet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static RegisNeedDonationFragmnetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.conditions_checkbox;
      CheckBox conditionsCheckbox = rootView.findViewById(id);
      if (conditionsCheckbox == null) {
        break missingId;
      }

      id = R.id.forgotpass_tv;
      TextView forgotpassTv = rootView.findViewById(id);
      if (forgotpassTv == null) {
        break missingId;
      }

      id = R.id.guideline1;
      Guideline guideline1 = rootView.findViewById(id);
      if (guideline1 == null) {
        break missingId;
      }

      id = R.id.guideline2;
      Guideline guideline2 = rootView.findViewById(id);
      if (guideline2 == null) {
        break missingId;
      }

      id = R.id.guideline3;
      Guideline guideline3 = rootView.findViewById(id);
      if (guideline3 == null) {
        break missingId;
      }

      id = R.id.imageView4;
      ImageView imageView4 = rootView.findViewById(id);
      if (imageView4 == null) {
        break missingId;
      }

      id = R.id.imageView5;
      ImageView imageView5 = rootView.findViewById(id);
      if (imageView5 == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = rootView.findViewById(id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.regisVolCity_actv;
      AutoCompleteTextView regisVolCityActv = rootView.findViewById(id);
      if (regisVolCityActv == null) {
        break missingId;
      }

      id = R.id.regisVolCity_til;
      TextInputLayout regisVolCityTil = rootView.findViewById(id);
      if (regisVolCityTil == null) {
        break missingId;
      }

      id = R.id.regisVolGov_actv;
      AutoCompleteTextView regisVolGovActv = rootView.findViewById(id);
      if (regisVolGovActv == null) {
        break missingId;
      }

      id = R.id.regisVolGov_til;
      TextInputLayout regisVolGovTil = rootView.findViewById(id);
      if (regisVolGovTil == null) {
        break missingId;
      }

      id = R.id.regisVolLocation_btn;
      MaterialButton regisVolLocationBtn = rootView.findViewById(id);
      if (regisVolLocationBtn == null) {
        break missingId;
      }

      id = R.id.regisVolName_et;
      EditText regisVolNameEt = rootView.findViewById(id);
      if (regisVolNameEt == null) {
        break missingId;
      }

      id = R.id.regisVolName_til;
      TextInputLayout regisVolNameTil = rootView.findViewById(id);
      if (regisVolNameTil == null) {
        break missingId;
      }

      id = R.id.regisVolNext_btn;
      MaterialButton regisVolNextBtn = rootView.findViewById(id);
      if (regisVolNextBtn == null) {
        break missingId;
      }

      id = R.id.regisVolPass_et;
      EditText regisVolPassEt = rootView.findViewById(id);
      if (regisVolPassEt == null) {
        break missingId;
      }

      id = R.id.regisVolPass_til;
      TextInputLayout regisVolPassTil = rootView.findViewById(id);
      if (regisVolPassTil == null) {
        break missingId;
      }

      id = R.id.regisVolPhone_et;
      EditText regisVolPhoneEt = rootView.findViewById(id);
      if (regisVolPhoneEt == null) {
        break missingId;
      }

      id = R.id.regisVolPhone_til;
      TextInputLayout regisVolPhoneTil = rootView.findViewById(id);
      if (regisVolPhoneTil == null) {
        break missingId;
      }

      id = R.id.regisVolTitle_tv;
      TextView regisVolTitleTv = rootView.findViewById(id);
      if (regisVolTitleTv == null) {
        break missingId;
      }

      return new RegisNeedDonationFragmnetBinding((ConstraintLayout) rootView, conditionsCheckbox,
          forgotpassTv, guideline1, guideline2, guideline3, imageView4, imageView5, progressbar,
          regisVolCityActv, regisVolCityTil, regisVolGovActv, regisVolGovTil, regisVolLocationBtn,
          regisVolNameEt, regisVolNameTil, regisVolNextBtn, regisVolPassEt, regisVolPassTil,
          regisVolPhoneEt, regisVolPhoneTil, regisVolTitleTv);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
