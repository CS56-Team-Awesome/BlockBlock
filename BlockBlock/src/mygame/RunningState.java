
package mygame;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.math.ColorRGBA;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;


/**
 *
 * @author kaizokuace
 */
public class RunningState extends AbstractAppState {
    
    private SimpleApplication app;
    private Node              rootNode;
    private AssetManager      assetManager;
    private AppStateManager   stateManager;
    private InputManager      inputManager;
    private ViewPort          viewPort;

    
    public RunningState() {
    }
    
    @Override
    public void cleanup() {
        super.cleanup();
    }

    @Override
    public void initialize(AppStateManager stateManager, Application app) {
        super.initialize(stateManager, app);
        this.app = (SimpleApplication) app; 
        this.rootNode     = this.app.getRootNode();
        this.assetManager = this.app.getAssetManager();
        this.stateManager = this.app.getStateManager();
        this.inputManager = this.app.getInputManager();
        this.viewPort     = this.app.getViewPort();
        
        stateManager.getState(RunningState.class).setEnabled(true);
        System.out.println("RunningState Initialized");
        viewPort.setBackgroundColor(ColorRGBA.White);
        
        Node blockNode = new Node("blockNode");
        rootNode.attachChild(blockNode);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled){
     
        ActionListener actionListener = new ActionListener() {
            float x = 0;
            float y = 0;
            int i = 0;
            
            public void onAction(String name, boolean keyPressed, float tpf) {
                 if ("Pause Game".equals(name) && !keyPressed) {
                     RunningState.this.stateManager.getState(PausedState.class).setEnabled(true);
                     RunningState.this.stateManager.getState(RunningState.class).setEnabled(false);
                     System.out.println("RunningState disabled");
                     //rootNode.getChild("A Textured Box").setCullHint(CullHint.Always);
                     inputManager.removeListener(this);
                     
                 }
                 if ("Drop Block".equals(name) && !keyPressed)
                 if ("Move Block Left".equals(name) && !keyPressed)   rootNode.getChild("blockNode").setLocalTranslation(x -= 2.5, y, 0);
                 if ("Move Block Right".equals(name) && !keyPressed)   rootNode.getChild("blockNode").setLocalTranslation(x += 2.5, y, 0);
                 if ("Move Block Up".equals(name) && !keyPressed)   rootNode.getChild("blockNode").setLocalTranslation(x, y += 2.5, 0);
                 if ("Move Block Down".equals(name) && !keyPressed)   rootNode.getChild("blockNode").setLocalTranslation(x, y -= 2.5, 0);
                 if ("Exit".equals(name) && !keyPressed) app.stop();
            }
        };
        
        inputManager.addListener(actionListener, new String[]{"Pause Game","Drop Block","Move Block Right", 
                                                            "Move Block Left", "Move Block Up", "Move Block Down", "Exit"});
        }
        else{
           
        }
            
    }

    @Override
    public void update(float tpf) {
        super.update(tpf);
    }
    
}
