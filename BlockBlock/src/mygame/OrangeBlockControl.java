/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author kaizokuace
 */
public class OrangeBlockControl extends BlockControl {

    public OrangeBlockControl() {
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case antidoteState:
                //TODO: antidote code here
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
