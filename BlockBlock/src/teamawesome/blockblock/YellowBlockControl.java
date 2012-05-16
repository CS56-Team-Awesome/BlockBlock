/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class YellowBlockControl extends BlockControl {

    public YellowBlockControl() {
        setColor(Color.Black);
        setState(BlockState.cursorState);
        //TODO: Points
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
