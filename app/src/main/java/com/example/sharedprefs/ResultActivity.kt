package com.example.sharedprefs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.sharedprefs.UserVipAplication.Companion.prefs

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        initUI()
    }

    private fun initUI() {
        val btSignOut = findViewById<Button>(R.id.btSignOut)
        val tvName = findViewById<TextView>(R.id.tvName)

        btSignOut.setOnClickListener{
            prefs.wipe()
            // ir a la pantalla de inicio
            onBackPressed()
        }

        val userName = prefs.getName()
        tvName.text = "Welcome $userName"

        if (prefs.getVip()){
            // mostrar el boton de vip
            setVipColorBackground()
        }
    }


    private fun setVipColorBackground() {
        // cambiar el color de fondo del boton de vip
        val clContainer = findViewById<androidx.constraintlayout.widget.ConstraintLayout>(R.id.clContainer)
        clContainer.setBackgroundResource(R.color.primary)
    }
}