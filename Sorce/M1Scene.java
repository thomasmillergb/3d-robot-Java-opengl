/*
Author: Steve Maddock
Last updated: 24 October 2013
*/

import java.io.File;
import java.awt.image.*;
import javax.imageio.*;
import com.jogamp.opengl.util.awt.*;

import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class M1Scene {
  private int frame;
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();

  private final double INC_ROTATE=2.0;

  private double rotate=0.0;
  private boolean objectsOn = true;

  private int canvaswidth=0, canvasheight=0;

  private Light light0, light1;
  private Camera camera;
 

  public M1Scene(GL2 gl, Camera camera) {
	float frame = 0.0f;
    light0 = new Light(GL2.GL_LIGHT0);  // Create a default light
	    float[] position = {0,3,4,1}; 
		light1 = new Light(GL2.GL_LIGHT1, position);
		    float[] direction = {0f,-3f,-4f};  // direction from position to origin   
			light1.makeSpotlight(direction, 10f);
    this.camera = camera;
   
  }
  
  // called from SG1.reshape() if user resizes the window
  public void setCanvasSize(int w, int h) {
    canvaswidth=w;
    canvasheight=h;
  }
  private void doLight1(GL2 gl) {     light1.use(gl, glut, false);   } 
  public void setObjectsDisplay(boolean b) {
    objectsOn = b;
  }

  public Light getLight() {
    return light0;
  }


  
  public void reset() {
    rotate=0.0;
    setObjectsDisplay(true);
  }

  public void incRotate() {
    rotate=(rotate+INC_ROTATE)%360;
  }

  public void update() {
    incRotate();
  }

  private void doLight0(GL2 gl) {
    gl.glPushMatrix();
      gl.glRotated(rotate,0,1,0);
      light0.use(gl, glut, true);
    gl.glPopMatrix();
  }
  
  public void render(GL2 gl) {
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT|GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    camera.view(glu);      // Orientate the camera
   // doLight0(gl);          // Place the default light
   // doLight1(gl);
   //frame count increase
   frame++;

	
    drawRobot(gl);
  }
  private void drawRobot(GL2 gl){
	Robot robot = new Robot(frame);
	robot.drawRobot(gl);
	
  }

	

  

}


