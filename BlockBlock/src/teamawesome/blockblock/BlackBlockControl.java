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
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case explodeState:
                //TODO: explode code here
                break;
            case countDownState:
                //TODO: countdown code
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
