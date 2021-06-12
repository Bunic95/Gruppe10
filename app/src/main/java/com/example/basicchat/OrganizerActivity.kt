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
import com.aldebaran.qi.sdk.`object`.conversation.QiChatExecutor
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.ChatBuilder
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder
import com.aldebaran.qi.sdk.builder.SayBuilder
import com.aldebaran.qi.sdk.builder.TopicBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class OrganizerActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.organizerscreen)
        QiSDK.register(this, this)
    }
    override fun onRobotFocusGained(qiContext: QiContext?) {
        //Roboter etwas sagen lassen am Anfang
        val say = SayBuilder.with(qiContext)
            .withText("Du befindest dich nun im Organizer. Wähle eine der Funktionen per Knopfdruck oder Frage mich nach einer der Möglichkeiten die unten links auf meinem Bildschirm zu sehen sind!") //Text den Pepper beim start sagt.
            .build()
        say.run() //Say function ausführen
        //Festlegen der Sprache des Roboters//
        val locale = com.aldebaran.qi.sdk.`object`.locale.Locale(Language.GERMAN, Region.GERMANY)
        //Einbinden der zuvor erstellen Topic "smalltalk1.top"
        val topic = TopicBuilder.with(qiContext).withResource(R.raw.organizertalk)
            .build() //erstellen der variable "topic" + bilden der topic
        //Erstellen eines qiChatbots mittels Chatbotbilder und unter Einbeziehung der Spracheinstellungen
        val qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).withLocale(locale).build()
        //Executors für Animationen einbinden
        val executors = hashMapOf(
            "thinkingreaction" to ThinkExecutor(qiContext),
            "discoreaction" to DiscoExecutor(qiContext),
            "dancereaction" to DanceExecutor(qiContext)//, komma muss hin wenn man mehrere Animationen einbinden will
        )
        qiChatbot.executors = executors as Map<String, QiChatExecutor>?
        //Chat erstellen
        val chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).withLocale(locale).build()
        // Ausführen des Chats
        val fchat: Future<Void> = chat.async().run() // future void wird benötigt um den Chat abbrechbar zu machen
        //Ab hier einbinden der Buttons
        val but_notizen1: Button =
            findViewById(R.id.but_notizen1) //Button wird als variable deklariert
        but_notizen1.setOnClickListener {
            //Hier den chat smalltalk nach Button betätigung beenden und danach mit thread in nächsten chat wechseln
            fchat.requestCancellation() //Hiermit wird durch betätigung des Buttons der chat smalltalk1 beendet
            goToNotizen()
            //thread // Hiermit kann man Pepper interne Funktionen direkt aufrufen
        }
        //Button zurück in den Homescreen
        val but_home = findViewById<ImageButton>(R.id.but_home10)
        but_home.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück zum Anfang", Toast.LENGTH_SHORT).show()
        }
        val but_wecker1: Button =
            findViewById(R.id.but_wecker1) //Button wird als variable deklariert
        but_wecker1.setOnClickListener {
            fchat.requestCancellation()
            goToWecker()
        }
        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_organizer)
        backButton.setOnClickListener {
            val intent = Intent(this, DecisionActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Zurück", Toast.LENGTH_SHORT).show()
        }
    }
    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
    private fun goToWecker() {
        val changeToWecker = Intent(this, WeckerActivity::class.java)
        startActivity(changeToWecker)
    }

    private fun goToNotizen() {
        val changeToNotizen = Intent(this, NotizActivity::class.java)
        startActivity(changeToNotizen)
    }
}