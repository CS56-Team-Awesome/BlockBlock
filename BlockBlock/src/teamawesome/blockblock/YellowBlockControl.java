/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

import com.jme3.math.Vector3f;
import com.jme3.scene.Spatial;

/**
 *
 * @author kaizokuace
 */
public class YellowBlockControl extends BlockControl {
    
    public enum YellowState { liftState, rotateState, dropState, checkState};
    private YellowState YState;
    private Spatial check;
    private Vector3f V[]; 

    public YellowBlockControl() {
        setColor(Color.Yellow);
        setState(BlockState.cursorState);
        YState = YellowState.checkState;
        check = null;
        V = new Vector3f[8];
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rotateState:
                switch(YState)
                {
                    case checkState:
                        adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                        int i = 0;
                        for(Spatial s: adj)
                        {
                            if(s != null) 
                            {
                                check = s;
                                V[i++] = s.getLocalTranslation();
                            }
                            else
                            {
                                V[i++] = null;
                            }
                        }
                        
                        if(check == null) state = BlockState.idleState;
                        else YState = YellowState.liftState;
                        
                        break;
                    case rotateState:
//                        i = 1;
//                        for(Spatial s: adj)
//                        {
//                            if(s != null && V[i%8] != null) 
//                            {
//                                s.setLocalTranslation(V[i%8]);
//                                i++;
//                            }
//                            else
//                            {
//                                i++;
//                            }
//                        }
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
                        
                        if(check != null && check.getLocalTranslation().getZ() <= .5f) state = BlockState.idleState;;
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
