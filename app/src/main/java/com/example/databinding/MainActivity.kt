package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //lateinit = late initialise
    private lateinit var binding: ActivityMainBinding

    //create an instance of the Contact class
    private var myContact: Contact = Contact("The piggy will oink","0123456789")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //To see the UI
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.contact = myContact
         binding.buttonDone.setOnClickListener(){
             updateName()
         }
    }

    fun updateName(){
        //apply = doing multiple setting on a single object
        //? = nullable


        binding.apply {
            contact?.name = editTextName.text.toString()
            contact?.phone = editTextPhoneNo.text.toString()
            this.invalidateAll()
        }
    }
}
