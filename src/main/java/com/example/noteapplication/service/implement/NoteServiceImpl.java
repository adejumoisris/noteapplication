package com.example.noteapplication.service.implement;

import com.example.noteapplication.model.Note;
import com.example.noteapplication.repository.NoteRepository;
import com.example.noteapplication.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public Note createNoteForUser(String username, String content) {
        Note note = new Note();
        note.setContent(content);
        note.setOwnerUsername(username);
       Note savedNote =  noteRepository.save(note);
        return savedNote;
    }

    @Override
    public Note updateNoteForUser(Long noteId, String content, String username) {
        Note note = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException());
        note.setContent(content);
       Note updatedNote =  noteRepository.save(note);
        return updatedNote;
    }

    @Override
    public void deleteNoteForUser(Long noteId, String username) {
        noteRepository.deleteById(noteId);
    }

    @Override
    public List<Note> getNotesForUser(String username) {
       List<Note> personaNotes= noteRepository.findByOwnerUsername(username);
        return personaNotes;
    }
}
