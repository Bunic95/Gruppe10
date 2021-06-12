package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.Future
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.`object`.conversation.QiChatExecutor
import com.aldebaran.qi.sdk.`object`.locale.Language
import com.aldebaran.qi.sdk.`object`.locale.Region
import com.aldebaran.qi.sdk.builder.ChatBuilder
import com.aldebaran.qi.sdk.builder.QiChatbotBuilder
import com.aldebaran.qi.sdk.builder.TopicBuilder
import com.aldebaran.qi.sdk.design.activity.RobotActivity

// Unter aktivität wird erstellt und layout gewechselt. Buttons werden aktiviert und funktion hinterlegt.
class DecisionActivity : RobotActivity(), RobotLifecycleCallbacks {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QiSDK.register(this, this)
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        //Festlegen der Sprache des Roboters//
        val locale = com.aldebaran.qi.sdk.`object`.locale.Locale(Language.GERMAN, Region.GERMANY)
        //Einbinden der zuvor erstellen Topic "smalltalk1.top"
        val topic = TopicBuilder.with(qiContext).withResource(R.raw.smalltalk1)
            .build() //erstellen der variable "topic" + bilden der topic
        //Erstellen eines qiChatbots mittels Chatbotbilder und unter Einbeziehung der Spracheinstellungen
        val qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).withLocale(locale).build()
        //Chat erstellen
        val chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).withLocale(locale).build()
        val executors = hashMapOf( // erstellen der variable executors um Animation einzubinden in chattopic
            "nicereaction" to NiceExecutor(qiContext) //, komma muss hin wenn man mehrere Animationen einbinden will
        )
        qiChatbot.executors = executors as Map<String, QiChatExecutor>?
        // Ausführen des Chats
        val fchat: Future<Void> = chat.async().run() // future void wird benötigt um den Chat abbrechbar zu machen
        //Ab hier einbinden der Buttons
        val but_organizer: Button = findViewById(R.id.but_organizer) //Button wird als variable deklariert
        but_organizer.setOnClickListener {
            //Hier den chat smalltalk nach Button betätigung beenden und danach mit thread in nächsten chat wechseln
            fchat.requestCancellation() //Hiermit wird durch betätigung des Buttons der chat smalltalk1 beendet
            goToOrganizer()
            //thread // Hiermit kann man Pepperinterne Funktionen direkt aufrufen
        } //hier {....} kann funktion aufgerufen werden (bspw. ein chat) innerhalb der geschweiften Klammer (Hier evtl. nächste chat topic einbauen (Witze/Zungenbrecher/Fußballfakten)
        val but_wetter: Button = findViewById(R.id.but_wetter) //Button wird als variable deklariert
        but_wetter.setOnClickListener {
            fchat.requestCancellation()
            goToWetter()
            //thread {  }
        }
        val but_rezepte: Button = findViewById(R.id.but_rezepte) //Button but_rezepte wird als variable deklariert
        but_rezepte.setOnClickListener {
            fchat.requestCancellation()
            goToRezept()
            }
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
    private fun goToRezept() {
        val changeToRezept = Intent(this, RezeptActivity::class.java)
        startActivity(changeToRezept)
        }
    private fun goToOrganizer() {
        val changeToOrganizer = Intent(this, OrganizerActivity::class.java)
        startActivity(changeToOrganizer)
    }
    private fun goToWetter() {
        val changeToWetter = Intent(this, WetterActivity::class.java)
        startActivity(changeToWetter)
    }
}
