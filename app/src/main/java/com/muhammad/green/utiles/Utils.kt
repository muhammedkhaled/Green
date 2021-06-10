package net.Aqua_waterfliter.joborder.utiles

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.muhammad.green.data.network.ResultWrapper
import com.muhammad.green.views.registration.ui.RegisLoginFragment
import com.muhammad.green.views.registration.ui.RegisNeedDonationFragment
import com.muhammad.green.views.registration.ui.RegisVolunteerInfoFragment
import java.util.*

fun <A : Activity> Activity.startNewActivity(activity: Class<A>) {
    Intent(this, activity).also {
        it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(it)
    }
}

fun View.visible(isVisible: Boolean) {
    visibility = if (isVisible) View.VISIBLE else View.GONE
}

fun View.enable(enabled: Boolean) {
    isEnabled = enabled
    alpha = if (enabled) 1f else 0.5f
}

fun View.snackbar(message: String, action: (() -> Unit)? = null) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_LONG)
    action?.let {
        snackbar.setAction("Retry") {
            it()
        }
    }
    snackbar.show()
}


fun Fragment.handleApiError(
    failure: ResultWrapper.GenericError,
    retry: (() -> Unit)? = null
) {
    when {
        failure.isNetworkError == true -> requireView().snackbar(
            "Please check your internet connection",
            retry
        )
        failure.errorCode == 500 -> {
            when {
                this is RegisLoginFragment -> {
                    requireView().snackbar(failure.error.toString())
                }
                this is RegisNeedDonationFragment -> {
                    requireView().snackbar(failure.error.toString())

                }
                this is RegisVolunteerInfoFragment ->{
                    requireView().snackbar(failure.error.toString())
                }
                else -> {
//                (this as BaseFragment<*>).logout()
                }
            }
        }
        else -> {
            val error = failure.error?.toString()
            if (error != null) {
                requireView().snackbar(error)
            }
        }
    }
}


fun Activity.changeLayoutDirection(isRTL: Boolean) {
    // set local to ar to change app direction to rtl and language to ar
    val locale = if (isRTL) Locale("ar") else Locale("en")
    Locale.setDefault(locale)
    val config =
        baseContext.resources.configuration
    config.setLocale(locale)
    createConfigurationContext(config)
}

fun Activity.disableDayNight(){
    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
}