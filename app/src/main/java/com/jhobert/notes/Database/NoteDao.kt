package com.jhobert.notes.Database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.jhobert.notes.Models.Note

@Dao
interface NoteDao {

    @Insert
    suspend fun insert(note: Note)
    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * from notes order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("UPDATE notes Set title = :title, note = :note WHERE id = :id")
    suspend fun update(id: Int?, title: String?, note: String?)
}