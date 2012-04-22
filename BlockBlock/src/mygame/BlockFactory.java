/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import mygame.BlockControl.Color;

/**
 *
 * @author kayvanboudai
 */
public class BlockFactory {

    private Node blockNode;
    private AssetManager assetManager;
    private Geometry block;
    public static int blockCount;
    
    
    public BlockFactory(Spatial blockNode, AssetManager assetManager, Color color) {
        this.blockNode = (Node) blockNode;
        this.assetManager = assetManager;
        
        /** A simple textured cube. */ 
        Box boxshape1 = new Box(Vector3f.ZERO, 1f,1f,1f); 
        block = new Geometry("Block"+ blockCount++, boxshape1); 
        Material mat_stl = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");  
        block.setMaterial(mat_stl);
        
        switch(color)
        {
            case Red: mat_stl.setColor("Color", ColorRGBA.Red);
                      block.addControl(new RedBlockControl());
                      break;
            case Blue: mat_stl.setColor("Color", ColorRGBA.Blue);
                       block.addControl(new BlueBlockControl());
                       break;
            case Black: mat_stl.setColor("Color", ColorRGBA.Black);
                        block.addControl(new BlackBlockControl());
                        break;
            case Yellow: mat_stl.setColor("Color", ColorRGBA.Yellow);
                         block.addControl(new YellowBlockControl());
                         break;
            case Green: mat_stl.setColor("Color", ColorRGBA.Green); 
                        block.addControl(new GreenBlockControl());
                        break;
            case Grey: mat_stl.setColor("Color", ColorRGBA.Gray); 
                        block.addControl(new GreyBlockControl());
                       break;
            case Orange: mat_stl.setColor("Color", ColorRGBA.Orange); 
                        block.addControl(new OrangeBlockControl());
                         break;
            case Rainbow: mat_stl.setColor("Color", ColorRGBA.Orange);
                          block.addControl(new RainbowBlockControl());
                         break;
               
        }
        
        this.blockNode.attachChild(block);
        
    }
    
    Spatial getBlock()
    {
        return block;
    }
    
}
