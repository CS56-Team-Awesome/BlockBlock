/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

/**
 *
 * @author kaizokuace
 */
public class YellowBlockControl extends BlockControl {

    public YellowBlockControl() {
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rotateState:
                //TODO: rotate code here
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
