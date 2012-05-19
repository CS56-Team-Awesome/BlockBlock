/*
 * This class serves as functionality for the Grid.
 */
package teamawesome.blockblock;

import com.jme3.asset.AssetManager;
import com.jme3.export.Savable;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;
import teamawesome.blockblock.BlockControl.Color;

/**
 *
 * @author kaizokuace
 */
public class GridControl extends AbstractControl implements Savable, Cloneable {
    /*-------------------------------Fields-----------------------------------*/
    private Spatial[][] grid;
    private Cursor cursor;
    private Stack<Color> colorArray ;
    private int gridX, gridY;
    private Spatial blockNode;
    private AssetManager assetManager;
    /*-------------------------------Constructor------------------------------*/
    public GridControl(int gridX, int gridY, Cursor cursor, Stack<Color> colorArray, AssetManager assetManager, Node rootNode) {
        this.grid = new Spatial[gridX][gridY];
        this.cursor = cursor;
        this.colorArray = colorArray;
        this.gridX = gridX;
        this.gridY = gridY;
        this.blockNode = rootNode.getChild("blockNode");
        this.assetManager = assetManager;
        
        Random rand = new Random();
        
        for (int i = 0; i < 100; i++)
        {
            int j = rand.nextInt(7);
            switch (j)
            {
                case 0: 
                    colorArray.push(Color.Black);
                    break;
                case 1:
                    colorArray.push(Color.Blue);
                    break;
                case 2:
                    colorArray.push(Color.Green);
                    break;
                case 3:    
                    colorArray.push(Color.Grey);
                    break;
                case 4:
                    colorArray.push(Color.Orange);
                    break;
                case 5:
                    colorArray.push(Color.Red);
                    break;
                case 6:
                    colorArray.push(Color.Yellow);
                    break;
            }
        }
        
    }
    /*-------------------------------Gets & Sets------------------------------*/

    public Cursor getCursor() { return cursor; }

    public void setCursor(Cursor cursor) { this.cursor = cursor; }
    
    public void moveCursor(int x, int y) {
        if( !((cursor.getX()+x >= 0 && cursor.getX()+x < gridX) && (cursor.getY()+y >= 0 && cursor.getY()+y < gridY))) return;
        //TODO: Make X and Y correct so everthing else works     System.out.println("\n\n\n\n\n\n" + grid[x][y] + "\n\n\n\n\n\n");
        
        //if(grid[x][y] != null && grid[x][y].getControl(BlockControl.class).getColor() == Color.Grey) return; 
        
        ((Node)spatial).getChild("Tile" + cursor.getX() + "_" + cursor.getY()).getControl(TileControl.class).setTileState(TileControl.TileState.idleState);
        cursor.setX(cursor.getX() + x);
        cursor.setY(cursor.getY() + y);
        ((Node)spatial).getChild("Tile" + cursor.getX() + "_" + cursor.getY()).getControl(TileControl.class).setTileState(TileControl.TileState.cursorState);
        
    }

    public Spatial[][] getGrid() { return grid; }

    public void setGrid(Spatial[][] grid) { this.grid = grid; }
    
    /*-------------------------------Functions--------------------------------*/
    public ArrayList<Spatial> getAdjacent() {
        ArrayList<Spatial> adjList = new ArrayList<Spatial>();
        for(int i = cursor.getX() - 1;  i <= cursor.getX() + 1; i++) {
            for(int j = cursor.getY() - 1; j <= cursor.getY() + 1; j++) {
                if (!(i >= 0 && i < gridX) ) continue;
                if ( (!(j >= 0 && j < gridY)) || (i == cursor.getX() && j == cursor.getY())) continue;
                adjList.add(grid[i][j]);
            }
        }
        return adjList;
    }
    
    public void placeBlock() {
        System.out.println(grid[cursor.getX()][cursor.getY()]);
        if(grid[cursor.getX()][cursor.getY()] != null) return;
        Color color;
        if (!colorArray.empty()) color = colorArray.pop();
        else color = Color.Green;
        
        BlockFactory bf = new BlockFactory(blockNode, assetManager, color);
        grid[cursor.getX()][cursor.getY()] = bf.getBlock();
        bf.getBlock().setLocalTranslation(blockNode.getParent().getChild("Tile" + cursor.getX() + "_" + cursor.getY()).getWorldTranslation());
        bf.getBlock().move(0, 0, 25);
        switch (color) {
        case Red: 
            bf.getBlock().getControl(RedBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Blue: 
            bf.getBlock().getControl(BlueBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Black: 
            bf.getBlock().getControl(BlackBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Yellow: 
            bf.getBlock().getControl(YellowBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Green: 
            bf.getBlock().getControl(GreenBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Grey: 
            bf.getBlock().getControl(GreyBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Orange: 
            bf.getBlock().getControl(OrangeBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        case Rainbow: 
            bf.getBlock().getControl(RainbowBlockControl.class).setState(BlockControl.BlockState.dropState);
            break;
        }
        
        System.out.println("\n\n\n\n\n\n" + getAdjacent() + "\n\n\n\n\n\n");
    }
    
    /*-------------------------------Overrides--------------------------------*/
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
    }
    
    @Override
    protected void controlUpdate(float tpf) {
        //TODO: code here
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
