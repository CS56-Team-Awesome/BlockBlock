/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author kaizokuace
 */
public class BlueBlockControl extends BlockControl {

    public BlueBlockControl() {
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case clearingState:
                //TODO: clearing code here
                break;
            case explodeState:
                //TODO: explode code here
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
