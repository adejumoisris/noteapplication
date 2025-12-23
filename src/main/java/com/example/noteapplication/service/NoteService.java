package com.example.noteapplication.service;

import com.example.noteapplication.model.Note;

public interface NoteService {
    public Note createNoteForUser(String username,  String content);

    public Note updateNoteForUser(Long noteId, String content, String username);
}
