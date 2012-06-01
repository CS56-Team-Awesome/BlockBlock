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
    private static int i = 600;

    public GreenBlockControl() {
        setColor(Color.Green);
        setState(BlockState.cursorState);
        if(i <= 0) i = 600;
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
                --i;
                if(i <= 0)
                {
                    gridNode.getControl(GridControl.class).changeColor(spatial, Color.Grey);
                } 
                break;
            case poisonState:
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null)
                    {
                        gridNode.getControl(GridControl.class).changeColor(s, Color.Green);
                    }
                }
                state = BlockState.countDownState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
