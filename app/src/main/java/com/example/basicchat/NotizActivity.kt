package com.example.basicchat

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.aldebaran.qi.sdk.QiContext
import com.aldebaran.qi.sdk.QiSDK
import com.aldebaran.qi.sdk.RobotLifecycleCallbacks
import com.aldebaran.qi.sdk.design.activity.RobotActivity

class NotizActivity : RobotActivity(), RobotLifecycleCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.notizscreen)
        QiSDK.register(this, this)

        loadData1()
        loadData2()
        loadData3()
        loadData4()

        val but_notizen1: Button =
            findViewById(R.id.but_speichern1) //Button wird als variable deklariert
        but_notizen1.setOnClickListener {
            saveData()
        }
    }

    override fun onRobotFocusGained(qiContext: QiContext?) {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusLost() {
        TODO("Not yet implemented")
    }

    override fun onRobotFocusRefused(reason: String?) {
        TODO("Not yet implemented")
    }
//Save data einzeln setzen (saveData1,saveData2 ...) damit bei betätigung des Speichern buttons nicht alles überschreiben wird
    private fun saveData() {
        val not_1: EditText = findViewById(R.id.not_1)
        val textnot1: TextView = findViewById(R.id.textnot1)
        val insertedText1: String = not_1.text.toString()
        textnot1.text = insertedText1

        val not_2: EditText = findViewById(R.id.not_2)
        val textnot2: TextView = findViewById(R.id.textnot2)
        val insertedText2: String = not_2.text.toString()
        textnot2.text = insertedText2

        val not_3: EditText = findViewById(R.id.not_3)
        val textnot3: TextView = findViewById(R.id.textnot3)
        val insertedText3: String = not_3.text.toString()
        textnot3.text = insertedText3

        val not_4: EditText = findViewById(R.id.not_4)
        val textnot4: TextView = findViewById(R.id.textnot4)
        val insertedText4: String = not_4.text.toString()
        textnot4.text = insertedText4

        val sharedPreferences: SharedPreferences =
            getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.apply {
            putString("STRING_KEY1", insertedText1)
            putString("STRING_KEY2", insertedText2)
            putString("STRING_KEY3", insertedText3)
            putString("STRING_KEY4", insertedText4)
        }.apply()

        Toast.makeText(this, "Notiz gespeichert", Toast.LENGTH_SHORT).show()
    }

    private fun loadData1() {
        val textnot1: TextView = findViewById(R.id.textnot1)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY1", null)
        textnot1.text = savedString
    }

    private fun loadData2() {
        val textnot2: TextView = findViewById(R.id.textnot2)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY2", null)
        textnot2.text = savedString
    }

    private fun loadData3() {
        val textnot3: TextView = findViewById(R.id.textnot3)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY3", null)
        textnot3.text = savedString
    }

    private fun loadData4() {
        val textnot4: TextView = findViewById(R.id.textnot4)
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        val savedString = sharedPreferences.getString("STRING_KEY4", null)
        textnot4.text = savedString
    }
}