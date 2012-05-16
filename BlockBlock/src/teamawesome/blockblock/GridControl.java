/*
 * This class serves as functionality for the Grid.
 */
package teamawesome.blockblock;

import com.jme3.export.Savable;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
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
    Spatial[][] grid;
    Cursor cursor;
    int gridX, gridY;
    /*-------------------------------Constructor------------------------------*/
    public GridControl(int gridX, int gridY, Cursor cursor) {
        this.grid = new Spatial[gridX][gridY];
        this.cursor = cursor;
        this.gridX = gridX;
        this.gridY = gridY;
    }
    /*-------------------------------Gets & Sets------------------------------*/

    public Cursor getCursor() { return cursor; }

    public void setCursor(Cursor cursor) { this.cursor = cursor; }

    public Spatial[][] getGrid() { return grid; }

    public void setGrid(Spatial[][] grid) { this.grid = grid; }
    
    /*-------------------------------Functions--------------------------------*/
    public ArrayList<Spatial> getAdjacent() {
        
        ArrayList<Spatial> adjList = new ArrayList<Spatial>();
        
        for(int i = cursor.getX() - 1;  i < cursor.getX() + 1; i++)
        {
            for(int j = cursor.getY() - 1; i < cursor.getY() + 1; j++)
            {
                if (i < 0 || i > gridX - 1 ) break;
                if (j < 0 || j > gridY - 1 || (i == cursor.getX() && j == cursor.getY())) continue;
                
                adjList.add(grid[i][j]);
            }
        }
        
        return adjList;
    }
    
    public void placeBlock(Color color) {
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
