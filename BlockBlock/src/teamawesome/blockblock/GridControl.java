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
        
        colorArray.push(Color.Black);
        colorArray.push(Color.Blue);
        colorArray.push(Color.Green);
        colorArray.push(Color.Grey);
        colorArray.push(Color.Orange);
        colorArray.push(Color.Red);
        colorArray.push(Color.Yellow);
        
        
        for(int i = 0; i < gridX; i++ ) {
            for(int j = 0; j < gridY; j++ )
                grid[i][j] = null;
        }
        
        //System.out.println("\n\n\n\n" + spatial.getParent().getName() + "\n\n\n\n");
    }
    /*-------------------------------Gets & Sets------------------------------*/

    public Cursor getCursor() { return cursor; }

    public void setCursor(Cursor cursor) { this.cursor = cursor; }
    
    public void moveCursor(int x, int y) {
        if( !((cursor.getX()+x >= 0 && cursor.getX()+x < gridX) && (cursor.getY()+y >= 0 && cursor.getY()+y < gridY))) return;
        //if(grid[x][y].getControl(BlockControl.class).getColor() == Color.Grey) return; check for colored BlockControl.class
        System.out.println("\n\n\n\n\n\n poop \n\n\n\n\n\n");
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
        for(int i = cursor.getX() - 1;  i < cursor.getX() + 1; i++) {
            for(int j = cursor.getY() - 1; i < cursor.getY() + 1; j++) {
                if (i < 0 || i > gridX - 1 ) break;
                if (j < 0 || j > gridY - 1 || (i == cursor.getX() && j == cursor.getY())) continue;
                adjList.add(grid[i][j]);
            }
        }
        return adjList;
    }
    
    public void placeBlock() {
        //if(grid[cursor.getY()][cursor.getX()] != null) return;
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
