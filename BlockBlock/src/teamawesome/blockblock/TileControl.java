/*
 * This class serves as functionality for the Grid Tiles.
 */
package teamawesome.blockblock;

import com.jme3.asset.AssetManager;
import com.jme3.export.Savable;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.RenderManager;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Spatial;
import com.jme3.scene.control.AbstractControl;
import com.jme3.scene.control.Control;
import javax.media.jai.TileScheduler;

/**
 *
 * @author kaizokuace
 */
public class TileControl extends AbstractControl implements Savable, Cloneable {
    
    /*-------------------------------Fields-----------------------------------*/
    public enum TileState {idleState, cursorState};
    private TileState tileState;
    private TileState previousState;
    private AssetManager assetManager;
    private Material mat;
    
    /*-------------------------------Constructor------------------------------*/
    public TileControl(AssetManager assetManager) {
        this.tileState = TileState.idleState;
        this.previousState = TileState.idleState;
        this.assetManager = assetManager;
    }
    
    /*-------------------------------Gets & Sets------------------------------*/
    public TileState getTileState() {
        return tileState;
    }

    public void setTileState(TileState tileState) {
        this.tileState = tileState;
    }
    
    /*-------------------------------Overrides--------------------------------*/
    @Override
    public void setSpatial(Spatial spatial) {
        super.setSpatial(spatial);
    }
    
    @Override
    protected void controlUpdate(float tpf) {
        switch(tileState) {
            case cursorState:
                if(previousState != TileState.cursorState) {
                    mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                    mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/tile_texture2.png"));
                    mat.setTexture("GlowMap", assetManager.loadTexture("Textures/tile_texture2.png"));
                    spatial.setMaterial(mat);
                }
                previousState = tileState;
                break;
            case idleState:
                if(previousState != TileState.idleState) {
                    mat = new Material(assetManager, "Common/MatDefs/Light/Lighting.j3md");
                    //mat.setBoolean("UseMaterialColors",true); 
                    mat.clearParam("GlowMap");
                    mat.setTexture("DiffuseMap", assetManager.loadTexture("Textures/tile_texture2.png"));
                    //mat.setTexture("GlowMap", assetManager.loadTexture("Textures/tile_blue_alpha.png"));
                    spatial.setMaterial(mat);
                }
                previousState = tileState;
                //TODO: change to glow 
                break;
        }
    }

    @Override
    protected void controlRender(RenderManager rm, ViewPort vp) {
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public Control cloneForSpatial(Spatial spatial) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
