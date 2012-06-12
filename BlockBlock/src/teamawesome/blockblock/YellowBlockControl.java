/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package teamawesome.blockblock;

import com.jme3.math.Vector3f;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 *
 * @author kaizokuace
 */
public class YellowBlockControl extends BlockControl {
    
    public enum YellowState { liftState, rotateState, dropState, checkState};
    private YellowState YState;
    private Spatial check;
    private Vector3f V[]; 
    private Spatial[][] grid;
    private int adjCount = 0;
    private int i = 0;

    public YellowBlockControl() {
        setColor(Color.Yellow);
        setState(BlockState.cursorState);
        YState = YellowState.checkState;
        check = null;
        V = new Vector3f[8];
        //TODO: Points
    }
    
    public boolean inBound(int x, int y)
    {
        if( (x >= 0 && x < gridNode.getControl(GridControl.class).gridX) && (y >= 0 && y < gridNode.getControl(GridControl.class).gridY) )
            return true;
        return false;
    }

    @Override
    protected void controlUpdate(float tpf) {
        switch (state) {
            case rotateState:
                switch(YState)
                {
                    //TODO: Add in correct grid spot fix drop?
                    case checkState:
                        adj = gridNode.getControl(GridControl.class).getblockAdjacent(x, y);
                        grid = gridNode.getControl(GridControl.class).getGrid();
                        i = 0;
                        for(Spatial s: adj)
                        {
                            if(s != null) 
                            {
                                check = s;
                                V[i] = s.getLocalTranslation();
                                adjCount++;
                            }
                            else
                            {
                                switch(i)
                                {
                                    case 0: 
                                        if(inBound(x-1, y-1)) V[i] = ((Node)gridNode).getChild("Tile" + (x - 1) + "_" + (y - 1)).getWorldTranslation();
                                        break;
                                    case 1: 
                                        if(inBound(x-1, y)) V[i] = ((Node)gridNode).getChild("Tile" + (x - 1) + "_" + y).getWorldTranslation();
                                        break;
                                    case 2: 
                                        if(inBound(x-1, y+1)) V[i] = ((Node)gridNode).getChild("Tile" + (x - 1) + "_" + (y + 1)).getWorldTranslation();
                                        break;
                                    case 3: 
                                        if(inBound(x, y+1)) V[i] = ((Node)gridNode).getChild("Tile" + x + "_" + (y + 1)).getWorldTranslation();
                                        break;  
                                    case 4: 
                                        if(inBound(x+1, y+1)) V[i] = ((Node)gridNode).getChild("Tile" + (x + 1) + "_" + (y + 1)).getWorldTranslation();
                                        break;
                                    case 5: 
                                        if(inBound(x+1, y)) V[i] = ((Node)gridNode).getChild("Tile" + (x + 1) + "_" + y).getWorldTranslation();
                                        break;
                                    case 6: 
                                        if(inBound(x+1, y-1)) V[i] = ((Node)gridNode).getChild("Tile" + (x + 1) + "_" + (y - 1)).getWorldTranslation();
                                        break;
                                    case 7: 
                                        if(inBound(x, y-1)) V[i] = ((Node)gridNode).getChild("Tile" + x + "_" + (y - 1)).getWorldTranslation();
                                        break;    
                                }
                            }
                            i++;
                        }
                        
                        if(check == null) state = BlockState.idleState;
                        else 
                        {
                            YState = YellowState.liftState;
                            i = 0;
                        }
                        
                        break;
                    
                    case rotateState:
                        i = 1;
                        boolean dead = false;
                        for(Spatial s: adj)
                        {
                            if(s != null && V[i%8] !=null) 
                            {
                                s.setLocalTranslation(V[i%8]);
                                s.move(0f, 0f, 4f);
                                dead = false;
                            }
                            else if(s != null && V[i%8] == null)
                            {
                                s.getControl(BlockControl.class).setState(BlockState.clearingState);
                                dead = true;
                                adjCount--;
                            }
                            
                            if(!dead)
                            {
                                switch(i%8)
                                    {
                                        case 0: 
                                            if(inBound(x - 1, y - 1)) 
                                            {
                                                grid[x - 1][y - 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x - 1][y - 1].getControl(BlockControl.class).setX(x - 1);
                                                    grid[x - 1][y - 1].getControl(BlockControl.class).setY(y - 1);
                                                }
                                            }
                                            break;
                                        case 1: 
                                            if(inBound(x - 1, y))
                                            {
                                                grid[x - 1][y] = s;
                                                if(s != null)
                                                {
                                                    grid[x - 1][y].getControl(BlockControl.class).setX(x - 1);
                                                    grid[x - 1][y].getControl(BlockControl.class).setY(y);
                                                }
                                            }
                                            break;
                                        case 2: 
                                            if(inBound(x - 1, y + 1))
                                            {
                                                grid[x - 1][y + 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x - 1][y + 1].getControl(BlockControl.class).setX(x - 1);
                                                    grid[x - 1][y + 1].getControl(BlockControl.class).setY(y + 1);
                                                }
                                            }
                                            break;
                                        case 3: 
                                            if(inBound(x, y + 1)) 
                                            {
                                                grid[x][y + 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x][y + 1].getControl(BlockControl.class).setX(x);
                                                    grid[x][y + 1].getControl(BlockControl.class).setY(y + 1);
                                                }
                                            }
                                            break;  
                                        case 4: 
                                            if(inBound(x + 1, y + 1))
                                            {
                                                grid[x + 1][y + 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x + 1][y + 1].getControl(BlockControl.class).setX(x + 1);
                                                    grid[x + 1][y + 1].getControl(BlockControl.class).setY(y + 1);
                                                }
                                            }
                                            break;
                                        case 5: 
                                            if(inBound(x + 1, y))
                                            {
                                                grid[x + 1][y] = s;
                                                if(s != null)
                                                {
                                                    grid[x + 1][y].getControl(BlockControl.class).setX(x + 1);
                                                    grid[x + 1][y].getControl(BlockControl.class).setY(y);
                                                }
                                            }
                                            break;
                                        case 6: 
                                            if(inBound(x + 1, y - 1)) 
                                            {
                                                grid[x + 1][y - 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x + 1][y - 1].getControl(BlockControl.class).setX(x + 1);
                                                    grid[x + 1][y - 1].getControl(BlockControl.class).setY(y - 1);
                                                }
                                            }
                                            break;
                                        case 7: 
                                            if(inBound(x, y - 1)) 
                                            {
                                                grid[x][y - 1] = s;
                                                if(s != null)
                                                {
                                                    grid[x][y - 1].getControl(BlockControl.class).setX(x);
                                                    grid[x][y - 1].getControl(BlockControl.class).setY(y - 1);
                                                }
                                            }
                                            break;    
                                    }
                            }
                                i++;
                        }
                        YState = YellowState.dropState;
                        i = 0;
                        break;
                    
                    case dropState:
                        for(Spatial s: adj)
                        {
                            if(s != null)
                            {
                                s.move(0, 0, -.05f);
                            }
                        }
                        for(Spatial s: adj)
                        {
                            if(s != null && s.getLocalTranslation().getZ() <= 0f )
                            {
                                i++;
                            }
                        }
                        System.out.println(i + "\n\n\n\n\n\n");
                        if (i >= adjCount) state = BlockState.idleState;
                        break;
                    
                    case liftState:
                        for(Spatial s: adj)
                        {
                            if(s != null)
                            {
                                s.move(0, 0, .05f);
                            }
                        }
                        for(Spatial s: adj)
                        {
                            if(s != null && s.getLocalTranslation().getZ() >= 3f )
                            {
                                i++;
                            }
                        }
                        System.out.println(i + "\n\n\n\n\n\n");
                        if (i >= adjCount) YState = YellowState.rotateState; 
                }
                //TODO: rotate code here
                
                break;
            default:
                super.controlUpdate(tpf);
        }
    }
    
}
