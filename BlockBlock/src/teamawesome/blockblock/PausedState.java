
package teamawesome.blockblock;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;

import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.controls.ActionListener;
import com.jme3.post.Filter;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.SceneProcessor;
import com.jme3.post.filters.FadeFilter;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import com.jme3.ui.Picture;
import java.util.Iterator;
import java.util.List;

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
    private FadeFilter        fade;

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
            List<SceneProcessor> procList = viewPort.getProcessors();
            FilterPostProcessor fpp = null;
            fade = null;
            for(SceneProcessor sp : procList){
                if(sp instanceof FilterPostProcessor)
                    fpp = (FilterPostProcessor)sp;
            }
            Iterator itr = fpp.getFilterIterator();
            while(itr.hasNext()){
                 Object f = itr.next();
                 if(f instanceof FadeFilter){
                     fade = (FadeFilter)f;
                     break;
                 }
            }
            fade.fadeIn();
            
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
            float x = 0;
            float y = 0;
            
            public void onAction(String name, boolean keyPressed, float tpf) {
                 if ("Pause Game".equals(name) && !keyPressed || "Exit".equals(name) && !keyPressed) {
                     PausedState.this.stateManager.getState(RunningState.class).setEnabled(true);
                     guiNode.detachAllChildren();
                     System.out.println("PausedState disabled");
                     inputManager.removeListener(this);
                     setEnabled(false);
                     //fade.fadeOut();
                 }
                 if ("Move Block Left".equals(name) && !keyPressed){}
                 if ("Move Block Right".equals(name) && !keyPressed){}
                 if ("Move Block Up".equals(name) && !keyPressed){}   
                 if ("Move Block Down".equals(name) && !keyPressed){}
              }
            };
        
        inputManager.addListener(actionListener, new String[]{"Pause Game","Drop Block","Move Block Right", 
                                                            "Move Block Left", "Move Block Up", "Move Block Down"});
        
        }
        else{
            //TODO: Write code
        }
    }

    @Override
    public void update(float tpf) {
        super.update(tpf);
    }
    
    public void setSettings(AppSettings s) {
        this.settings = s;
    }
    
}
