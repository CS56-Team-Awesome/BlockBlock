/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author kayvanboudai
 */
public class BlockFactory {

    private Node blockNode;
    private Spatial block;
    public static int blockCount;
    
    
    public BlockFactory(Node blockNode) {
        this.blockNode = blockNode;
        //TODO: Write code
        
    }
    
    Spatial getBlock()
    {
        Spatial s = block;
        //TODO: write code
        return s;
    }
    
}
