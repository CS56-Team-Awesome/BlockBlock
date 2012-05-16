/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class BlueBlockControl extends BlockControl {

    public BlueBlockControl() {
        setColor(Color.Blue);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case explodeState:
                //TODO: explode code here then killstate
                break;  
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
