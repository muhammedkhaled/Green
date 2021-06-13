// Generated by view binder compiler. Do not edit!
package com.muhammad.green.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.imageview.ShapeableImageView;
import com.muhammad.green.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentAdministrationWordBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final TextView AdminInstructionsTitle;

  @NonNull
  public final TextView adminWordTv;

  @NonNull
  public final Guideline guidelineH1;

  @NonNull
  public final ProgressBar loadingProgress;

  @NonNull
  public final ShapeableImageView shapeableImageView;

  private FragmentAdministrationWordBinding(@NonNull ConstraintLayout rootView,
      @NonNull TextView AdminInstructionsTitle, @NonNull TextView adminWordTv,
      @NonNull Guideline guidelineH1, @NonNull ProgressBar loadingProgress,
      @NonNull ShapeableImageView shapeableImageView) {
    this.rootView = rootView;
    this.AdminInstructionsTitle = AdminInstructionsTitle;
    this.adminWordTv = adminWordTv;
    this.guidelineH1 = guidelineH1;
    this.loadingProgress = loadingProgress;
    this.shapeableImageView = shapeableImageView;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentAdministrationWordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentAdministrationWordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_administration_word, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentAdministrationWordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.AdminInstructions_title;
      TextView AdminInstructionsTitle = rootView.findViewById(id);
      if (AdminInstructionsTitle == null) {
        break missingId;
      }

      id = R.id.adminWord_tv;
      TextView adminWordTv = rootView.findViewById(id);
      if (adminWordTv == null) {
        break missingId;
      }

      id = R.id.guideline_h1;
      Guideline guidelineH1 = rootView.findViewById(id);
      if (guidelineH1 == null) {
        break missingId;
      }

      id = R.id.loadingProgress;
      ProgressBar loadingProgress = rootView.findViewById(id);
      if (loadingProgress == null) {
        break missingId;
      }

      id = R.id.shapeableImageView;
      ShapeableImageView shapeableImageView = rootView.findViewById(id);
      if (shapeableImageView == null) {
        break missingId;
      }

      return new FragmentAdministrationWordBinding((ConstraintLayout) rootView,
          AdminInstructionsTitle, adminWordTv, guidelineH1, loadingProgress, shapeableImageView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
