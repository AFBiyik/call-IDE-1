package FileOperations;

import java.io.IOException;
import java.io.File;
import java.io.PrintWriter;

/**
 * A class to save text files.
 * @author Emin Bahadir Tuluce
 * @version 1.0
 */

public class FileSaver {
    
    /** The saving path of the contents */
    private File path;
    
    /**
     * Creates an instance of FileSaver with the specified path.
     * @param path the saving path of the contents
     */
    public FileSaver( File path) {
        this.path = path;
    }
    
    /** @param path the saving path of the contents */
    public void setPath( File path) {
        this.path = path;
    }
    
    /**
     * Saves the contents to the specified path.
     * @param content the contents to save
     * @throws IOException if the writing is failed
     */
    public void save( String content) throws IOException {
        saveAs( content, path);
    }
    
    /**
     * Saves the contents to the given path.
     * @param content the contents to save
     * @param diffPath the different saving path of the contents
     * @throws IOException if the writing is failed
     */
    public void saveAs( String content, File diffPath) throws IOException {
        PrintWriter output = new PrintWriter( diffPath);
        output.print( content);
        output.close();
    }
}