package com.example.noteapplication.service;

import com.example.noteapplication.model.Note;

import java.util.List;

public interface NoteService {
    public Note createNoteForUser(String username,  String content);

    public Note updateNoteForUser(Long noteId, String content, String username);

    public void deleteNoteForUser(Long noteId, String username);

    public List<Note> getNotesForUser(String username);
}
