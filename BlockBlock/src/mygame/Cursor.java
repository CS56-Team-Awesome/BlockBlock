/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;

/**
 *
 * @author kaizokuace
 */
public class Cursor {
    Vector3f position;
    //TODO: Mesh mesh;
    public enum CursorState {Red, Blue, Black, Yellow, Green, Grey, Orange};
    private CursorState state;

    public Cursor() {
        position = new Vector3f(0,0,0);
    }
    
    public CursorState getState() {
        return state;
    }

    public void setState(CursorState state) {
        this.state = state;
    }

    public Vector3f getPosition() {
        return position;
    }

    public void setPosition(Vector3f position) {
        this.position = position;
    }
    public void draw() {
        
    }
    
}
