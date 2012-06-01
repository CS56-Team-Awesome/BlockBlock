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
    public static int blockCount = 0;
    
    
    public BlockFactory(Spatial blockNode, AssetManager assetManager, Color color) {
        this.blockNode = (Node) blockNode;
        this.assetManager = assetManager;
        
        /*--------------------generate block----------------------------------*/ 
        block = assetManager.loadModel("Models/Block2.j3o");
        block.setName("Block" + (blockCount++) + "_" + color);
        //Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        //mat.setBoolean("UseMaterialColors",true);
        
        switch(color) {
        case Red: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_red.png"));
            mat.setColor("Color", ColorRGBA.Red);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new RedBlockControl());
            break;
        case Blue: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_blue.png"));
            mat.setColor("Color", ColorRGBA.Blue);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new BlueBlockControl());
            break;
        case Black: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_black.png"));
            mat.setColor("Color", ColorRGBA.White);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new BlackBlockControl());
            break;
        case Yellow: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_yellow.png"));
            mat.setColor("Color", ColorRGBA.Yellow);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new YellowBlockControl());
            break;
        case Green: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_green.png"));
            mat.setColor("Color", ColorRGBA.Green);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new GreenBlockControl());
            break;
        case Grey: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_grey.png")); 
            mat.setColor("Color", ColorRGBA.Gray);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new GreyBlockControl());
            break;
        case Orange: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_orange.png"));
            mat.setColor("Color", ColorRGBA.Orange);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new OrangeBlockControl());
            break;
        case Rainbow: 
            //mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/block_orange.png"));
            mat.setColor("Color", ColorRGBA.Gray);
            mat.setTexture("ColorMap", assetManager.loadTexture("Textures/block_texture2.png"));
            block.addControl(new RainbowBlockControl());
            break;   
        }
        
        block.getControl(BlockControl.class).setX(blockNode.getParent().getChild("gridNode").getControl(GridControl.class).getCursor().getX());
        block.getControl(BlockControl.class).setY(blockNode.getParent().getChild("gridNode").getControl(GridControl.class).getCursor().getY());
        
        block.setMaterial(mat);
        this.blockNode.attachChild(block);
        block.move(0, 0, 2);
    }
    
    Spatial getBlock() {
        return block;
    }
    
}
