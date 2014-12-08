package parts.basicObjects;
/*
Author: Thomas Miller
Last updated: 7 December 2014
*/

import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;


import render.*;
//import textures 
import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

public class Objects{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private Render plane, cylinder, cube; 
  private Texture robotTex;
 public Objects() {

 
 }
 public Objects(Texture robotTex1) {
	
	 robotTex = robotTex1;
 
 }

 	public void drawspher(GL2 gl, float radius){
		if(robotTex!=null)
		{
		robotTex.enable(gl);
        robotTex.bind(gl);
        robotTex.setTexParameteri(gl, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);
		}
		
			gl.glPushMatrix();
			
		
			gl.glColor3f(0.3f, 0.5f, 1f);
			GLUquadric QUAD = glu.gluNewQuadric();
			glu.gluQuadricDrawStyle(QUAD, GLU.GLU_FILL);
			glu.gluQuadricTexture(QUAD, true);         // texture all objects drawn using this variable
			glu.gluQuadricNormals(QUAD, GLU.GLU_SMOOTH);
			
			
			
			final int SLICES = 16;
			final int STACKS = 16;
			glu.gluSphere(QUAD, radius, SLICES, STACKS);
			glu.gluDeleteQuadric(QUAD);
				
			gl.glPopMatrix();
			
			
	}

	
		
	public void drawCylinder(GL2 gl, float height, float radius){
	
	gl.glPushMatrix();	

		if(robotTex!=null)
		{
		robotTex.enable(gl);
        robotTex.bind(gl);
        robotTex.setTexParameteri(gl, GL2.GL_TEXTURE_ENV_MODE, GL2.GL_MODULATE);
		}
	
		gl.glColor3f(0.3f, 0.5f, 1f);
		GLUquadric QUAD = glu.gluNewQuadric();
		final int SLICES = 16;
		glu.gluQuadricDrawStyle(QUAD, GLU.GLU_FILL);
	    glu.gluQuadricTexture(QUAD, true);         // texture all objects drawn using this variable
	    glu.gluQuadricNormals(QUAD, GLU.GLU_SMOOTH);
		
		//quad,base,top,height,slices,stacks
		glu.gluCylinder(QUAD, radius, radius, height, SLICES, 1);
		
		gl.glPushMatrix();
		gl.glRotated(180,1,0,0);
		
		glu.gluDisk(QUAD, 0.0f, radius, SLICES, 1);
		gl.glRotated(180,1,0,0);
		gl.glTranslated(0,0,height);
		glu.gluDisk(QUAD, 0.0f, radius, SLICES, 1);
		gl.glTranslated(0,0,-height);
		gl.glPopMatrix();
		
		glu.gluDeleteQuadric(QUAD);
	gl.glPopMatrix();
	
	}
	public void drawCone(GL2 gl, float bot, float top, float height){
	gl.glPushMatrix();	
		GLUquadric quad = glu.gluNewQuadric();
		//quad,base,top,height,slices,stacks
		
		//bot = 0.25f;
		glu.gluCylinder(quad, bot, top, height, 16, 16);
		
		glu.gluDeleteQuadric(quad);
	gl.glPopMatrix();
	}
	
  

	
}