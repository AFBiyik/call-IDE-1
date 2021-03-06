package methodsummary;

/**
 * An interface for nodes in the method summary tree
 * @author Mahmud Sami Aydin
 * @version 1.0
 */
interface SummaryNode {

    //Constrants
    final int CLASS_NODE = 0;
    final int INNER_NODE = 1;
    final int INFACE_NODE = 2;
    final int BYTE_NODE = 3;
    final int SHORT_NODE = 4;
    final int INT_NODE = 5;
    final int LONG_NODE = 6;
    final int FLOAT_NODE = 7;
    final int DOUBLE_NODE = 8;
    final int CHAR_NODE = 9;
    final int OBJECT_NODE = 10;
    final int BOOLEAN_NODE = 11;
    final int CONST_NODE = 12;
    final int VOID_NODE = 13;
    final int PACKAGE_NODE = 14;
    
    /**
     * This method gives node type 
     * @return type of the node 
     */
    public int nodeType();
    
    /**
     * This method gives the javadoc comments
     * @return the javadoc comments of the node
     */
    public String getJavadoc();
    
}
