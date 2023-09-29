package com.jhobert.notes

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jhobert.notes.Models.Note
import com.jhobert.notes.databinding.ActivityAddNotesBinding
import java.text.SimpleDateFormat
import java.util.Date

class AddNotes : AppCompatActivity() {

    private lateinit var binding: ActivityAddNotesBinding
    private lateinit var note: Note
    private lateinit var oldNote: Note
    var isUpdate = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNotesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        try{
            oldNote = intent.getSerializableExtra("current_note") as Note
            binding.etAddTitle.setText(oldNote.title)
            binding.etAddNotes.setText(oldNote.note)
            isUpdate = true
        }catch (e: Exception){
            e.printStackTrace()
        }
        binding.ivCheck.setOnClickListener{
            val title = binding.etAddTitle.text.toString()
            val noteDescription = binding.etAddNotes.text.toString()
            if(title.isNotEmpty() || noteDescription.isNotEmpty()){
                val formatter = SimpleDateFormat("EEE, d, MMM yyyy HH:mm a")
                if(isUpdate){
                    note = Note(
                        oldNote.id, title, noteDescription,formatter.format(Date())
                    )
                }else{
                    note = Note(
                        null, title, noteDescription, formatter.format(Date())
                    )
                }
                val intent = Intent()
                intent.putExtra("note", note)
                setResult(Activity.RESULT_OK, intent)
                finish()
            }else{
                Toast.makeText(this@AddNotes, "Please enter some text", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }
}