package com.debz.zoroexe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.debz.zoroexe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnOrder.setOnClickListener(){
            val checkedRadioButtonID = binding.rgMeat.checkedRadioButtonId
            val meat= findViewById<RadioButton>(checkedRadioButtonID)
            val mayo= binding.cbMayo.isChecked
            val cheddar= binding.cbCheddar.isChecked
            val onions=binding.cbOnions.isChecked
            val checkedPaymentID= binding.rgPayment.checkedRadioButtonId
            val payment= findViewById<RadioButton>(checkedPaymentID)

            val orderString= "You ordered a ${meat.text} burger\n"+
                    "With topping of:"+
                    (if(mayo) "\n Mayonnaise" else "") +
                    (if(cheddar) "\n Cheddar" else "") +
                    (if(onions) "\n Onions" else "") +
                    "\n\nYou preferred payment method is : ${payment.text}"
            binding.tvOrder.text=orderString
        }
    }
}