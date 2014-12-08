/*
Author: Thomas Miller
Last updated: 7 December 2014
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

//import textures 
import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

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
  public Robot robot, robot2;
  private Room room;
  public boolean robot2Enabled = true, paused = false, wireFrame = true;
  public MyLights lights;
  private GL2 gl;
  
  private Texture floorTex, roofTex, wallTex, robotTex1;

  public M1Scene(GL2 gls, Camera camera) {
	int frame = 0;
	gl = gls;
	lights = new MyLights();
	lights.drawLights(gl);
    this.camera = camera;

    loadTextures(gl);
	room = new Room();
	room.createRenderObjects(gl, wallTex,floorTex, roofTex);

  }
  private void loadTextures(GL2 gl){
		Textures load = new Textures();
		wallTex  = load.loadTexture(gl, "textures/images/brick_texture.jpg");
		floorTex = load.loadTexture(gl, "textures/images/floor.jpg");
		roofTex  = load.loadTexture(gl, "textures/images/roof.jpg");
		robotTex1 = load.loadTexture(gl, "textures/images/robot_metal1.jpg");
	
  
  }

  public void increaseLight(){
		lights.increaseLight();
  }
  public void decreaseLight(){
		lights.decreaseLight();
  }
  
  // called from SG1.reshape() if user resizes the window
  public void setCanvasSize(int w, int h) {
    canvaswidth=w;
    canvasheight=h;
  }
 // private void doLight1(GL2 gl) {     light1.use(gl, glut, false);   } 
  public void setObjectsDisplay(boolean b) {
    robot2Enabled = b;
  }

  public void wireFrame(GL2 gl){
  if(!wireFrame)
	 gl.glPolygonMode( GL2.GL_FRONT_AND_BACK, GL2.GL_LINE );
  else
	gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);
  }


  
  public void reset() {
    rotate=0.0;
	frame =0;
    setObjectsDisplay(true);
	lights.drawLights(gl);
	
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
	if(!paused)
		frame++;
	
	
	
	wireFrame(gl);

	
	drawRobots(gl);


	room.drawRoom(gl);
	boolean disco = true;
	lights.doRoomLights(gl,frame,disco);
	
  }
  private void drawRobots(GL2 gl){
	
    robot = new Robot(frame, robotTex1);
	
    

	robot.drawRobot(gl,lights,true);
	 
	
	if(robot2Enabled)
	{
		robot2 = new Robot(frame+360-50, roofTex);
		robot2.drawRobot(gl,lights,false);
	
	}
	else
	{
		lights.doEyeLight2(gl);
	
		lights.doEyeLight3(gl);
		
	}
	
  }

	

}


