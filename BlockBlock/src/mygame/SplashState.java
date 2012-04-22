/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author kayvanboudai
 */
public class SplashState extends AbstractAppState {
    
    public enum SplashStates {splashState, menuState};
    private SimpleApplication app;
    private Node              rootNode;
    private AssetManager      assetManager;
    private AppStateManager   stateManager;
    private InputManager      inputManager;
    private ViewPort          viewPort;
    private SplashStates state;
    

    
    public SplashState() {
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
        
        setEnabled(true);
        state = SplashStates.splashState;
        //TODO: make splash screen animation and menu
        
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled && state == SplashStates.menuState){
            
            //TODO: Write code
     
        ActionListener actionListener = new ActionListener() {
            
            public void onAction(String name, boolean keyPressed, float tpf) {
                 if ("Pause Game".equals(name) && !keyPressed){}
                 if ("Drop Block".equals(name) && !keyPressed) 
                 {
                     stateManager.getState(RunningState.class).setEnabled(true);
                     setEnabled(false);
                 }
                 if ("Move Block Left".equals(name) && !keyPressed){}
                 if ("Move Block Right".equals(name) && !keyPressed){}
                 if ("Move Block Up".equals(name) && !keyPressed){}
                 if ("Move Block Down".equals(name) && !keyPressed){}
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
        switch (state)
        {
            case splashState:
                //TODO: animation code change state to menuState
            case menuState:
                //Todo: GUI code
        }
        super.update(tpf);
    }
    
}
