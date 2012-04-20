/*
 * This class serves as functionality for Blocks.
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
public class BlockControl extends AbstractControl implements Savable, Cloneable {
    
    /*-------------------------------Fields-----------------------------------*/
    public enum BlockState { idleState, clearingState, killState, currentState, playState, explodeState, flashingState, countDownState };
    public enum Color { Red, Blue, Black, Yellow, Green, Grey, Orange, Rainbow };
    private BlockState state;
    private Color color;
    private int points;
    
    /*-------------------------------Constructor------------------------------*/
    public BlockControl(){
    
    }
    
    /*-------------------------------Gets & Sets------------------------------*/
    public Color getColor() { return color; }

    public void setColor(Color color) { this.color = color; }

    public int getPoints() { return points; }

    public void setPoints(int points) { this.points = points; }

    public BlockState getState() { return state; }

    public void setState(BlockState state) { this.state = state; }
    
    
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
