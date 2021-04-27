package com.example.sharedprefs

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)


        var username: String? =  sharedPreference.getString("username","defaultName")
        var numero: Long = sharedPreference.getLong("l",1L)

        textView.text = username + " - " + numero
        Log.d("datos", username + " --  " + numero)

        btnSave.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.btnSave -> {
                val sharedPreference =  getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
                var editor = sharedPreference.edit()
                editor.putString("username", etName.text.toString())
                editor.putLong("l",etNumber.text.toString().toLong())
                editor.commit()
            }
        }
    }




}