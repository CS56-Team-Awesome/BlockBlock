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
public class YellowBlockControl extends BlockControl {
    
    public enum YellowState { liftState, rotateState, dropState, checkState};
    private YellowState YState;
    private Spatial check;

    public YellowBlockControl() {
        setColor(Color.Yellow);
        setState(BlockState.cursorState);
        YState = YellowState.checkState;
        check = null;
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rotateState:
                switch(YState)
                {
                    case checkState:
                        adj = gridNode.getControl(GridControl.class).getAdjacent();
                        for(Spatial s: adj)
                        {
                            if(s != null) check = s;
                        }
                        
                        if(check == null) state = BlockState.idleState;
                        else YState = YellowState.liftState;
                        
                        break;
                    case rotateState:
                        YState = YellowState.dropState;
                        break;
                    case dropState:
                        for(Spatial s: adj)
                        {
                            if(s != null)
                            {
                                s.move(0, 0, -.2f);
                                check = s;
                            }
                        }
                        
                        if(check != null && check.getLocalTranslation().getZ() <= 0) state = BlockState.idleState;;
                        break;
                    case liftState:
                        for(Spatial s: adj)
                        {
                            if(s != null)
                            {
                                s.move(0, 0, .2f);
                                check = s;
                            }
                        }
                        
                        if(check != null && check.getLocalTranslation().getZ() >= 4f) YState = YellowState.rotateState;
                }
                //TODO: rotate code here
                
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
