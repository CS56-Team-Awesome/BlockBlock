/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

import com.jme3.asset.AssetManager;
import com.jme3.material.Material;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author Kayvan Boudai & Hasen Ahmad
 */
public class GridFactory {

    //private Node rootNode;
    private Node gridNode;
    //private AssetManager assetManager;
    //private int gridSize;
    
    public GridFactory(Node rootNode, AssetManager assetManager, int gridSize) {
//        this.rootNode = rootNode;
//        this.assetManager = assetManager;
//        this.gridSize = gridSize;
        
        //make gridNode, attached to rootNode
        //attach gridControl to gridNode
        gridNode = new Node("gridNode");
        gridNode.addControl(new GridControl(gridSize, gridSize, new Cursor()));
        rootNode.attachChild(gridNode);
        gridNode.center();
        
        /* make a tile, attach tile control
         * attach to gridNode
         * add reference to appropriate position in gridNode's gridControl's grid array
         * set position based on grid array position
         * loop this gridSize times
         */
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                Spatial tile = assetManager.loadModel("Models/Tile.j3o");
                tile.setName("Tile" + i + "_" + j);
                Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                mat.setBoolean("UseMaterialColors",true); 
                mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/tile_blue.png"));
                mat.setTexture("GlowMap", assetManager.loadTexture("Textures/tile_blue_alpha.png"));
                tile.setMaterial(mat);
                tile.addControl(new TileControl());
                gridNode.attachChild(tile);
                gridNode.getControl(GridControl.class).getGrid()[i][j] = tile;
                //this is the position to move from instancing at gridNode center
                //for now just j and i, add offsets to them when that is figured out
                tile.move(j, i, 0);
                
            } //end inner loop
        } //end outer loop
    }
    
}
