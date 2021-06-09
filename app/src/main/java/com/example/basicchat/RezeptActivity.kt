package com.example.basicchat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import com.aldebaran.qi.Future
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.`object`.conversation.BookmarkStatus
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

    private var deutschBookmarkStatus: BookmarkStatus? = null

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
        val but_deutsch: Button = findViewById(R.id.but_deutsch) //Button wird als variable deklariert
        but_deutsch.setOnClickListener {
            fchat.requestCancellation()
            goToDeutsch()
            //thread {  }
        }
        val but_tuerkisch: Button = findViewById(R.id.but_tuerkisch) //Button wird als variable deklariert
        but_tuerkisch.setOnClickListener {
            fchat.requestCancellation()
            goToTurkisch()
            //thread {  }
        }
        val but_italienisch: Button = findViewById(R.id.but_italienisch) //Button wird als variable deklariert
        but_italienisch.setOnClickListener {
            fchat.requestCancellation()
            goToItaly()
            //thread {  }
        }
        val but_griechisch: Button = findViewById(R.id.but_griechisch) //Button wird als variable deklariert
        but_griechisch.setOnClickListener {
            fchat.requestCancellation()
            goToGriechisch()
            //thread {  }
        }
        //Button zurück zur Vorrigen Activity
        val backButton = findViewById<Button>(R.id.but_back_rezept)
        backButton.setOnClickListener {
            val intent = Intent (this, DecisionActivity::class.java)
            startActivity(intent)
        }
        // Sprachaufruf zu anderer Aktivität
        //val deutschBookmark: Bookmark? = topic.bookmarks["deutschactivity"]
        //deutschBookmarkStatus = qiChatbot.bookmarkStatus(deutschBookmark)
        //deutschBookmarkStatus?.addOnReachedListener {
        //    val intent = Intent (this, deutschactivity::class.java)
        //   startActivity(intent)
        //}
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
}