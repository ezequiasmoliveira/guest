package com.example.guest.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.guest.R
import com.example.guest.constants.GuestConstants
import com.example.guest.viewmodel.GuestFromViewModel

class GuestFromActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mViewModel: GuestFromViewModel

    private lateinit var mButton: Button
    private lateinit var mEditName: EditText
    private lateinit var mRadioButtonPresence: RadioButton
    private lateinit var mRadioButtonAbsent: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guest_from)

        mViewModel = ViewModelProvider(this).get(GuestFromViewModel::class.java)

        mButton = findViewById(R.id.button_save)
        mEditName = findViewById(R.id.edit_name)
        mRadioButtonPresence = findViewById(R.id.radio_presence)
        mRadioButtonAbsent = findViewById(R.id.radio_absent)

        setListeners()
        observers()
        loadData()
    }


    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.button_save) {
            val name = mEditName.text.toString()
            val presence = mRadioButtonPresence.isChecked

            mViewModel.save(name, presence)
        }
    }

    private fun loadData() {
        val bundle = intent.extras
        if (bundle != null) {
            val id = bundle.getInt(GuestConstants.GUEST_ID)
            mViewModel.load(id)
        }
    }

    private fun setListeners(){
        val button = findViewById<Button>(R.id.button_save)
        button.setOnClickListener(this)
    }

    private fun observers() {
        mViewModel.saveGuest.observe(this, Observer {
            if (it) {
                Toast.makeText(applicationContext, "Cadastro criado com sucesso", Toast.LENGTH_SHORT)
            } else {
                Toast.makeText(applicationContext, "Erro ao criar o cadastro", Toast.LENGTH_SHORT)
            }
            finish()
        })

        mViewModel.guest.observe(this, Observer {
            mEditName.setText(it.name)
            if (it.presence) mRadioButtonPresence.isChecked = true else mRadioButtonAbsent.isChecked = true
        })
    }


}