/*
 * This class serves as functionality for the Grid.
 */
package mygame;

import com.jme3.export.Savable;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;

/**
 *
 * @author kaizokuace
 */
public class GridControl extends AbstractControl implements Savable, Cloneable {
    /*-------------------------------Fields-----------------------------------*/
    Spatial[][] grid;
    Cursor cursor;
    
    /*-------------------------------Constructor------------------------------*/
    public GridControl(int gridX, int gridY, Cursor cursor) {
        this.grid = new Spatial[gridX][gridY];
        this.cursor = cursor;
    }
    /*-------------------------------Gets & Sets------------------------------*/

    public Cursor getCursor() { return cursor; }

    public void setCursor(Cursor cursor) { this.cursor = cursor; }

    public Spatial[][] getGrid() { return grid; }

    public void setGrid(Spatial[][] grid) { this.grid = grid; }
    
    /*-------------------------------Functions--------------------------------*/
    public Spatial[] getAdjacent() {
        //TODO: code here
        return null;
    }
    
    public void placeBlock(int x, int y, Spatial block) {
        //TODO: code here
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
