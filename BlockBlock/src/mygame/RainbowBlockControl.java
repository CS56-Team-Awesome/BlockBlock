/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author kaizokuace
 */
public class RainbowBlockControl extends BlockControl {

    public RainbowBlockControl() {
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rainbowState:
                //TODO: rainbow code here
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
