/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mygame;

import com.jme3.math.Vector3f;

/**
 *
 * @author kayvanboudai
 */
public class Block {
    
    protected Vector3f position;
    //TODO: protected Mesh mesh;
    protected enum BlockState {idleState, clearingState, killState, currentState, playState, explodeState, flashingState, countDownState};
    protected BlockState state;
    protected int points;
 
    
    public Block(){}
    public void draw(){}
    public void update(){}
    public void setState(BlockState s){}
    public BlockState getState(BlockState s){return state;}
    public int getPoints(){return points;}
    public Vector3f getPosition() {return position;}
    public void setPosition(Vector3f p){};
    
    
    
}
