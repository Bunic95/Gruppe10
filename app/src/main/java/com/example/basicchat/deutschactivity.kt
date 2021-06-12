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

class deutschactivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.deutschscreen)
        QiSDK.register(this, this)

        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home4)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }


        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_deutsch)
        backButton.setOnClickListener {
            val intent = Intent(this, RezeptActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
        }
        val but_klopse: Button = findViewById(R.id.but_klopse) //Button wird als variable deklariert
        but_klopse.setOnClickListener {
           // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToKlopse()
            //thread {  }
        }
        val but_eintopf: Button = findViewById(R.id.but_eintopf) //Button wird als variable deklariert
        but_eintopf.setOnClickListener {
            // fchat.requestCancellation() //ACHTUNG DIES NOCH EINÜGEN WENN CHAT EINGEFÜGT IST
            goToEintopf()
            //thread {  }
        }
    }

        override fun onRobotFocusGained(qiContext: QiContext?) {
            //Roboter etwas sagen lassen am Anfang
            val say = SayBuilder.with(qiContext)
                .withText("Hier kannst du zwischen Königsberger Klopsen und einem Erbseneintopf wählen. Klicke dazu auf das Rezept deiner Wahl, oder Navigiere weiter zurück!") //Text den Pepper beim start sagt.
                .build()
            say.run() //Say function ausführen
        }

        override fun onRobotFocusLost() {
            TODO("Not yet implemented")
        }

        override fun onRobotFocusRefused(reason: String?) {
            TODO("Not yet implemented")
        }
    private fun goToKlopse() {
        val changeToKlopse = Intent(this, KlopseActivity::class.java)
        startActivity(changeToKlopse)
    }
    private fun goToEintopf() {
        val changeToEintopf = Intent(this, EintopfActivity::class.java)
        startActivity(changeToEintopf)
    }

    }
