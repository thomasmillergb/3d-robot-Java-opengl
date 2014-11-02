import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import parts.basicObjects.*;


public class Robot{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private Objects obs = new Objects();
  private int frame;
  
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
	public void drawRobot(GL2 gl){
	//set arms params
	
	System.out.print("haah");
	Arms leftArm = new Arms(90.0f,-90.0f,frame+16, false);
	Arms rightArm = new Arms(-90.0f,90.0f,frame, true);

		gl.glPushMatrix();
			Head rHead = new Head();
			rHead.drawRobotHead(gl);
			
			
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
		
	
	}

	
}
