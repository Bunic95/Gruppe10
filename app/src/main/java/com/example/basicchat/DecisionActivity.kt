package com.example.basicchat

import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

// Unter aktivität wird erstellt und layout gewechselt. Buttons werden aktiviert und funktion hinterlegt.
class DecisionActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QiSDK.register(this, this)
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        val but_organizer: Button = findViewById(R.id.but_organizer)
        but_organizer.setOnClickListener {
            setContentView(R.layout.organizerscreen) // Hiermit wird durch betätigen des Buttons auf das layout "organizerscreen.xml" gewechselt
            //thread {  }
        } //hier {....} kann funktion aufgerufen werden (bspw. ein chat) innerhalb der geschweiften klammer (Hier evtl. nächste chat topic einbauen (Witze/Zungenbrecher/Fußballfakten)
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
}