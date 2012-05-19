/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class GreenBlockControl extends BlockControl {

    public GreenBlockControl() {
        setColor(Color.Green);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
                //TODO: countdown State code here and switch to appropriate state (grey state?)
                break;
            case poisonState:
                //TODO: poison code here no break above cuz poison while counting down?
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
