// Generated by view binder compiler. Do not edit!
package com.muhammad.green.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.muhammad.green.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentOnBoardingBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Guideline guideline1;

  @NonNull
  public final ImageView imageView;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final TextView onboardingContentTv;

  @NonNull
  public final TextView onboardingTitleTv;

  @NonNull
  public final ImageView onbordingImg;

  private FragmentOnBoardingBinding(@NonNull ConstraintLayout rootView,
      @NonNull Guideline guideline1, @NonNull ImageView imageView, @NonNull ImageView imageView2,
      @NonNull TextView onboardingContentTv, @NonNull TextView onboardingTitleTv,
      @NonNull ImageView onbordingImg) {
    this.rootView = rootView;
    this.guideline1 = guideline1;
    this.imageView = imageView;
    this.imageView2 = imageView2;
    this.onboardingContentTv = onboardingContentTv;
    this.onboardingTitleTv = onboardingTitleTv;
    this.onbordingImg = onbordingImg;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentOnBoardingBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentOnBoardingBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_on_boarding, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentOnBoardingBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.guideline1;
      Guideline guideline1 = rootView.findViewById(id);
      if (guideline1 == null) {
        break missingId;
      }

      id = R.id.imageView;
      ImageView imageView = rootView.findViewById(id);
      if (imageView == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = rootView.findViewById(id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.onboarding_content_tv;
      TextView onboardingContentTv = rootView.findViewById(id);
      if (onboardingContentTv == null) {
        break missingId;
      }

      id = R.id.onboarding_title_tv;
      TextView onboardingTitleTv = rootView.findViewById(id);
      if (onboardingTitleTv == null) {
        break missingId;
      }

      id = R.id.onbording_img;
      ImageView onbordingImg = rootView.findViewById(id);
      if (onbordingImg == null) {
        break missingId;
      }

      return new FragmentOnBoardingBinding((ConstraintLayout) rootView, guideline1, imageView,
          imageView2, onboardingContentTv, onboardingTitleTv, onbordingImg);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
