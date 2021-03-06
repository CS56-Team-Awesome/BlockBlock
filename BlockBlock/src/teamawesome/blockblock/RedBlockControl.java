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
public class RedBlockControl extends BlockControl {

    public RedBlockControl() {
        setColor(Color.Red);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case explodeState:
                //TODO: explode code here
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null && s.getControl(BlockControl.class).getColor() == Color.Blue)
                    {
                        s.getControl(BlockControl.class).setState(BlockState.explodeState);
                        
                    }
                    else if(s != null && s.getControl(BlockControl.class).getColor() == Color.Grey) continue;
                    else if(s != null) s.getControl(BlockControl.class).setState(BlockState.clearingState);
                }
                
                state = BlockState.clearingState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
