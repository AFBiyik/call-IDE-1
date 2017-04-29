package filebrowser;

import java.io.File;

/**
 * This class present files for file node with contains references itself, parent and grandparents
 * @author Mahmud Sami Aydin
 * version 1.03, 29/04/2017
 */
public class PathedFile extends File 
{
    // Properties
    PathedFile[] path;
    String       fileName;
    String       extension;
    
    // Constructors
    /**
     * This consturctor make child file, path getter from parent
     *
     *
     */
    public PathedFile( String pathname, PathedFile[] parentPath )
    {
        super( pathname );
        
        int extensionIndex;
        
        path = new PathedFile[ parentPath.length + 1 ];
        for( int i = 0 ; i < parentPath.length ; i++ )
        {
            path[i] = parentPath[i];
        }
        
        path[ parentPath.length ] = this;
        
        extensionIndex = getName().lastIndexOf('.');
        if( extensionIndex > 0)
        {
            extension = getName().substring( extensionIndex + 1);
            fileName = getName().substring(0, extensionIndex );
        }
        else
        {
            extension = "";
            fileName = getName();
        }
    }
    
    public PathedFile( String pathname )
    {
        super( pathname );
        path = new PathedFile[  1 ];
        
        path[ 0 ] = this;
        
    }
    
    // Methods
    public PathedFile[] getObjPath()
    {
        return path;
    }
    
    @Override
    public String toString()
    {
        if (extension == null || extension.isEmpty())
            return fileName;
        return fileName + "." + extension;
    }
    
    /** This method determines file is java file */
    public boolean isJavaFile()
    {
        if (extension == null)
            return false;
        return extension.equals("java");
    }
    
    /** This method determines file is a callide project file  */
    public boolean isCallideFile()
    {
        if (extension == null)
            return false;
        return extension.equals("callide");
    }
}
