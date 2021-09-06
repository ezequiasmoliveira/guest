package com.example.guest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.guest.R
import com.example.guest.viewmodel.GuestFromViewModel

class GuestFromActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFromViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_from)

        mViewModel = ViewModelProvider(this).get(GuestFromViewModel::class.java)

        setListeners()
    }

    private fun setListeners(){
        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {

        }
    }


}