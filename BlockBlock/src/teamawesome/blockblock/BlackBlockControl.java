/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class BlackBlockControl extends BlockControl {

    public BlackBlockControl() {
        setColor(Color.Black);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case explodeState:
                //TODO: explode code here then change to kill state
                break;
            case countDownState:
                //TODO: countdown code
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
