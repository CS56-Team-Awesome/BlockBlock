/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

import java.util.Random;

/**
 *
 * @author kaizokuace
 */
public class RainbowBlockControl extends BlockControl {

    public RainbowBlockControl() {
        setColor(Color.Rainbow);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rainbowState:
                //TODO: rainbow code here then switch to final color/control and set apropriate state
                Random rand = new Random();
                int r = rand.nextInt(7);
                switch (r)
                {
                    case 0:
                        color = Color.Black;
                        break;
                    case 1:
                        color = Color.Blue;
                        break;
                    case 2:
                        color = Color.Green;
                        break;
                    case 3:    
                        color = Color.Grey;
                        break;
                    case 4:
                        color = Color.Orange;
                        break;
                    case 5:
                        color = Color.Red;
                        break;
                    case 6:
                        color = Color.Yellow;
                        break;
                }
                System.out.println(color);
                state = BlockState.explodeState;
                break;
            case explodeState:
                for (int i = 0; i < gridNode.getControl(GridControl.class).gridX; i++)
                    for(int j = 0; j < gridNode.getControl(GridControl.class).gridY; j++)
                        if(gridNode.getControl(GridControl.class).getGrid()[i][j] != null && color == gridNode.getControl(GridControl.class).getGrid()[i][j].getControl(BlockControl.class).getColor())
                            gridNode.getControl(GridControl.class).getGrid()[i][j].getControl(BlockControl.class).setState(BlockState.clearingState);
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
