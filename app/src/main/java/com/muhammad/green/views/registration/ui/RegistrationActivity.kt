package com.muhammad.green.views.registration.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.muhammad.green.R
import net.Aqua_waterfliter.joborder.utiles.changeLayoutDirection
import net.Aqua_waterfliter.joborder.utiles.disableDayNight

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        changeLayoutDirection(true)
        disableDayNight()
    }
}