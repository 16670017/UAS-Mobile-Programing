package com.pijey.informatikaupgris

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.pijey.informatikaupgris.ui.activity.DataActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        btnInfo.setOnClickListener{
            val intent = Intent(this,InfoActivity::class.java)
            startActivity(intent)
        }
        btnKuliah.setOnClickListener{
            val intent = Intent(this, DataActivity::class.java)
            startActivity(intent)
        }
    }
}

