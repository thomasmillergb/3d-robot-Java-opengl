package parts.robotParts;
/*
Author: Thomas Miller
Last updated: 7 December 2014
*/

import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.basicObjects.*;

//import textures 
import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

import render.*;


public class robotObjects{


  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private Objects obs;
  
  
  private Mesh meshPlane, meshCylinder, meshCube;
  private Render plane, cylinder, cube;
  
  private Texture robotTex;
 public robotObjects() {
	obs = new Objects();
	
	
	
 }
 public robotObjects(Texture robotTex1) {

	
	 robotTex = robotTex1;
	 obs = new Objects(robotTex1);
	
 }
   
  
	public void drawEye(GL2 gl){
		gl.glPushMatrix();
			final float scale = 0.2f;
			gl.glScalef(scale, scale, scale);
			
			gl.glColor3d(0.3f, 0.5f, 1f);
			glut.glutSolidSphere(1.0f,16,16);
			
		
		gl.glPopMatrix();
		
	}
	public void drawMainHead(GL2 gl,float radius){
		obs.drawspher(gl, radius);
	
	}

	
     public void drawRobotArm(GL2 gl, float length){
	 
gl.glPushMatrix();

		obs.drawCylinder(gl, length,0.4f);
	//
   gl.glPopMatrix();
   
   }
   public void drawRobotJoint(GL2 gl){
   gl.glPushMatrix();
		obs.drawspher(gl, 0.6f);
   gl.glPopMatrix();
   }
	
	
	public void drawBaseHand(GL2 gl){
	gl.glPushMatrix();
		
		obs.drawCylinder(gl, 0.25f,0.52f);
	gl.glPopMatrix();
	
	}
}