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
public class OrangeBlockControl extends BlockControl {
    
    private boolean skip = true;

    public OrangeBlockControl() {
        setColor(Color.Orange);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case antidoteState:
                //TODO: antidote code here
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null && s.getControl(BlockControl.class).getColor() == Color.Green)
                    {
                        s.getControl(BlockControl.class).setState(BlockState.clearingState);
                        s.getControl(GreenBlockControl.class).setCountDown(7000);
                        spatial.getControl(BlockControl.class).setState(BlockState.clearingState);
                        skip = false;
                    }
                }
                if (skip)state = BlockState.idleState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
