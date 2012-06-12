/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

import com.jme3.scene.Spatial;

/**
 *
 * @author kaizokuace
 */
public class BlueBlockControl extends BlockControl {

    public BlueBlockControl() {
        setColor(Color.Blue);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        //System.out.println(state + " before switch");
        switch (state) {
            case explodeState:
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null && s.getControl(BlockControl.class).getColor() == Color.Blue) s.getControl(BlockControl.class).setState(BlockState.explodeState);
                }
                state = BlockState.clearingState; 
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
