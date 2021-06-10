package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
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

private const val TAG = "MainActivity" //Wird verwendet um wieder in Main activity zu springen?

class MainActivity : RobotActivity(), RobotLifecycleCallbacks { // robotactivity ist eine activity und muss im Manifest verankert sein und benötigt Klammern ()
    override fun onCreate(savedInstanceState: Bundle?) { //OnCreate ist eine von Android benötigte function um bspw. das Layout aufzurufen.
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speechscreen) // setContentView zeigt das layout "speechscreen)
        QiSDK.register(this, this)
    }

    override fun onRobotFocusGained(qiContext: QiContext) {
        //Roboter etwas sagen lassen am Anfang
        val say = SayBuilder.with(qiContext)
                .withText("Mein Name ist Pepper. Begrüße mich um eine Konversation zu starten") //Text den Pepper beim start sagt.
                .build()
        say.run() //Say function ausführen
    //Festlegen der Sprache des Roboters
        val locale = com.aldebaran.qi.sdk.`object`.locale.Locale(Language.GERMAN, Region.GERMANY)
    //Einbinden der zuvor erstellen Topic "startchat.top.top"
        val topic = TopicBuilder.with(qiContext).withResource(R.raw.startchat).build() //erstellen der variable "topic" + bilden der topic
    //Erstellen eines qiChatbots mittels Chatbotbilder und unter Einbeziehung der Spracheinstellungen
        val qiChatbot = QiChatbotBuilder.with(qiContext).withTopic(topic).withLocale(locale).build()
        qiChatbot.variable("speech").addOnValueChangedListener {
            runOnUiThread { // speech um das was Pepper sagt auf display anzeigen zu lassen auf layout "speechscreen.xml"
                val tabletlabel = findViewById<TextView>(R.id.tabletlabel)
                tabletlabel.text = it
            }
        }
        val executors = hashMapOf( // erstellen der variable executors um Animation einzubinden in chattopic
                "raiseLeftHand" to HelloHumanExecutor(qiContext) //, komma muss hin wenn man mehrere Animationen einbinden will
        )
        qiChatbot.executors = executors as Map<String, QiChatExecutor>?
//Chat erstellen
        val chat = ChatBuilder.with(qiContext).withChatbot(qiChatbot).withLocale(locale).build()
// Ausführen des Chats
        val fchat: Future<Void> = chat.async().run() // future void wird benötigt um den Chat abbrechbar zu machen

        // Chat stoppen wenn qichatbot fertig ist. Hier kann dann in andere topic gesprungen werden. Im chat bei ^endDiscuss
        qiChatbot.addOnEndedListener { endReason ->
            Log.i(TAG, "qichatbot end reason = $endReason")
            fchat.requestCancellation()
            goToDecision() //Hier wird in andere Activity gewechselt
        }
    }
//Activity "DecisionActivity" wird gestartet und somit wird layout "activity_main" aktiviert (Kann hier platziert werden oder iwo ganz unten)
    private fun goToDecision() {
        val changeToDecision = Intent(this, DecisionActivity::class.java)
        startActivity(changeToDecision)
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }

    override fun onDestroy() {
        super.onDestroy()
        QiSDK.unregister(this, this)
    }
}