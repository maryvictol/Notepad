package test.java;

import main.java.Note;
import main.java.Notepad;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class NotepadTest {

    //Add 25 Notes to empty Notepad

    @Test
    public void addNoteToNotebook() {
    Notepad notepad = new Notepad();
    Date date = new Date();
    notepad.addNote(new Note("note", "description", date, date));
    assertEquals("Notepad ", notepad.maxNumberNotes, notepad.getAllNotes().length);
    }


    @Test
    public void addSeveralNotesToEmptyNotepad() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j < 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        int counter = 0;
        for (int i = 0; i < notepad.getAllNotes().length; i ++)
            if (notepad.getAllNotes()[i] != null) {
                counter++;
            }
        assertEquals("Not null Notes: ", 25, counter);
    }

    @Test
    public void searchNoteByPartNonExistingTitle() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        assertEquals("Not Existing Note: ", -1, notepad.returnNoteByTitle("nnnnn"));
    }

    @Test
    public void searchNoteByPartExistingTitle() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        assertEquals("Not Existing Note: ", 6, notepad.returnNoteByTitle("e6"));
    }

    @Test
    public void deleteNonExistingNote() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        int initialCountNotes = notepad.counterNotes;
        notepad.deleteNote(notepad.returnNoteByTitle("e000"));
        assertEquals("Not Existing Note: ", initialCountNotes, notepad.counterNotes);
    }

    @Test
    public void deleteExistingNote() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        int initialCountNotes = notepad.counterNotes;
        notepad.deleteNote(notepad.returnNoteByTitle("e6"));
        assertEquals("Count Notes: ", initialCountNotes-1, notepad.counterNotes);
        assertEquals("Existing Note is deleted: ", -1, notepad.returnNoteByTitle("e6"));
    }

    @Test
    public void editExistingNote() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        try {
            TimeUnit.SECONDS.sleep(10); //add delay in order to see change lastUpdatedDate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int noteNumber = notepad.returnNoteByTitle("note7");
        notepad.editNote(noteNumber,"note7-new","description7-new");
        assertEquals("title: ", "note7-new", notepad.getAllNotes()[noteNumber].getTitle());
        assertEquals("description: ", "description7-new", notepad.getAllNotes()[noteNumber].getDescription());
        assertNotEquals("lastupdated : ", notepad.getAllNotes()[noteNumber].getCreatedDate(), notepad.getAllNotes()[noteNumber].getLastUpdatedDate());
    }

}
