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
import render.*;
import myLights.*;


import parts.robotParts.*;

public class M1Scene {
  private int frame;
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();

  private final double INC_ROTATE=2.0;

  private double rotate=0.0;
  private boolean objectsOn = true;

  private int canvaswidth=0, canvasheight=0;

  private Light light1;
  private Camera camera;
  private Mesh meshPlane, meshCylinder, meshCube; 

  private Room room;
 
  public MyLights lights;

  public M1Scene(GL2 gl, Camera camera) {
	float frame = 0.0f;

	lights = new MyLights();
	lights.drawLights(gl);
    this.camera = camera;
	room = new Room();
	room.createRenderObjects(gl);

   
  }

  
  // called from SG1.reshape() if user resizes the window
  public void setCanvasSize(int w, int h) {
    canvaswidth=w;
    canvasheight=h;
  }
 // private void doLight1(GL2 gl) {     light1.use(gl, glut, false);   } 
  public void setObjectsDisplay(boolean b) {
    objectsOn = b;
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


  
  public void render(GL2 gl) {
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT|GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    camera.view(glu);      // Orientate the camera
	frame++;
	
	
	
	
	room.drawRoom(gl);
	drawRobots(gl);
	
	lights.doLights(gl);
	
  }
  private void drawRobots(GL2 gl){
	Robot robot = new Robot(frame);

	robot.drawRobot(gl,lights,true);
	Robot robot2 = new Robot(frame+360-50);

	robot2.drawRobot(gl,lights,false);
	
  }

	

}


