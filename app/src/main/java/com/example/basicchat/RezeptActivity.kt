package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import com.aldebaran.qi.Future
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.ChatBuilder
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder
import com.aldebaran.qi.sdk.builder.TopicBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class RezeptActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rezeptscreen)
        QiSDK.register(this, this)
    }
    //Verknüpfungen zu Buttons erstellen. Aktivitäten für jeweiliges Land erstellen und verknüpfen.
    override fun onRobotFocusGained(qiContext: QiContext?) {
        //Festlegen der Sprache des Roboters//
        val locale = com.aldebaran.qi.sdk.`object`.locale.Locale(Language.GERMAN, Region.GERMANY)
        //Einbinden der zuvor erstellen Topic "smalltalk1.top"
        val topic = TopicBuilder.with(qiContext).withResource(R.raw.rezepttalk)
            .build() //erstellen der variable "topic" + bilden der topic
        //Erstellen eines qiChatbots mittels Chatbotbilder und unter Einbeziehung der Spracheinstellungen
        val qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).withLocale(locale).build()
        //Chat erstellen
        val chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).withLocale(locale).build()
        val fchat: Future<Void> = chat.async().run()

        //Ab hier einbinden der Buttons

        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home12)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }

        val but_deutsch: Button =
            findViewById(R.id.but_deutsch) //Button wird als variable deklariert
        but_deutsch.setOnClickListener {
            fchat.requestCancellation()
            goToDeutsch()
            //thread {  }
        }
        val but_tuerkisch: Button =
            findViewById(R.id.but_tuerkisch) //Button wird als variable deklariert
        but_tuerkisch.setOnClickListener {
            fchat.requestCancellation()
            goToTurkisch()
            //thread {  }
        }
        val but_italienisch: Button =
            findViewById(R.id.but_italienisch) //Button wird als variable deklariert
        but_italienisch.setOnClickListener {
            fchat.requestCancellation()
            goToItaly()
            //thread {  }
        }
        val but_griechisch: Button =
            findViewById(R.id.but_griechisch) //Button wird als variable deklariert
        but_griechisch.setOnClickListener {
            fchat.requestCancellation()
            goToGriechisch()
            //thread {  }
        }
        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_rezept)
        backButton.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
        }
        //Random Button der zufälliges Layout aufruft
        val rollButton: Button = findViewById(R.id.but_zufall)
        rollButton.setOnClickListener {
            rollRandomRezept()
        }
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }

    private fun goToDeutsch() {
        val changeToDeutsch = Intent(this, deutschactivity::class.java)
        startActivity(changeToDeutsch)
    }

    private fun goToTurkisch() {
        val changeToTurkisch = Intent(this, turkischactivity::class.java)
        startActivity(changeToTurkisch)
    }

    private fun goToItaly() {
        val changeToItaly = Intent(this, Italyactivity::class.java)
        startActivity(changeToItaly)
    }

    private fun goToGriechisch() {
        val changeToGriechisch = Intent(this, griechischactivity::class.java)
        startActivity(changeToGriechisch)
    }

    //Random Rezepte anzeigen lassen wenn Zufallsbutton betätift wird
    private fun goToBaklava() {
        val changeToBaklava = Intent(this, BaklavaActivity::class.java)
        startActivity(changeToBaklava)
    }

    private fun goToCalamari() {
        val changeToCalamari = Intent(this, CalamariActivity::class.java)
        startActivity(changeToCalamari)
    }

    private fun goToEintopf() {
        val changeToEintopf = Intent(this, EintopfActivity::class.java)
        startActivity(changeToEintopf)
    }

    private fun goToGyros() {
        val changeToGyros = Intent(this, GyrosActivity::class.java)
        startActivity(changeToGyros)
    }

    private fun goToKlopse() {
        val changeToKlopse = Intent(this, KlopseActivity::class.java)
        startActivity(changeToKlopse)
    }

    private fun goToPide() {
        val changeToPide = Intent(this, PideActivity::class.java)
        startActivity(changeToPide)
    }

    private fun goToRisotto() {
        val changeToRisotto = Intent(this, RisottoActivity::class.java)
        startActivity(changeToRisotto)
    }

    private fun goToSalat() {
        val changeToSalat = Intent(this, SalatActivity::class.java)
        startActivity(changeToSalat)
    }

    private fun rollRandomRezept() {
        val random = Random(8)
        val randomroll = random.roll()

        when (randomroll) {
            1 -> goToBaklava()
            2 -> goToCalamari()
            3 -> goToEintopf()
            4 -> goToGyros()
            5 -> goToKlopse()
            6 -> goToPide()
            7 -> goToRisotto()
            8 -> goToSalat()
        }
    }

    class Random(private val numRezept: Int) {

        fun roll(): Int {
            return (1..numRezept).random()
        }
    }
}