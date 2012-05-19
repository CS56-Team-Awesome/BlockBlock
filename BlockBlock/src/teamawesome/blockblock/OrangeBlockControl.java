/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kaizokuace
 */
public class OrangeBlockControl extends BlockControl {

    public OrangeBlockControl() {
        setColor(Color.Orange);
        setState(BlockState.cursorState);
        //TODO: Points
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case antidoteState:
                //TODO: antidote code here
                state = BlockState.clearingState;
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
