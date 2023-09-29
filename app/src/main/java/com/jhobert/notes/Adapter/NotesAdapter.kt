package com.jhobert.notes.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.jhobert.notes.Models.Note
import com.jhobert.notes.R

class NotesAdapter(private val context: Context) :
    RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {
    private val notesList: ArrayList<Note>()
    private val fullList: ArrayList<Note>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            LayoutInflater.from(context).inflate(R.layout.list_item, parent, false)
        )
    }


    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = notesList[position]
        holder.title.text = currentNote.title
        holder.title.isSelected = true

        holder.noteTv.text = currentNote.note
        holder.date.text = currentNote.date
        holder.date.isSelected = true
    }

    fun randomColor() : Int {

    }

    inner class NoteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val notesLayout: CardView = itemView.findViewById<CardView>(R.id.note)
        val title = itemView.findViewById<TextView>(R.id.tv_title)
        val noteTv = itemView.findViewById<TextView>(R.id.tv_note)
        val date = itemView.findViewById<TextView>(R.id.tv_date)
    }
}