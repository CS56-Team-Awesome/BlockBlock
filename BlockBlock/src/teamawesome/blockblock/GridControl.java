/*
 * This class serves as functionality for the Grid.
 */
package teamawesome.blockblock;

import com.jme3.asset.AssetManager;
import com.jme3.export.Savable;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;
import java.util.ArrayList;
import teamawesome.blockblock.BlockControl.Color;

/**
 *
 * @author kaizokuace
 */
public class GridControl extends AbstractControl implements Savable, Cloneable {
    /*-------------------------------Fields-----------------------------------*/
    private Spatial[][] grid;
    private Cursor cursor;
    private Color[] colorArray;
    private int gridX, gridY;
    private Spatial blockNode;
    private AssetManager assetManager;
    /*-------------------------------Constructor------------------------------*/
    public GridControl(int gridX, int gridY, Cursor cursor, Color [] colorArray, AssetManager assetManager, Node rootNode) {
        this.grid = new Spatial[gridX][gridY];
        this.cursor = cursor;
        this.colorArray = colorArray;
        this.gridX = gridX;
        this.gridY = gridY;
        this.blockNode = rootNode.getChild("blockNode");
        this.assetManager = assetManager;
        
        //System.out.println("\n\n\n\n" + spatial.getParent().getName() + "\n\n\n\n");
    }
    /*-------------------------------Gets & Sets------------------------------*/

    public Cursor getCursor() { return cursor; }

    public void setCursor(Cursor cursor) { this.cursor = cursor; }

    public Spatial[][] getGrid() { return grid; }

    public void setGrid(Spatial[][] grid) { this.grid = grid; }
    
    /*-------------------------------Functions--------------------------------*/
    public ArrayList<Spatial> getAdjacent() {
        ArrayList<Spatial> adjList = new ArrayList<Spatial>();
        for(int i = cursor.getX() - 1;  i < cursor.getX() + 1; i++) {
            for(int j = cursor.getY() - 1; i < cursor.getY() + 1; j++) {
                if (i < 0 || i > gridX - 1 ) break;
                if (j < 0 || j > gridY - 1 || (i == cursor.getX() && j == cursor.getY())) continue;
                adjList.add(grid[i][j]);
            }
        }
        return adjList;
    }
    
    public void placeBlock(Color color) {
        BlockFactory bf = new BlockFactory(blockNode, assetManager, color);
        //TODO: Block Fatory(takes position and color), then change state to drop and drop animation will happen
    }
    
    /*-------------------------------Overrides--------------------------------*/
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
    }
    
    @Override
    protected void controlUpdate(float tpf) {
        //TODO: code here
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
