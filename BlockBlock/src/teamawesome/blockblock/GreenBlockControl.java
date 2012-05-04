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
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case countDownState:
                //TODO: countdown State code here
                break;
            case poisonState:
                //TODO: poison code here
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
