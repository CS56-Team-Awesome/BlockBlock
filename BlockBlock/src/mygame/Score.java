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
public class Score {
    
    private long currentScore;
    private Vector3f position;
    
    public Score() {}
    public long getScore() {return currentScore;}
    //TODO: public long setScore(int numkilled) {}  // add multiplier code
    public void update() {}
    public void draw() {}
}
