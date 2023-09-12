package com.example.notesbypronin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddNote: Button
    private val listFragment = ListFragment()
    private val fullScreenFragment = FullScreenFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonAddNote = findViewById(R.id.buttonAddNote)

        // Проверяю что другого экземпляра нет, для того что бы не пересоздавался при повороте.
        if (savedInstanceState == null) {
            // Создаю экземпляр фрагмента FullScreenFragment
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentOnActivity, listFragment)
                .commit()
        }
    }

    fun onClickButtonAddNote(view: View) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainStage, fullScreenFragment)
            .addToBackStack("")
            .commit()
    }
}