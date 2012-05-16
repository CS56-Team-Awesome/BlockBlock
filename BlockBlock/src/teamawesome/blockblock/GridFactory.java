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

    
    private Node gridNode;
    private static final float GRID_SPACE = 1.4f;
    
    public GridFactory(Node rootNode, AssetManager assetManager, int gridSizeX, int gridSizeY) {
        
        //make gridNode, attached to rootNode
        //attach gridControl to gridNode
        gridNode = new Node("gridNode");
        gridNode.addControl(new GridControl(gridSizeX, gridSizeY, new Cursor(gridSizeX, gridSizeY)));
        rootNode.attachChild(gridNode);
        gridNode.move(-6f, -6f, 0);
        
        /* make a tile, attach tile control
         * attach to gridNode
         * add reference to appropriate position in gridNode's gridControl's grid array
         * set position based on grid array position
         * loop this gridSize times
         */
        for (int i = 0; i < gridSizeX; i++) {
            for (int j = 0; j < gridSizeY; j++) {
                Spatial tile = assetManager.loadModel("Models/Tile.j3o");
                tile.setName("Tile" + i + "_" + j);
                Material mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                //mat.setBoolean("UseMaterialColors",true); 
                mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/tile_blue.png"));
                mat.setTexture("GlowMap", assetManager.loadTexture("Textures/tile_blue_alpha.png"));
                tile.setMaterial(mat);
                tile.addControl(new TileControl());
                gridNode.attachChild(tile);
                gridNode.getControl(GridControl.class).getGrid()[i][j] = tile;
                tile.move(j*GRID_SPACE, i*GRID_SPACE, 0);
            } //end inner loop
        } //end outer loop
    }
}