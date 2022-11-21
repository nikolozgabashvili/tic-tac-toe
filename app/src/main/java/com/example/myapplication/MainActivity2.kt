package com.example.myapplication

import android.app.job.JobInfo.TriggerContentUri
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity(), OnClickListener {
    private lateinit var score1: TextView
    private lateinit var score2: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    private lateinit var button9: Button
    private lateinit var turnsText: ImageView
    private lateinit var resetButton: Button
    private var activePlayer = 1
    private var firstPlayer = ArrayList<Int>()
    private var secondPlayer = ArrayList<Int>()
    private var pl1 = ""
    private var pl2 = ""
    private var sc1 = 0
    private var sc2 = 0
    private var a = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var playername1 = findViewById<TextView>(R.id.player1)
        var playername2 = findViewById<TextView>(R.id.player2)
        score1 = findViewById(R.id.score1)
        score2 = findViewById(R.id.score2)

        var intent = getIntent()
        var name = intent.getStringExtra("player1")
        var name2 = intent.getStringExtra("player2")
        playername1.text = name
        playername2.text = name2
        pl1 = name.toString()
        pl2 = name2.toString()
        resetButton = findViewById(R.id.resetButton)
        resetButton.isEnabled = false
        turnsText = findViewById(R.id.imageView1)
        turnsText.setImageResource(R.drawable.image_removebg_preview__3_)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        button1.setBackgroundColor(Color.rgb(160, 32, 240))
        button2.setBackgroundColor(Color.rgb(160, 32, 240))
        button3.setBackgroundColor(Color.rgb(160, 32, 240))
        button4.setBackgroundColor(Color.rgb(160, 32, 240))
        button5.setBackgroundColor(Color.rgb(160, 32, 240))
        button6.setBackgroundColor(Color.rgb(160, 32, 240))
        button7.setBackgroundColor(Color.rgb(160, 32, 240))
        button8.setBackgroundColor(Color.rgb(160, 32, 240))
        button9.setBackgroundColor(Color.rgb(160, 32, 240))
        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)
        resetButton.setBackgroundColor(Color.rgb(160, 32, 240))
        resetButton.setOnClickListener {
            resetButton.isEnabled = false
            button1.isEnabled = true
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            button1.text = ""
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            if (activePlayer ==1){
                turnsText.setImageResource(R.drawable.image_removebg_preview__3_)
            }else{
                turnsText.setImageResource(R.drawable.image_removebg_preview__4_)
            }
            button1.setBackgroundColor(Color.rgb(160, 32, 240))
            button2.setBackgroundColor(Color.rgb(160, 32, 240))
            button3.setBackgroundColor(Color.rgb(160, 32, 240))
            button4.setBackgroundColor(Color.rgb(160, 32, 240))
            button5.setBackgroundColor(Color.rgb(160, 32, 240))
            button6.setBackgroundColor(Color.rgb(160, 32, 240))
            button7.setBackgroundColor(Color.rgb(160, 32, 240))
            button8.setBackgroundColor(Color.rgb(160, 32, 240))
            button9.setBackgroundColor(Color.rgb(160, 32, 240))
        }
    }

    override fun onClick(clickedViev: View?) {
        if (clickedViev is Button) {
            var buttonNumber = 0
            when (clickedViev.id) {

                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }
            a = activePlayer


            playGame(buttonNumber, clickedViev)
        }


    }

    private fun playGame(buttonNumber: Int, clickedViev: Button) {
        if (activePlayer == 1) {
            clickedViev.text = "X"
            clickedViev.setBackgroundColor(Color.RED)
            activePlayer = 2
            turnsText.setImageResource(R.drawable.image_removebg_preview__4_)
            firstPlayer.add(buttonNumber)

        } else if (activePlayer == 2) {
            clickedViev.text = "0"
            clickedViev.setBackgroundColor(Color.CYAN)
            activePlayer = 1
            turnsText.setImageResource(R.drawable.image_removebg_preview__3_)
            secondPlayer.add(buttonNumber)
        }
        clickedViev.isEnabled = false

        check()

    }

    private fun check() {
        var winner = 0

        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)) {
            winner = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)) {
            winner = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)) {
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)) {
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)) {
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)) {
            winner = 2
        }
        if (firstPlayer.contains(5) && firstPlayer.contains(2) && firstPlayer.contains(8)) {
            winner = 1
        }
        if (secondPlayer.contains(5) && secondPlayer.contains(2) && secondPlayer.contains(8)) {
            winner = 2
        }
        if (firstPlayer.contains(9) && firstPlayer.contains(6) && firstPlayer.contains(3)) {
            winner = 1
        }
        if (secondPlayer.contains(9) && secondPlayer.contains(6) && secondPlayer.contains(3)) {
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(5) && firstPlayer.contains(3)) {
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(5) && secondPlayer.contains(3)) {
            winner = 2
        }
        if (winner == 1) {
            sc1 += 1
            activePlayer = 1

            Toast.makeText(this, "$pl1 won", Toast.LENGTH_SHORT).show()

        } else if (winner == 2) {
            activePlayer = 2
            sc2 += 1
            Toast.makeText(this, "$pl2 won", Toast.LENGTH_SHORT).show()

        } else if (firstPlayer.size + secondPlayer.size == 9) {
            Toast.makeText(this, "tie", Toast.LENGTH_SHORT).show()
            activePlayer = a
            resetButton.isEnabled = true
            firstPlayer.clear()
            secondPlayer.clear()
        }
        if (winner != 0) {
            button1.isEnabled = false
            button2.isEnabled = false
            button3.isEnabled = false
            button4.isEnabled = false
            button5.isEnabled = false
            button6.isEnabled = false
            button7.isEnabled = false
            button8.isEnabled = false
            button9.isEnabled = false
            score1.text = sc1.toString()
            score2.text = sc2.toString()
            firstPlayer.clear()
            secondPlayer.clear()
            resetButton.isEnabled = true
        }

    }

}