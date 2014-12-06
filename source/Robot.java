import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import parts.basicObjects.*;
import myLights.*;
import java.lang.*;
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

	Arms leftArm = new Arms(90.0f,0.0f,-90.0f,frame+16, false);
	Arms rightArm = new Arms(-90.0f,0.0f,90.0f,frame, true);

		Head rHead = new Head(robot0);
		rHead.drawRobotHead(gl, lights);
		
		//draw left arm
		gl.glPushMatrix();
			if(frame < 360)
				waveHand(gl, leftArm);
			else
				armAnimation(gl, leftArm);
			gl.glTranslated(2,0,0);
			
			leftArm.drawArm(gl);
		gl.glPopMatrix();
		
		
			//draw right arm
			gl.glPushMatrix();
			
				
				if(frame > 270)
					armAnimation(gl, rightArm);
				gl.glTranslated(-2,0,0);
				rightArm.drawArm(gl);
				
			gl.glPopMatrix();
	
	gl.glPopMatrix();

		
	
	}
	public float[] getPosition(){
		return robotPosition;
	
	}
	private void animateRobot(GL2 gl){
	
	
		
		float move, bank;
		

		final float scale = 0.35f;
		if(frame<360){
		startMove(gl);
		//int i;
		}
		else{
			if(360<=frame%720 && frame%720 <=720)
			{
				move = fancyFlight(frame);
				bank = fancyFlight(frame+180);
			}
			else
			{
				move = animateNormFlight(frame);
				bank = animateNormFlight(frame+180)*2;
			}	
			gl.glTranslated(0.0f,move,0.0f);
			gl.glRotated((frame*1.0f)+90,0.0f,1.0f,0.0f);
			gl.glTranslated(0.0f,0.0f,-8.0f);
			gl.glRotated(bank*2.5f,0,0,1);
			if(90<frame%270)
				gl.glRotated(frame*4,1,0,0);
	
		}

		gl.glScalef(scale, scale, scale);
		gl.glRotated(-90,0.0f,1.0f,0.0f);

	
	}

	private float animateNormFlight(int frame){
		//System.out.println(frame);
		double ani1 = Math.toRadians(frame%360);
		//System.out.println(ani1);
	    float flight = (float)Math.sin(ani1*4);
	
		return flight;
	}
	private float fancyFlight(int frame){
	
		double ani1 = Math.toRadians(frame%360);
		
	    float flight = 3*(float)Math.sin(ani1);
	
		return 2.0f*flight;
	
	}

	private void startMove(GL2 gl){
			if(frame<240)
		{
			float moves = -1*frame /30.0f;
			gl.glTranslated(moves,0.0f,0.0f);
		
		}
		else if(frame<330){
		
			gl.glTranslated(-8.0f,0.0f,0.0f);
			gl.glRotated(frame-240,0.0f,1.0f,0.0f);
		}
		else{
			gl.glTranslated(-8.0f,0.0f,0.0f);
			gl.glRotated(90.0f,0.0f,1.0f,0.0f);
		}
	
	}
	private void armAnimation(GL2 gl, Arms arm){
	 if(90<frame%360){
	 //OpenArm
		
		if(arm.getRight())
			{
				
			if(135>frame%360){
				arm.changeArmAngleY(-2*(frame+45));
				arm.changeArmAngleX(0);
			}
			else if(200>frame%360){
				arm.changeArmAngleY(0);
				arm.changeArmAngleX(0);
			}
			else if(290>frame%360){
				arm.changeArmAngleY((frame)-200);
				arm.changeArmAngleX(0);
			}
			}
		else
			{
				
			if(135>frame%360){
				arm.changeArmAngleY(2*(frame+45));
				arm.changeArmAngleX(0);
			}
			else if(200>frame%360){
				arm.changeArmAngleY(0);
				arm.changeArmAngleX(0);
			}
			else if(290>frame%360){
				arm.changeArmAngleY((frame*-1)-160);
				arm.changeArmAngleX(0);
			}
			}
	 }
	}
	private void waveHand(GL gl, Arms arm){
	  if(frame <90){
		arm.changeArmAngleX(-1*frame);
	  }
	  else if (frame <190)
	  {
		float speed = 100.0f;
		float ani1 = frame%(360*speed);
		float angleX= 10*(float)Math.sin(ani1/2);
		if(angleX >0.1 && angleX >-0.1)
			System.out.println(frame);
		arm.changeArmAngleX(angleX-90);
		arm.changeArmAngleY(0);
	
	  }
	  else if (frame <190+90)
		arm.changeArmAngleX(frame-280);
		//arm.changeArmAngleY(0);
	
	}


	
}
