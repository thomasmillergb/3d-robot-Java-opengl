import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import parts.basicObjects.*;
import myLights.*;

public class Robot{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private Objects obs = new Objects();
  private int frame;
  private float[] robotPosition;
  public Robot() {
	frame = 0;
  }
  public Robot(int frames) {
	frame = frames;
  }
  
  //I have tried to keep my code as clean as possible to allow me to easy manipulate parts of the robots. 
  //This allows me  to create loads of independent robots very easy.

/*
  the hiracky is:
  head
lower left arm /  right arm  / eyes / light on top of head
upper left arm /  right arm 
 
left claw	  /	 right claw 
  
  
*/
	public void drawRobot(GL2 gl, MyLights lights,boolean robot0){

	//set arms params

	gl.glPushMatrix();
	animateRobot(gl);
	

	//set arms 

	Arms leftArm = new Arms(90.0f,-90.0f,frame+16, false);
	Arms rightArm = new Arms(-90.0f,90.0f,frame, true);

		gl.glPushMatrix();
			Head rHead = new Head(robot0);
			rHead.drawRobotHead(gl, lights);
			
			
			//draw left arm
			gl.glPushMatrix();
				//gl.glRotated(frame,0,1,0);
				//leftArm.changeArmAngle(frame);
				//leftArm.changeInitArmAngle(frame);
				gl.glTranslated(2,0,0);
				leftArm.drawArm(gl);
				
				//gl.glPushMatrix();
				
				
			gl.glPopMatrix();
			
			
			//draw right arm
			gl.glPushMatrix();
				
				gl.glTranslated(-2,0,0);
				rightArm.drawArm(gl);
			gl.glPopMatrix();
		
		gl.glPopMatrix();
	gl.glPopMatrix();
		
	
	}
	public float[] getPosition(){
		return robotPosition;
	
	}
	private void animateRobot(GL2 gl){
	
		float move = animateFlight(frame);
		
		gl.glTranslated(0.0f,move/10,0.0f);

		
		gl.glRotated(frame*0.75f,0.0f,1.0f,0.0f);
		final float scale = 0.45f;
		gl.glTranslated(0.0f,0.0f,-8.0f);
		gl.glScalef(scale, scale, scale);
		gl.glRotated(-90,0.0f,1.0f,0.0f);
		
		move = animateFlight(frame+40);
		gl.glRotated((move/2)*-1,1.0f,0.0f,0.0f);
		
	
	}
    private float animateFlight(int frame){
  
 
		float ani1 = (frame*0.25f)%40;
		float ani2 = (frame*0.25f)%80;
		if(ani2<40)
		
		return ani2-25;
		else
		return 15-ani1;
	}

	
}
