package filebrowser;

import fileoperations.FileSaver;
import java.util.*;
import javax.swing.tree.*;
import java.io.*;

/**
 * 
 * @author Mahmud Sami Aydin
 * 
 */
public class FileNode extends DefaultMutableTreeNode
{
   
   PathedFile file;
   boolean allowsChildren;
   HashMap nodesAndPaths;
   
   public FileNode( ArrayList<String> files )
   {
      super();
      FileNode temp;
      allowsChildren = true;
      nodesAndPaths = new HashMap();
      
      file = new PathedFile("/Nowhere/it/is/not/a/real/file");
      
      nodesAndPaths.put(file.getAbsolutePath() , this);
      
      for ( int i =0 ; i < files.size(); i++)
      {
         temp = new FileNode( new PathedFile ( files.get(i) , file.getObjPath() ) , nodesAndPaths );
         if( getIndex( temp ) == -1 && temp != null)
         {
            // System.out.println(temp);
            add( temp );
         }
      }
      
      
      // System.out.println(nodesAndPaths);//.keySet());
   }
   public FileNode( PathedFile file, HashMap nodesAndPaths )
   {
      super();
      this. file = file;
      allowsChildren = this.file.isDirectory();
     
        this.nodesAndPaths =  nodesAndPaths;
      
      nodesAndPaths.put(this.file.getAbsolutePath(), this);
      
      if( getAllowsChildren() )
      {
         addChildren();
      }
      
      
      //System.out.println(nodesAndPaths);//.keySet());
   }
   
    public FileNode( PathedFile file  )
   {
      super();
      this. file = file;
      allowsChildren = this.file.isDirectory();
     
      
      nodesAndPaths.put(this.file.getAbsolutePath(), this);
      
      if( getAllowsChildren() )
      {
         addChildren();
      }
      
      
      //System.out.println(nodesAndPaths);//.keySet());
   }
   
   public void addChildren()
   {  
      for( int i = 0; i < file.listFiles().length; i++)   
      {
         
         if(!nodesAndPaths.containsKey(file.listFiles()[i].getAbsolutePath()))
          {
            add( new FileNode( new PathedFile( file.listFiles()[i].getAbsolutePath(), file.path) , nodesAndPaths ) );
         }
         
      }
   }
   //------------------
   public boolean getAllowsChildren()
   {
      return allowsChildren;
   }
   
   //------------------------------------------------------------
   @Override
   public String toString()
   {
       if(file.equals(new PathedFile("/Nowhere/it/is/not/a/real/file")))
           return "Files";
      return file.toString();
   }
   
   public boolean equals( FileNode n )
   {
      return file.getPath().equals( n.file.getPath() );
   }
   
   /**
    *  This method get the parents tree of node
    *  @return tree path for node
    */
   protected TreePath getTree()
   {
      FileNode[] tempNodes;
      tempNodes = new FileNode[ file.path.length ];
      for ( int i = 0 ; i < file.path.length ; i ++ )
      {
         tempNodes[i] = new FileNode(  file.path[i]  );
      }
      
      return new TreePath( tempNodes );
   }
   
   /**
    * This method delete the node from jtree
    * 
    */
   public boolean delete()
   {
      removeFromParent();
      return file.delete();
   }
   
   
   /**
    * This method add the folder a file
    * 
    */
   public void createFile( String fileName) throws IOException
   {
            FileNode temp;
      if( getAllowsChildren() )
      {
           temp = new FileNode( new PathedFile( file.getAbsolutePath() + "/" 
                                             + fileName +  "/" ,  file.path ) , nodesAndPaths);
            add( temp  );
           new FileSaver(file).save(fileName);
      }
      
   }
   
   /**
    * This method add the folder a folder
    * 
    */
   public void createDirectory( String fileName)
   {
       FileNode temp;
      if( getAllowsChildren() )
      {
          temp = new FileNode( new PathedFile( file.getAbsolutePath() + "/" 
                                             + fileName +  "/" ,  file.path ) , nodesAndPaths);
          temp.file.mkdir();
         add( temp  );
         
      }
      
   }
   
   /**
    * This method get the file of node
    * 
    * 
    */
   public File getFile()
   {
      return file;
   }
 
   
   /**
    * This method open a file from path
    * 
    * 
    */
   public void openFile( String filePath )
   {
      if( getAllowsChildren() )
      {
         add(new FileNode( new PathedFile ( filePath ) )); 
      }
   }
   
   /**
    * This method remove file node from tree
    * 
    * 
    */
   public void closeFile()
   {
      removeFromParent();
   }
   
      /**
    * This method remove file node from tree
    * 
    * 
    */
   public void copyFile()
   {
      new FileSaver(file).saveAs(file.fileName + "copy" + file.extension, file);
      ((FileNode)getParent()).updateChildren();
   }
 
           
   public void updateChildren()
   {
       addChildren();
       for (int i = getChildCount();  i > 0 ; i-- )
       {
           if( !getChildAt(i-1).isLeaf() )
            {
                ((FileNode)getChildAt(i-1)).updateChildren();
            }
       }
   }
}


