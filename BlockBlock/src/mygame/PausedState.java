
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;

import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;

/**
 *
 * @author kaizokuace
 */
public class PausedState extends AbstractAppState {
    
    private SimpleApplication app;
    private Node              rootNode;
    private AssetManager      assetManager;
    private AppStateManager   stateManager;
    private InputManager      inputManager;
    private ViewPort          viewPort;
    private Node              guiNode;
    private AppSettings       settings;

    public void setSettings(AppSettings s) {
        this.settings = s;
    }
    

    public PausedState() {
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app; // can cast Application to something more specific
        this.rootNode     = this.app.getRootNode();
        this.assetManager = this.app.getAssetManager();
        this.stateManager = this.app.getStateManager();
        this.inputManager = this.app.getInputManager();
        this.viewPort     = this.app.getViewPort();
        this.guiNode      = this.app.getGuiNode();
        
        setEnabled(false);
        System.out.println("PausedState Initialized");
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled){
            
            guiNode.detachAllChildren();
            Picture pic = new Picture("HUD Picture");
            pic.setImage(assetManager, "Interface/background.png", true);
            pic.setWidth(settings.getWidth()/2);
            pic.setHeight(settings.getHeight()/2);
            pic.setPosition(settings.getWidth()/4, settings.getHeight()/4);
            guiNode.attachChild(pic);
            System.out.println("PausedState enabled");
            
            //TODO: make pause menu

        
        ActionListener actionListener = new ActionListener() {
            
            public void onAction(String name, boolean keyPressed, float tpf) {
                 if ("Pause Game".equals(name) && !keyPressed) {
                     PausedState.this.stateManager.getState(PausedState.class).setEnabled(false);
                     PausedState.this.stateManager.getState(RunningState.class).setEnabled(true);
                     guiNode.detachAllChildren();
                     System.out.println("PausedState disabled");
                     inputManager.removeListener(this);
                 }
                 if ("Drop Block".equals(name) && !keyPressed) 
                 if ("Move Block Left".equals(name) && !keyPressed)   
                 if ("Move Block Right".equals(name) && !keyPressed)   
                 if ("Move Block Up".equals(name) && !keyPressed)  
                 if ("Move Block Down".equals(name) && !keyPressed){}
              }
            };
        
        inputManager.addListener(actionListener, new String[]{"Pause Game","Drop Block","Move Block Right", 
                                                            "Move Block Left", "Move Block Up", "Move Block Down"});
        
        }
        else{
        
        }
    }

    @Override
    public void update(float tpf) {
        super.update(tpf);
    }
    
}
