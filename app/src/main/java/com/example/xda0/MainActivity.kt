package com.example.xda0

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import java.lang.reflect.Type

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var button1:Button//gamovidzaxet
    private lateinit var button2:Button
    private lateinit var button3:Button
    private lateinit var button4:Button
    private lateinit var button5:Button
    private lateinit var button6:Button
    private lateinit var button7:Button
    private lateinit var button8:Button
    private lateinit var button9:Button
    private lateinit var resetButton: Button

    private var pirveliMotamashe = ArrayList<Int>()//shemoviyvanet masivebi romelshic ganavecit generiki
    private var meoreMotamashe = ArrayList<Int>()//shemoviyvanet masivebi romelshic gadavecit generiki

    private var aqtiuriMotamashe = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        idfind()
        gauqmeba()
    }

    private fun idfind(){
        button1 = findViewById(R.id.button1)//daklikebbis funqcionali gavuweret
        button2 = findViewById(R.id.button2)//daklikebbis funqcionali gavuweret
        button3 = findViewById(R.id.button3)//daklikebbis funqcionali gavuweret
        button4 = findViewById(R.id.button4)//daklikebbis funqcionali gavuweret
        button5 = findViewById(R.id.button5)//daklikebbis funqcionali gavuweret
        button6 = findViewById(R.id.button6)//daklikebbis funqcionali gavuweret
        button7 = findViewById(R.id.button7)//daklikebbis funqcionali gavuweret
        button8 = findViewById(R.id.button8)//daklikebbis funqcionali gavuweret
        button9 = findViewById(R.id.button9)//daklikebbis funqcionali gavuweret
        resetButton = findViewById(R.id.resetButton)

        button1.setOnClickListener (this)
        button2.setOnClickListener (this)
        button3.setOnClickListener (this)
        button4.setOnClickListener (this)
        button5.setOnClickListener (this)
        button6.setOnClickListener (this)
        button7.setOnClickListener (this)
        button8.setOnClickListener (this)
        button9.setOnClickListener (this)


    }

    override fun onClick(v: View?) {
        if(v is Button){
            var buttonNumber = 0
            when (v.id){
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
            if(buttonNumber != 0){
                playGame(buttonNumber, v)
            }
        }

    }

    private fun playGame(buttonNumber: Int, v: Button) {
        if (aqtiuriMotamashe == 1) {
            //v.text = "X"
            v.setBackgroundResource(R.drawable.iqsi)
            pirveliMotamashe.add(buttonNumber)
            aqtiuriMotamashe = 2
        } else {
            //v.text = "0"
            v.setBackgroundResource(R.drawable.sircle)
            meoreMotamashe.add(buttonNumber)
            aqtiuriMotamashe = 1
        }
        v.isEnabled = false //ertxel rom daaklikeb gilaks meorejer rom ar moxdes masze xelis dachera magis realizxacia
        momgSvla()
    }

    private fun momgSvla() {
         var mogebuli = 0


        if(pirveliMotamashe.contains(1) && pirveliMotamashe.contains(2) && pirveliMotamashe.contains(3)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(1) && meoreMotamashe.contains(2) && meoreMotamashe.contains(3)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(4) && pirveliMotamashe.contains(5) && pirveliMotamashe.contains(6)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(4) && meoreMotamashe.contains(5) && meoreMotamashe.contains(6)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(7) && pirveliMotamashe.contains(8) && pirveliMotamashe.contains(9)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(7) && meoreMotamashe.contains(8) && meoreMotamashe.contains(9)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(1) && pirveliMotamashe.contains(4) && pirveliMotamashe.contains(7)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(1) && meoreMotamashe.contains(4) && meoreMotamashe.contains(7)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(2) && pirveliMotamashe.contains(5) && pirveliMotamashe.contains(8)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(2) && meoreMotamashe.contains(5) && meoreMotamashe.contains(8)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(3) && pirveliMotamashe.contains(6) && pirveliMotamashe.contains(9)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(3) && meoreMotamashe.contains(6) && meoreMotamashe.contains(9)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(1) && pirveliMotamashe.contains(5) && pirveliMotamashe.contains(9)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(1) && meoreMotamashe.contains(5) && meoreMotamashe.contains(9)) {
            mogebuli = 2
        }

        if(pirveliMotamashe.contains(3) && pirveliMotamashe.contains(5) && pirveliMotamashe.contains(7)) {
            mogebuli = 1
        }
        if(meoreMotamashe.contains(3) && meoreMotamashe.contains(5) && meoreMotamashe.contains(7)) {
            mogebuli = 2
        }
        if (mogebuli != 0) {
            if(mogebuli == 1){
                Toast.makeText(this, "X Wins! Congratulations!", Toast.LENGTH_LONG).show()
                xSound()
            } else {
                Toast.makeText(this, "0 Wins! Congratulations!", Toast.LENGTH_LONG).show()
                zSound()
            }
            gatishva()
        }



    }
    private fun gatishva(){
        button1.isEnabled = false
        button2.isEnabled = false
        button3.isEnabled = false
        button4.isEnabled = false
        button5.isEnabled = false
        button6.isEnabled = false
        button7.isEnabled = false
        button8.isEnabled = false
        button9.isEnabled = false
    }
    fun gauqmeba() {
        resetButton.setOnClickListener {
            button1.setBackgroundResource(android.R.drawable.btn_default)//aq wavshalet poto
            button2.setBackgroundResource(android.R.drawable.btn_default)
            button3.setBackgroundResource(android.R.drawable.btn_default)
            button4.setBackgroundResource(android.R.drawable.btn_default)
            button5.setBackgroundResource(android.R.drawable.btn_default)
            button6.setBackgroundResource(android.R.drawable.btn_default)
            button7.setBackgroundResource(android.R.drawable.btn_default)
            button8.setBackgroundResource(android.R.drawable.btn_default)
            button9.setBackgroundResource(android.R.drawable.btn_default)
            button1.text = ""//gavauqmet teqsti
            button2.text = ""
            button3.text = ""
            button4.text = ""
            button5.text = ""
            button6.text = ""
            button7.text = ""
            button8.text = ""
            button9.text = ""
            button1.isEnabled = true//dachera chavrtet
            button2.isEnabled = true
            button3.isEnabled = true
            button4.isEnabled = true
            button5.isEnabled = true
            button6.isEnabled = true
            button7.isEnabled = true
            button8.isEnabled = true
            button9.isEnabled = true
            pirveliMotamashe.clear()//gavasuftavet masivi
            meoreMotamashe.clear()//gavasuftavet masivi
            aqtiuriMotamashe = 1

        }

    }
    fun xSound (){
        val xSsound = MediaPlayer.create(this, R.raw.xmagaimarjva)
        xSsound.start()
    }
    fun zSound (){
        val zSsound = MediaPlayer.create(this, R.raw.zeromagaimarjva)
        zSsound.start()
    }


}