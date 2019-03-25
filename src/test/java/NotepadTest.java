package test.java;

import main.java.Note;
import main.java.Notepad;
import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

public class NotepadTest {

    //Add 25 Notes to empty Notepad
    @Test
    public void addNotesToEmptyNotepad() {
        Notepad notepad = new Notepad();
        Date date = new Date();
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note" + j, "description" + j, date, date));
        }
        assertEquals("Notepad ", notepad.maxNumberNotes, notepad.getAllNotes().length);
    }
}
