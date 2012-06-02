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
    private static int countDown = 6000;
    private boolean skip = true;

    public static int getCountDown() {
        return countDown;
    }

    public static void setCountDown(int countDown) {
        GreenBlockControl.countDown = countDown;
    }

    public GreenBlockControl() {
        setColor(Color.Green);
        setState(BlockState.cursorState);
        if(countDown <= 0 || countDown > 6000) countDown = 6000;
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
                System.out.println("\n\n\n\n" + --countDown +"\n\n\n\n\n");
                if(countDown <= 0)
                {
                    gridNode.getControl(GridControl.class).changeColor(spatial, Color.Grey);
                } 
                if(countDown > 6000) spatial.getControl(BlockControl.class).setState(BlockState.idleState);
                break;
            case poisonState:
                adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                for(Spatial s: adj)
                {
                    if(s != null && s.getControl(BlockControl.class).getColor() == Color.Orange)
                    {
                        s.getControl(BlockControl.class).setState(BlockState.clearingState);
                        spatial.getControl(BlockControl.class).setState(BlockState.clearingState);
                        skip = false;
                        break;
                    }
                    else if(s != null && s.getControl(BlockControl.class).getColor() != Color.Green)
                    {
                        gridNode.getControl(GridControl.class).changeColor(s, Color.Green);
                    }
                }
                if (skip) state = BlockState.countDownState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
