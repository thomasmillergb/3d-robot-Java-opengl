import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import robotParts.*;

public class Robot{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  public Robot() {
  
  }
	public void drawRobot(GL2 gl){
		gl.glPushMatrix();
			drawRobotHead(gl);
			//draw left arm
		
		
			gl.glPushMatrix();
				gl.glTranslated(2,0,0);
				drawLeftArm(gl);
			gl.glPopMatrix();
			
			
			//draw right arm
			gl.glPushMatrix();
				gl.glTranslated(-2,0,0);
				drawRightArm(gl);
			gl.glPopMatrix();
			
		gl.glPopMatrix();
		
	
	}
   private void drawRightArm(GL2 gl){
	gl.glPushMatrix();
	gl.glRotated(-90,0,1,0);
	drawRobotJoint(gl);
	
	drawRobotArm(gl, 2);
	//far part of arm
	gl.glPushMatrix();
				
						gl.glTranslated(0,0,2);
						gl.glPushMatrix();
							gl.glRotated(90,0,1,0);
							drawRobotArm(gl, 3);
							drawRobotJoint(gl);
							gl.glTranslated(0,0,3);
							gl.glPushMatrix();
							glut.glutSolidCylinder(0.5f,0.25f,16,16);
							gl.glPopMatrix();
						gl.glPopMatrix();
						
						
				gl.glPopMatrix();
	gl.glPopMatrix();
  
   }
      private void drawLeftArm(GL2 gl){
	gl.glPushMatrix();
	gl.glRotated(90,0,1,0);
	drawRobotJoint(gl);
	drawRobotArm(gl, 2);
	//far part of arm
	gl.glPushMatrix();
    gl.glTranslated(0,0,2);
						gl.glPushMatrix();
							gl.glRotated(-90,0,1,0);
							drawRobotArm(gl, 3);
							drawRobotJoint(gl);
							gl.glTranslated(0,0,3);
							gl.glPushMatrix();
							glut.glutSolidCylinder(0.5f,0.25f,16,16);
							gl.glPopMatrix();
							
							//draw claws
							Claw claw = new Claw();
							claw.drawClaw();
						gl.glPopMatrix();
						
						
				gl.glPopMatrix();
	gl.glPopMatrix();
  
   }
   private void drawRobotArm(GL2 gl, float length){
   gl.glPushMatrix();
		drawCylinder(gl, length,0.4f);
   gl.glPopMatrix();
   }
   private void drawRobotJoint(GL2 gl){
   gl.glPushMatrix();
		drawspher(gl, 0.5f);
   gl.glPopMatrix();
   }
   
  
   private void drawRobotHead(GL2 gl){
   gl.glPushMatrix();
		final float radius = 2;
	
		
			
		
		drawspher(gl, radius);
		//siran light
		
		gl.glPushMatrix();
			gl.glTranslated(0,2,0);
			drawEye(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			drawEye(gl);
		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(-20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			drawEye(gl);
		gl.glPopMatrix();
		
	gl.glPopMatrix();
   }
	private void drawEye(GL2 gl){
		gl.glPushMatrix();
			final float scale = 0.2f;
			gl.glScalef(scale, scale, scale);
			drawspher(gl, 1.0f);
		gl.glPopMatrix();
	}
  
	private void drawspher(GL2 gl, float radius){
		
			gl.glPushMatrix();
			
			// Draw sphere (possible styles: FILL, LINE, POINT).
			gl.glColor3f(0.3f, 0.5f, 1f);
			GLUquadric quad = glu.gluNewQuadric();
			
			
			glu.gluQuadricDrawStyle(quad, GLU.GLU_LINE);
			glu.gluQuadricNormals(quad, GLU.GLU_FLAT);
			glu.gluQuadricOrientation(quad, GLU.GLU_OUTSIDE);
			glu.gluQuadricDrawStyle(quad, GLU.GLU_FILL);
			
			final int slices = 16;
			final int stacks = 16;
			glu.gluSphere(quad, radius, slices, stacks);
			glu.gluDeleteQuadric(quad);
				
			gl.glPopMatrix();
	}
	private void drawCylinder(GL2 gl, float height, float radius){
	gl.glPushMatrix();	
		GLUquadric quad = glu.gluNewQuadric();
		//quad,base,top,height,slices,stacks
		glu.gluCylinder(quad, radius, radius, height, 16, 16);
		
		glu.gluDeleteQuadric(quad);
	gl.glPopMatrix();
	}
	
}
