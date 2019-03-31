package main.java;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        Notepad notepad = new Notepad();
        Date date = new Date();

        //Add 25 Notes to empty Notepad
        for (int j = 0; j <= 25; j++) {
            notepad.addNote(new Note("note"+j, "description"+j, date, date));
        }
        notepad.printAllNotes(notepad.getAllNotes());

        //Check search by nonexistent Note title
        int idNote=notepad.returnNoteByTitle("nnnnn");
        if (idNote != -1) {
            System.out.println(notepad.getAllNotes()[idNote].toString());
        } else {
            System.out.println("The matched main.java.Note was not found. ");
        }

        //Search and delete Note by part of title
        idNote=notepad.returnNoteByTitle("e0");
        notepad.deleteNote(idNote);
        notepad.printAllNotes(notepad.getAllNotes());


        //Search and edit Note by title
        try {
            TimeUnit.SECONDS.sleep(10); //add delay in order to see change lastUpdatedDate
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        idNote=notepad.returnNoteByTitle("note21");
        notepad.editNote(idNote,"note21-new", "description21-new");
        notepad.printAllNotes(notepad.getAllNotes());


        //Delete all Notes

        for (int j = notepad.counterNotes-1; j >= 0; j--) {
            notepad.deleteNote(j);
        }

        notepad.printAllNotes(notepad.getAllNotes());
    }
}
