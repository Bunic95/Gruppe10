package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.builder.SayBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class turkischactivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.turkischscreen)
        QiSDK.register(this, this)

        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home15)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }

        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_turk)
        backButton.setOnClickListener {
            val intent = Intent(this, RezeptActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
        }
        val but_pide: Button = findViewById(R.id.but_pide) //Button wird als variable deklariert
        but_pide.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToPide()
            //thread {  }
        }
        val but_baklava: Button = findViewById(R.id.but_baklava) //Button wird als variable deklariert
        but_baklava.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToBaklava()
            //thread {  }
        }
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        //Roboter etwas sagen lassen am Anfang
        val say = SayBuilder.with(qiContext)
            .withText("Hier kannst du zwischen Pide und Baklava wählen. Klicke dazu auf das Rezept deiner Wahl, oder Navigiere weiter zurück!") //Text den Pepper beim start sagt.
            .build()
        say.run() //Say function ausführen

    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
    private fun goToPide() {
        val changeToPide = Intent(this, PideActivity::class.java)
        startActivity(changeToPide)
    }
    private fun goToBaklava() {
        val changeToBaklava = Intent(this, BaklavaActivity::class.java)
        startActivity(changeToBaklava)
    }
}
