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
public class BlackBlockControl extends BlockControl {
    private int i = 300;

    public BlackBlockControl() {
        setColor(Color.Black);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case explodeState:
                //TODO: explode code here
                adj = gridNode.getControl(GridControl.class).getAdjacent();
                for(Spatial s: adj)
                {
                    if(s != null) s.getControl(BlockControl.class).setState(BlockState.clearingState);
                }
                state = BlockState.killState;
                break;
            case countDownState:
                //TODO: countdown code
                i--;
                if(i < 0) state = BlockState.explodeState;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
