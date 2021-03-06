package fileoperations.configurers;

import java.awt.Font;
import java.io.Serializable;

/**
 * An immutable and serializable class to store the IDE preferences of the user
 * @author Emin Bahadir Tuluce
 * @version 1.0
 */
public class Preferences implements Serializable {
    
    /** The default link to the submission system */
    public static final String DEF_LINK = "https://stars.bilkent.edu.tr/srs";
    
    /** The default font object for the editor and the console pane */
    public static final Font DEF_FONT = new Font("Consolas", Font.PLAIN, 16);
    
    /** The default toolbar settings for the frame */
    public static final boolean[] DEF_TOOLBAR = {true, true, true,
        true, true, true, true, true, true, true, true, true, true, true};
    
    /** The default theme for the editor */
    public static final String DEF_THEME = "/org/fife/ui/rsyntaxtextarea/themes/default.xml";
    
    /** The default preferences object for the IDE */
    public static final Preferences DEFAULT = new Preferences(false, true, true,
            true, DEF_TOOLBAR, DEF_FONT, DEF_FONT, -1, 4, DEF_THEME, DEF_LINK);
    
    private boolean dispatchOnRun;
    private boolean bracketMatching;
    private boolean displayLineNumbers; 
    private boolean showHelpForErrors;
    private boolean[] toolbar; // true/false for every tool in toolbar
    private Font editorFont;
    private Font outputFont;
    private int autosaveIn; // autosave period in miliseconds
    private int indentLevel; // number of spaces for the indentation
    private String theme; // the name of the xml theme file to load
    private String submissionLink;
    
    /** Creates a Preferences object with the given propreties. */
    public Preferences(boolean dispatchOnRun, boolean bracketMatching, boolean displayLineNumbers,
            boolean showHelpForErrors, boolean[] toolbar, Font editorFont, Font outputFont,
            int autosaveIn, int indentLevel, String theme, String submissionLink) {
        this.dispatchOnRun = dispatchOnRun;
        this.bracketMatching = bracketMatching;
        this.displayLineNumbers = displayLineNumbers;
        this.showHelpForErrors = showHelpForErrors;
        this.toolbar = toolbar; 
        this.editorFont = editorFont;
        this.outputFont = outputFont;
        this.autosaveIn = autosaveIn;
        this.indentLevel = indentLevel;
        this.theme = theme;
        this.submissionLink = submissionLink;
    }
    
    public boolean getDispatchOnRun() {
        return dispatchOnRun;
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
    public Font getEditorFont() {
        return editorFont;
    }
    public Font getOutputFont() {
        return outputFont;
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
    public String getSubmissionLink() {
        return submissionLink;
    }
    
    /** Empty constructor which is needed for serialization */
    public Preferences() {}
    
}
