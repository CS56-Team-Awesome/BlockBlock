/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

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
                state = BlockState.killState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
