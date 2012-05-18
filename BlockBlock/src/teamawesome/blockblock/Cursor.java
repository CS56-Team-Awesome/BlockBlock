/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

/**
 *
 * @author kayvanboudai
 */
public class Cursor {
    
    private int x;
    private int y;
    
    Cursor(int x, int y) {
        this.x = x/2;
        this.y = y/2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }  
}
