/*
 * This class serves as functionality for Blocks.
 */
package teamawesome.blockblock;

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
    public enum BlockState { idleState, clearingState, killState, cursorState, dropState, explodeState, rainbowState, countDownState, rotateState, poisonState, antidoteState };
    public enum Color { Red, Blue, Black, Yellow, Green, Grey, Orange, Rainbow };
    protected BlockState state;
    private Color color;
    private int points;
    
    /*-------------------------------Constructor------------------------------*/
    public BlockControl() {
        state = BlockState.idleState;
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
        
        switch (state) {
        case idleState:
            //TODO: add idle animation?
            break;
        case clearingState:
            //TODO: clearing animation code
            state = BlockState.killState;
            break;
        case killState:
            //TODO: fix certain kills...
            Cursor cursor = spatial.getParent().getParent().getChild("gridNode").getControl(GridControl.class).getCursor();
            spatial.getParent().getParent().getChild("gridNode").getControl(GridControl.class).getGrid()[cursor.getX()][cursor.getY()] = null;
            spatial.getParent().detachChild(spatial);
            break;
        case cursorState:
            state = BlockState.idleState;
            break;
        case dropState:
            if(spatial.getLocalTranslation().getZ() >= 0)
                spatial.move(0, 0, -.1f);
            else
            {
                switch (color)
                {
                    case Black: 
                        state = BlockState.countDownState;
                        break;
                    case Blue:
                        state = BlockState.idleState;
                        break;
                    case Green:
                        state = BlockState.poisonState;
                        break;
                    case Grey:    
                        state = BlockState.idleState;
                        break;
                    case Orange:
                        state = BlockState.antidoteState;
                        break;
                    case Red:
                        state = BlockState.explodeState;
                        break;
                    case Yellow:
                        state = BlockState.rotateState;
                        break;
                    case Rainbow:
                        state = BlockState.rainbowState;
                        break;
                }
            }
            break;
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        
    }

    public Control cloneForSpatial(Spatial spatial) {
        final BlockControl control = new BlockControl();
        /* Optional: use setters to copy userdata into the cloned control */
        // control.setIndex(i); // example
        control.points = this.points;
        control.color = this.color;
        control.state = this.state;
        control.setSpatial(spatial);
        return control;
    }
    
}
