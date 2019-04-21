package main.java;

public class Notepad {

    public static final double INCREASE_KOEFF = 1.5;
    public static final int NUM_REMOVE_NOTES = 10;
    public static final int NUM_EMPTY_NOTES = 15;


    private int counterNotes = 0;
    //initial Notepad size
    public int maxNumberNotes = 10;

    private Note[] notes = new Note[maxNumberNotes];

    //Add Note to Notepad
    public void addNote(Note note) {
        if (counterNotes == maxNumberNotes) {
            int newMaxNumberNotes = (int) Math.ceil(maxNumberNotes * INCREASE_KOEFF);
            Note[] tempNotes = new Note[newMaxNumberNotes];
            System.arraycopy(notes, 0, tempNotes, 0, maxNumberNotes);
            notes = tempNotes;
            maxNumberNotes = newMaxNumberNotes;
        }
        notes[counterNotes] = note;
        counterNotes++;
    }

    //Get all notes
    public Note[] getAllNotes() {
        return notes.clone();
    }

    //Print all notes
    public void printAllNotes(Note[] allNotes) {
        if (counterNotes == 0) {
            System.out.println("There aren't Notes in the Notepad!");
        } else {
            for (int numNotes = 0; numNotes < counterNotes - 1; numNotes++) {
                if (allNotes[numNotes] != null) {
                    System.out.println(allNotes[numNotes]);
                }
            }
        }
    }

    //Search first main.java.Note by part of title
    public int returnNoteByTitle(String title) {
        String noteName;
        for (int numNotes = 0; numNotes < notes.length; numNotes++) {
            if (notes[numNotes] != null) {
                noteName = notes[numNotes].getTitle();
                if (noteName != null && noteName.contains(title)) {
                    return numNotes;
                }
            }
        }
        //The matched Note was not found.
        return -1;
    }

    //public void delete(int numberNote) {
    public boolean deleteNote(int numberNote) {
        if (numberNote <= 0 || numberNote > counterNotes) {
            return false;
        }
        System.arraycopy(notes, numberNote + 1, notes, numberNote, counterNotes - numberNote);
        counterNotes--;
        if (maxNumberNotes - counterNotes == NUM_EMPTY_NOTES) {
            Note[] tempNotes = new Note[maxNumberNotes - NUM_REMOVE_NOTES];
            System.arraycopy(notes, 0, tempNotes, 0, counterNotes);
            notes = tempNotes;
            maxNumberNotes -= NUM_REMOVE_NOTES;
        }
        return true;
    }

    public void editNote(int numberNote, String title, String description) {
        if (numberNote >= 0 && numberNote <= counterNotes - 1) {
            notes[numberNote].modifyNote(title, description);
        } else {
            System.out.println("Please, check required Note number");
        }
    }

    public int getCounterNotes() {
        return counterNotes;
    }

}
