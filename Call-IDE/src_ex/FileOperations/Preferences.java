package FileOperations;

import java.awt.Font;
import java.io.Serializable;

/**
 * An immutable and serializable class to store the IDE preferences of the user
 * @author Emin Bahadir Tuluce
 * @version 1.0
 */
public class Preferences implements Serializable {
    
    private boolean autosave;
    private boolean bracketMatching;
    private boolean displayLineNumbers; 
    private boolean showHelpForErrors;
    private boolean[] toolbar; // true/false for every tool in toolbar
    private Font font; // the font object holds font name, size and style
    private int autosaveIn; // autosave period in minutes
    private int indentLevel; // number of spaces for the indentation
    private String theme; // the name of the xml theme file to load
    private String workspace; // the path to the folder of the root of the projects
    
    /** Creates a Preferences object with the given propreties. */
    public Preferences(boolean autosave, boolean bracketMatching, boolean displayLineNumbers,
                       boolean showHelpForErrors, boolean[] toolbar, Font font,
                       int autosaveIn, int indentLevel, String theme) {
        autosave = this.autosave;
        bracketMatching = this.bracketMatching;
        displayLineNumbers = this.displayLineNumbers;
        showHelpForErrors = this.showHelpForErrors;
        toolbar = this.toolbar; 
        font = this.font;
        autosaveIn = this.autosaveIn;
        indentLevel = this.indentLevel;
        theme = this.theme;
    }
    
    public boolean getAutosave() {
        return autosave;
    }
    public boolean getBracketMatching() {
        return bracketMatching;
    }
    public boolean getDisplayLineNumbers() {
        return  displayLineNumbers;
    }
    public boolean getShowHelpForErrors() {
        return showHelpForErrors;
    }
    public boolean[] getToolbar() {
        return  toolbar;
    }
    public Font getFont() {
        return font;
    }
    public int getAutosaveIn() {
        return autosaveIn;
    }
    public int getIndentLevel() {
        return indentLevel;
    }
    public String getTheme() {
        return theme;
    }
    public String getWorkspace() {
        return workspace;
    }
    
    /** Empty constructor which is needed for serialization */
    public Preferences() {}
}