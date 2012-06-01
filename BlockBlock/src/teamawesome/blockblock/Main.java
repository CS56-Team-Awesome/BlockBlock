package teamawesome.blockblock;

import com.jme3.app.FlyCamAppState;
import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.math.Vector3f;
import com.jme3.post.FilterPostProcessor;
import com.jme3.post.filters.FadeFilter;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Node;
import com.jme3.system.AppSettings;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * @author Kayvan Boudai & Hasen Ahmad
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }
    
    @Override
    public void start() {
        // Get the default toolkit
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        // Get the current screen size
        Dimension scrnsize = toolkit.getScreenSize();
        
        settings = new AppSettings(true);
        settings.setResolution((int)(scrnsize.width/1.2), (int)(scrnsize.height/1.2));
        settings.setTitle("BlockBlock");
        settings.setFrameRate(60);
        //settings.setFullscreen(true); TODO: Fix full screen
        setShowSettings(false);
        setSettings(settings);
        
        super.start();
    }
    
    private FilterPostProcessor fpp;
    private FadeFilter fade;

    public FadeFilter getFade() {
        return fade;
    }

    @Override
    public void simpleInitApp() {
        
        Node blockNode = new Node("blockNode");
        rootNode.attachChild(blockNode);
        
        cam.setLocation(new Vector3f(0,0,20));
        
        stateManager.detach(stateManager.getState(FlyCamAppState.class));
        inputManager.addMapping("Exit", new KeyTrigger(KeyInput.KEY_ESCAPE));
        inputManager.addMapping("Move Block Down", new KeyTrigger(KeyInput.KEY_DOWN), new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Move Block Up", new KeyTrigger(KeyInput.KEY_UP), new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Move Block Left", new KeyTrigger(KeyInput.KEY_LEFT), new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Move Block Right", new KeyTrigger(KeyInput.KEY_RIGHT), new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Drop Block", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Pause Game", new KeyTrigger(KeyInput.KEY_P));
        
        stateManager.attach(new SplashState());
        stateManager.attach(new RunningState());
        stateManager.attach(new PausedState());
        stateManager.getState(PausedState.class).setSettings(settings);
        stateManager.getState(RunningState.class).setCam(cam);
        
        //TODO: Write code
        
        
  }

    @Override
    public void simpleUpdate(float tpf) {
        
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
