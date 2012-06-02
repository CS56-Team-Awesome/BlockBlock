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
    private static int i = 6000;

    public GreenBlockControl() {
        setColor(Color.Green);
        setState(BlockState.cursorState);
        if(i <= 0) i = 6000;
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
                System.out.println("\n\n\n\n" + --i +"\n\n\n\n\n");
                if(i <= 0)
                {
                    gridNode.getControl(GridControl.class).changeColor(spatial, Color.Grey);
                } 
                break;
            case poisonState:
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null && s.getControl(BlockControl.class).getColor() != Color.Green)
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
