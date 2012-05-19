
package teamawesome.blockblock;

import com.jme3.app.Application;
import com.jme3.app.SimpleApplication;
import com.jme3.app.state.AbstractAppState;
import com.jme3.app.state.AppStateManager;
import com.jme3.asset.AssetManager;
import com.jme3.input.InputManager;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.light.AmbientLight;
import com.jme3.math.ColorRGBA;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.BloomFilter;
import com.jme3.renderer.Camera;
import com.jme3.renderer.ViewPort;
import com.jme3.scene.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import teamawesome.blockblock.BlockControl.Color;


/**
 *
 * @author Kayvan Boudai & Hasen Ahmad
 */
public class RunningState extends AbstractAppState {
    
    private SimpleApplication app;
    private Node              rootNode;
    private AssetManager      assetManager;
    private AppStateManager   stateManager;
    private InputManager      inputManager;
    private ViewPort          viewPort;
    private Camera            cam;
    private Stack<Color> colorArray;

    
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
        this.colorArray   = new Stack<Color>();
        
        
        //make blockNode
        Node blockNode = new Node("blockNode");
        rootNode.attachChild(blockNode);
        
        setEnabled(false);
        System.out.println("RunningState Initialized");
        //viewPort.setBackgroundColor(ColorRGBA.White);
        //TODO: init real background
        //TODO: init post processing graphics
        
        //generate the grid
        GridFactory gf = new GridFactory(rootNode, assetManager, 10, 10, colorArray);
        //load a light
        AmbientLight al = new AmbientLight();
        al.setColor(ColorRGBA.White.mult(3));
        rootNode.addLight(al);
        
        //bloomeffect
//        FilterPostProcessor fpp=new FilterPostProcessor(assetManager);
//        BloomFilter bf=new BloomFilter(BloomFilter.GlowMode.Objects);
//        bf.setBloomIntensity(5.0f);
//        bf.setExposurePower(1.8f);
//        fpp.addFilter(bf);
//        viewPort.addProcessor(fpp);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if(enabled) {
            System.out.println("run enabled");           
            
            //TODO: Write code and fix mappings
     
            ActionListener actionListener = new ActionListener() {
                public void onAction(String name, boolean keyPressed, float tpf) {
                     if ("Pause Game".equals(name) && !keyPressed) {
                         RunningState.this.stateManager.getState(PausedState.class).setEnabled(true);
                         System.out.println("RunningState disabled");
                         inputManager.removeListener(this);
                         setEnabled(false);
                     }
                     if ("Drop Block".equals(name) && !keyPressed) {
                         rootNode.getChild("gridNode").getControl(GridControl.class).placeBlock();
                     }
                     if ("Move Block Left".equals(name) && !keyPressed) rootNode.getChild("gridNode").getControl(GridControl.class).moveCursor(-1, 0);
                     if ("Move Block Right".equals(name) && !keyPressed) rootNode.getChild("gridNode").getControl(GridControl.class).moveCursor(1, 0);
                     if ("Move Block Up".equals(name) && !keyPressed) rootNode.getChild("gridNode").getControl(GridControl.class).moveCursor(0, 1);
                     if ("Move Block Down".equals(name) && !keyPressed) rootNode.getChild("gridNode").getControl(GridControl.class).moveCursor(0, -1);
                     if ("Exit".equals(name) && !keyPressed) app.stop();
                }
            };
            inputManager.addListener(actionListener, new String[]{"Pause Game", "Drop Block", "Move Block Right", "Move Block Left", "Move Block Up", "Move Block Down", "Exit"});
        }
        else {
           
        }
            
    }

    @Override
    public void update(float tpf) {
        super.update(tpf);
        //TODO: add main update switch, figure out game states
    }

    void setCam(Camera cam) {
        this.cam = cam;
    }
}
