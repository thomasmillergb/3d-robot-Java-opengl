package parts.robotParts;
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import parts.basicObjects.*;
public class Arms{
  
  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private robotObjects rObs = new robotObjects();
  private float armAngleY,armAngleX,armAngleZ;
  private Objects obs = new Objects();
  private float initArmAngleX,initArmAngleY;
  private int frame;
  private boolean right;
 public Arms() {
	armAngleZ = 0.0f;
	armAngleY = 0.0f;
	armAngleX = 0.0f;
	initArmAngleY = 0.0f;
	initArmAngleX = 0.0f;
 }
  public Arms(float initAngle, float arm, int frames) {
  
	initArmAngleY = initAngle;
	armAngleY = arm;
	frame = frames;
	
	
 }
  public Arms(float initAngle,float initAngleX, float arm, int frames, boolean right) {
	initArmAngleY = initAngle;
	initArmAngleX = initAngleX;
	armAngleY = arm;
	frame = frames;
	this.right = right;
	
	
 }
  public void drawArm(GL2 gl){
	gl.glPushMatrix();
	gl.glRotated(initArmAngleY,0,1,0);
	gl.glRotated(initArmAngleX,1,0,0);
	rObs.drawRobotJoint(gl);
	rObs.drawRobotArm(gl, 2);
	//far part of arm
	gl.glPushMatrix();
    gl.glTranslated(0,0,2);
						gl.glPushMatrix();
							//gl.glRotated(armAngleX,1,0,0);
							
							gl.glPushMatrix();
							
							
							gl.glRotated(armAngleY,0,1,0);
							gl.glRotated(armAngleX,1,0,0);
							
							
							rObs.drawRobotArm(gl, 3);
							rObs.drawRobotJoint(gl);
							gl.glTranslated(0,0,3);
							gl.glPushMatrix();
							if(right)
								gl.glRotated(frame*-1,0,0,1);
							else
								gl.glRotated(frame,0,0,1);
							
							rObs.drawBaseHand(gl);
							
							
							gl.glPushMatrix();
							gl.glTranslated(0,0,0.15f);
							//draw claws
							Claw claw = new Claw();
							
							
							claw.drawClaws(gl,10,frame);
							gl.glPopMatrix();
							gl.glPopMatrix();
						gl.glPopMatrix();
							gl.glPopMatrix();
					
					
						
						
				gl.glPopMatrix();
	gl.glPopMatrix();
	
	
  }

 public void changeArmAngleZ(float angle){
	armAngleZ =+  angle;
  
  }

  public void changeArmAngleY(float angle){
	armAngleY =+  angle;
  
  }
  public void changeArmAngleX(float angle){
	armAngleX =+  angle;
  
  }
  public void changeInitArmAngle(float angle){
    initArmAngleY = initArmAngleY + angle;
  
  }

 
}