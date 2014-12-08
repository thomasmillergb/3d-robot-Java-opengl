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
import parts.robotParts.*;
import myLights.*;

import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

public class Head{
  
  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private robotObjects rObs ;
  private Texture robotTex;
  private boolean robot0;
 public Head(boolean robot0) {
    rObs = new robotObjects();
	this.robot0 = robot0;
 }
 public Head(boolean robot0, Texture robotTex1 ) {
	 robotTex = robotTex1;
	this.robot0 = robot0;
	rObs = new robotObjects(robotTex1);
 }


   public void drawRobotHead(GL2 gl, MyLights lights){
   gl.glPushMatrix();
		final float radius = 2;
	
		
		rObs.drawMainHead(gl, radius);
		//siran light/
		
		gl.glPushMatrix();
			gl.glTranslated(0,2,0);
			gl.glColor3d(0.3f, 0.5f, 1f);
			rObs.drawEye(gl);

		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			
			rObs.drawEye(gl);
			
			gl.glPushMatrix();
			if(!robot0)
		
			
				lights.doEyeLight(gl);
			
			else
				lights.doEyeLight2(gl);
				
			gl.glPopMatrix();
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(-20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			rObs.drawEye(gl);
			gl.glPushMatrix();
			
			if(robot0)
				lights.doEyeLight1(gl);
			else
				lights.doEyeLight3(gl);
				
			
			gl.glPopMatrix();
			
		gl.glPopMatrix();
		
		
		
	gl.glPopMatrix();
   }
   /*
	  private void doEyeLight(GL2 gl) {
	 gl.glPushMatrix();
      eyeLight0.use(gl, glut, false);
	 gl.glPopMatrix();
  }

  private void doEyeLight1(GL2 gl) {

      eyeLight1.use(gl, glut, false);
 
  }
  
    private void doEyeLight2(GL2 gl) {
      eyeLight2.use(gl, glut, false);
  }

  private void doEyeLight3(GL2 gl) {

      eyeLight3.use(gl, glut, false);
 
  }
	*/
  
 
}