package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        var player1 = findViewById<EditText>(R.id.pl1)
        var player2 = findViewById<EditText>(R.id.pl2)

        var button = findViewById<Button>(R.id.button)


        button.setOnClickListener {
            var intent = Intent(this,MainActivity2::class.java)
            if(player1.text.toString().length==0){
                player1.setText("player1")
            }
            if (player2.text.toString().length==0){
                player2.setText("player2")
            }
            intent.putExtra("player1",player1.text.toString())
            intent.putExtra("player2",player2.text.toString())
            startActivity(intent)
            player1.setText("")
            player2.setText("")



        }
    }



}