package com.example.textinputlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val clickMeButton = findViewById<TextView>(R.id.clickButton)
        val userNameTextInputView = findViewById<TextInputLayout>(R.id.userNameTextView)
        val displayClickCountView = findViewById<TextView>(R.id.textView)
        val myMap = mutableMapOf<String, Int>()


        clickMeButton.setOnClickListener{
            clickCount++

            val userName = userNameTextInputView.editText?.text?.toString()
            val markedUserName =
                if(userName.isNullOrEmpty()) "Somebody"
                else userName

            if(markedUserName in myMap)
            {
                clickCount = myMap[markedUserName.toString()]!!+1
                myMap[markedUserName.toString()] = clickCount
            }
            else
            {
                myMap.put(markedUserName.toString(), 1)
            }

            displayClickCountView.text = "$markedUserName Clicked ${myMap[markedUserName]} times"
        }
    }
}