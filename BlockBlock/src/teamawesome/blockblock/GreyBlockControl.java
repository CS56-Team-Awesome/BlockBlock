/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class GreyBlockControl extends BlockControl {

    public GreyBlockControl() {
        setColor(Color.Grey);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        super.controlUpdate(tpf);
    }
    
}
