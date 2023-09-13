package com.example.notesbypronin

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var buttonAddNote: Button
    private lateinit var buttonSave: Button
    private lateinit var buttonDelete: Button
    private lateinit var fullFragment: FrameLayout
    private lateinit var dateText: TextView
    private lateinit var noteHeader: EditText
    private lateinit var noteText: EditText

    private val listFragment = ListFragment()
    private val fullScreenFragment = FullScreenFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonAddNote = findViewById(R.id.buttonAddNote)
        fullFragment = findViewById(R.id.fullFragment)

        // Проверяю что другого экземпляра нет, для того что бы не пересоздавался при повороте.
        if (savedInstanceState == null) {
            // Создаю экземпляры обоих фрагментов
            supportFragmentManager.beginTransaction()
                .replace(R.id.fullFragment, fullScreenFragment)
                .commit()

            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentList, listFragment)
                .commit()
        }
    }

    override fun onResume() {
        super.onResume()
        buttonSave = findViewById(R.id.buttonSave)
        buttonDelete = findViewById(R.id.buttonDelete)
        dateText = findViewById(R.id.dateText)
        noteHeader = findViewById(R.id.noteHeader)
        noteText = findViewById(R.id.noteText)
    }

    fun onClickAddNoteButton(view: View) {
            showFullFragment()
    }

    fun onClickSaveButton(view: View) {
        //TO DO
    }

    fun onClickDeleteButton(view: View) {
        //TO DO
    }

    private fun isPositionLand(): Boolean {
        return resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE
    }

    fun showFullFragment() {
        dateText.text = Note.currentDateTime()
        fullFragment.visibility = View.VISIBLE
    }

    override fun onBackPressed() {
        if (!isPositionLand() && fullFragment.visibility == View.VISIBLE) {
            fullFragment.visibility = View.GONE
        } else if (isPositionLand() && fullFragment.visibility == View.VISIBLE) {
            fullFragment.visibility = View.GONE
        } else {
            super.onBackPressed()
        }
    }

}