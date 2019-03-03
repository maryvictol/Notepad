import java.util.Date;

public class Notepad {

    static int counterNotes = 0;
    private static int maxNumberNotes = 10;  //initial Notepad size
    private static Note[] notes = new Note[maxNumberNotes];

    public Notepad() {
        this.notes = notes;
    }

    //Add Note to Notepad
    public void addNote(Note note) {
        if (counterNotes == maxNumberNotes) {
            int newMaxNumberNotes = (int) Math.ceil(maxNumberNotes * 1.5);
            Note[] tempNotes = new Note[newMaxNumberNotes];
            System.arraycopy(notes, 0, tempNotes, 0, maxNumberNotes);
            notes = tempNotes;
            maxNumberNotes = newMaxNumberNotes;
        }
        notes[counterNotes] = note;
        counterNotes ++;
    }

    //Get all notes
    public Note[] getAllNotes() {
        return notes;
    }
    //Print all notes
    public void printAllNotes(Note[] allNotes) {
        if (counterNotes == 0) {
            System.out.println("There aren't Notes in the Notepad!");
        } else {
            for (int numNotes = 0; numNotes < counterNotes-1; numNotes++) {
                if (allNotes[numNotes] != null) {
                    System.out.println(allNotes[numNotes].toString());
                }
            }
        }
    }

    //Search first Note by part of title
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
        return -1;  //The matched Note was not found.
    }

    //public void delete(int numberNote) {
    public void deleteNote(int numberNote) {
        System.arraycopy(notes, numberNote + 1, notes, numberNote, counterNotes - numberNote);
        counterNotes--;
        if (maxNumberNotes-counterNotes == 15) {
            Note[] tempNotes = new Note[maxNumberNotes - 10];
            System.arraycopy(notes, 0, tempNotes, 0, counterNotes);
            notes = tempNotes;
            maxNumberNotes -= 10;
        }
    }

    public void editNote(int numberNote, String title, String description) {
        if (numberNote >= 0 && numberNote <= counterNotes-1) {
            notes[numberNote].setTitle(title);
            notes[numberNote].setDescription(description);
            notes[numberNote].setLastUpdatedDate();
        } else {
            System.out.println("Please, check required Note number");
        }
    }

}
