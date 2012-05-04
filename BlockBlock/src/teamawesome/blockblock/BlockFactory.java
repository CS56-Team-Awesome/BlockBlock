/*
 * 
 */
package teamawesome.blockblock;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.shape.Box;
import teamawesome.blockblock.BlockControl.Color;

/**
 *
 * @author Kayvan Boudai & Hasen Ahmad
 */
public class BlockFactory {

    private Node blockNode;
    private AssetManager assetManager;
    private Spatial block;
    public static int blockCount;
    
    
    public BlockFactory(Spatial blockNode, AssetManager assetManager, Color color) {
        this.blockNode = (Node) blockNode;
        this.assetManager = assetManager;
        
        /*--------------------generate block----------------------------------*/ 
        block = assetManager.loadModel("Models/Block.j3o");
        block.setName("Block" + blockCount++);
        Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        mat.setBoolean("UseMaterialColors",true);
        
        switch(color) {
        case Red: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_red.png"));
            block.addControl(new RedBlockControl());
            break;
        case Blue: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_blue.png"));
            block.addControl(new BlueBlockControl());
            break;
        case Black: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_black.png"));
            block.addControl(new BlackBlockControl());
            break;
        case Yellow: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_yellow.png"));
            block.addControl(new YellowBlockControl());
            break;
        case Green: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_green.png"));
            block.addControl(new GreenBlockControl());
            break;
        case Grey: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_grey.png")); 
            block.addControl(new GreyBlockControl());
            break;
        case Orange: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_orange.png"));
            block.addControl(new OrangeBlockControl());
            break;
        case Rainbow: 
            mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_orange.png"));
            block.addControl(new RainbowBlockControl());
            break;   
        }
        
        block.setMaterial(mat);
        this.blockNode.attachChild(block);
        //set position?
    }
    
    Spatial getBlock() {
        return block;
    }
    
}
