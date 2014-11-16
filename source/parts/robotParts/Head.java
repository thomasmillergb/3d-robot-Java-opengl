package parts.robotParts;
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import myLights.*;

public class Head{
  
  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private robotObjects rObs = new robotObjects();
  
  private boolean robot0;
 public Head(boolean robot0) {
 
	this.robot0 = robot0;
 }

   public void drawRobotHead(GL2 gl, MyLights lights){
   gl.glPushMatrix();
		final float radius = 2;
	
		
		rObs.drawMainHead(gl, radius);
		//siran light
		
		gl.glPushMatrix();
			gl.glTranslated(0,2,0);
			rObs.drawEye(gl);

		gl.glPopMatrix();
		
		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			rObs.drawEye(gl);
			if(robot0)
				lights.doEyeLight(gl);
			else
				lights.doEyeLight2(gl);
		gl.glPopMatrix();

		gl.glPushMatrix();
			gl.glRotated(-30,1.0f,0.0f,0.0f);
			gl.glRotated(-20,0.0f,1.0f,0.0f);
			gl.glTranslated(0,0,2);
			rObs.drawEye(gl);
			if(robot0)
				lights.doEyeLight1(gl);
			else
				lights.doEyeLight3(gl);
			
		gl.glPopMatrix();
		
	gl.glPopMatrix();
   }
	
	
  
 
}