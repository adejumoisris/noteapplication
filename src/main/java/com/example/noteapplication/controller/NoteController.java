package com.example.noteapplication.controller;

import com.example.noteapplication.model.Note;
import com.example.noteapplication.service.NoteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping
    public Note createNote(@RequestBody String content, @AuthenticationPrincipal UserDetails  userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.createNoteForUser(username, content);
    }
    @GetMapping
    public List<Note> getUserNotes(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.getNotesForUser(username);

    }
    @PutMapping("/{notedId}")
    public Note updateNote(@PathVariable Long notedId, @RequestBody String content, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        return noteService.updateNoteForUser(notedId, username, content);
    }

    @DeleteMapping("/{notedId}")
    public void deleteNote(@PathVariable Long notedId, @AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        System.out.println("USER DETAILS: " + username);
        noteService.deleteNoteForUser(notedId, username);
    }
}
