package runutils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Abdullah Talayhan
 */
public class ReadStdOut implements Runnable {
    
    public Thread read = null;
    private BufferedReader reader = null;
    private Process process = null;
    private JTextPane console = null;
    private boolean finish;
    
    /**
     * Description: Handles the System.out from a forked process
     * @param p forked process
     * @param t pane that the err stream going to be directed
     */
    public ReadStdOut(Process p,JTextPane t) {
        finish = false;
        process = p;
        reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        console = t;
        read = new Thread(this);
        read.start();
    }
    
    /**
     * Description: run method for the ReadStdOut thread
     */
    public void run() {
        try {
            char nextChar = (char) reader.read();
            
            while (("" + nextChar).matches("^\\p{ASCII}*$")) {
                Thread.sleep(1);
                appendString("" + nextChar,console);
                console.setCaretPosition(console.getDocument().getLength());
                nextChar = (char) reader.read();
            }
            
            reader.close();
            finish = true;
            
        } catch (IOException ex) {
            Logger.getLogger(ReadStdOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(ReadStdOut.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(RunFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /**
     * Description: method that appends the string to a given pane
     * @param str string to be appended
     * @param pane pane to be appended
     * @throws BadLocationException 
     */
    public  void appendString(String str, JTextPane pane) throws BadLocationException {
        StyledDocument document = (StyledDocument) pane.getDocument();
        document.insertString(document.getLength(), str, null);
    }
    
    /**
     * Description: closes the reader
     */
    public void closeAll() {
        try {
            reader.close();
        } catch (IOException ex) {
            Logger.getLogger(ReadStdOut.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Description: check the process state:
     * @return boolean whether the process is finished or not
     */
    public boolean isFinished() {
        return finish;
    }
    
    /**
     * kill the process of the thread
     */
    public void killUrSelf() {
        read.interrupt();
    }
}
