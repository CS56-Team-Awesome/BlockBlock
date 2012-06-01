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
public class GreenBlockControl extends BlockControl {
    private static int i = 300;

    public GreenBlockControl() {
        setColor(Color.Green);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
//                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
//                for(Spatial s: adj)
//                {
//                    if(s != null)
//                    {
//                        s.getControl(BlockControl.class).setColor(Color.Green);
//                    }
//                }
                if(i < 0) state = BlockState.killState; 
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
