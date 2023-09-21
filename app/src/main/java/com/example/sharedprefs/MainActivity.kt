package com.example.sharedprefs

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import com.example.sharedprefs.UserVipAplication.Companion.prefs

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()
        checkUserValues()
    }

    private fun checkUserValues() {
        if (prefs.getName().isNotEmpty()){
            // ir a la siguiente pantalla
            goToDetail()
        }
        else{
            // otra cosa
        }
    }

    private fun initUI(){

        // traer al boton con el nombre de btContinue
        val btContinue = findViewById<Button>(R.id.btContinue)

        btContinue.setOnClickListener{
            accesToDetail()
        }
    }

    private fun accesToDetail() {
        //comprobar si esta el nombre o no

        val etName = findViewById<EditText>(R.id.etName)
        val cbVip = findViewById<CheckBox>(R.id.cbVip)

        if (etName.text.toString().isNotEmpty()){
            // guardamos el valor del usuario
            prefs.saveName(etName.text.toString())

            // guardamos el valor del vip
            prefs.saveVip(cbVip.isChecked)

            // ir a la siguiente pantalla
            goToDetail()
        }
        else{
            // otra cosa
        }
    }

    private fun goToDetail(){
        startActivity(Intent(this, ResultActivity::class.java))
    }
}