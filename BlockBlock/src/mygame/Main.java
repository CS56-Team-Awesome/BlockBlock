package mygame;

import com.jme3.app.SimpleApplication;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.ActionListener;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;

/**
 * test
 * @author Hasen Ahmad
 */
public class Main extends SimpleApplication {

    public static void main(String[] args) {
        Main app = new Main();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        Box b = new Box(Vector3f.ZERO, 1, 1, 1);
        final Geometry geom = new Geometry("Box", b);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        mat.setColor("Color", ColorRGBA.Blue);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
        
        
        cam.setLocation(new Vector3f(0,0,50));
        
        inputManager.clearMappings();
        
        inputManager.addMapping("Exit", new KeyTrigger(KeyInput.KEY_ESCAPE));
        inputManager.addMapping("Move Block Down", new KeyTrigger(KeyInput.KEY_DOWN), new KeyTrigger(KeyInput.KEY_S));
        inputManager.addMapping("Move Block Up", new KeyTrigger(KeyInput.KEY_UP), new KeyTrigger(KeyInput.KEY_W));
        inputManager.addMapping("Move Block Left", new KeyTrigger(KeyInput.KEY_LEFT), new KeyTrigger(KeyInput.KEY_A));
        inputManager.addMapping("Move Block Right", new KeyTrigger(KeyInput.KEY_RIGHT), new KeyTrigger(KeyInput.KEY_D));
        inputManager.addMapping("Drop Block", new KeyTrigger(KeyInput.KEY_SPACE));
        inputManager.addMapping("Pause Game", new KeyTrigger(KeyInput.KEY_P));
        
        
        ActionListener actionListener = new ActionListener() {
            float x = 0;
            float y = 0;
            public void onAction(String name, boolean keyPressed, float tpf) {
     if ("Pause Game".equals(name) && !keyPressed) System.out.println("Pause pushed");
     if ("Drop Block".equals(name) && !keyPressed) System.out.println("Drop pushed");
     if ("Exit".equals(name) && !keyPressed) stop();
     if ("Move Block Left".equals(name) && !keyPressed) geom.setLocalTranslation(x -= 2.5, y, 0);
     if ("Move Block Right".equals(name) && !keyPressed) geom.setLocalTranslation(x += 2.5, y, 0);
     if ("Move Block Up".equals(name) && !keyPressed) geom.setLocalTranslation(x, y += 2.5, 0);
     if ("Move Block Down".equals(name) && !keyPressed) geom.setLocalTranslation(x, y -= 2.5, 0);
  }
};
        
        inputManager.addListener(actionListener, new String[]{"Pause Game","Drop Block", "Exit","Move Block Right", 
                                                              "Move Block Left", "Move Block Up", "Move Block Down"});
    }

    @Override
    public void simpleUpdate(float tpf) {
       
    }

    @Override
    public void simpleRender(RenderManager rm) {
        //TODO: add render code
    }
}
