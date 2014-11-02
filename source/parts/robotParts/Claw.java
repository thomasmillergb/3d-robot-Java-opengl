package parts.robotParts;
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import parts.robotParts.*;
import parts.basicObjects.*;
//import basicObjects.*;
public class Claw{
  
  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private robotObjects rObs = new robotObjects();
   private Objects obs = new Objects();
  private float angle;
  
 public Claw() {
	angle = 0.0f;

 }

      public void drawClaws(GL2 gl, int amount, int frame){
	int ainimate = animateClaws(frame);
	for(int i = 0; i<= amount; i++){
	gl.glRotated(360/amount,0,0,1);
		gl.glPushMatrix();
			gl.glTranslated(0.0f,0.25f,0.0f);
			gl.glRotated(ainimate,1,0,0);
			drawClaw(gl);
		gl.glPopMatrix();
	}
	
  }
    public void drawClaws(GL2 gl, int amount){
	for(int i = 0; i<= amount; i++){
	gl.glRotated(360/amount,0,0,1);
		gl.glPushMatrix();
			gl.glTranslated(0.0f,0.25f,0.0f);
			drawClaw(gl);
		gl.glPopMatrix();
	}
	
  }
  	public void drawClaw(GL2 gl){
		//base,top,height,slices,stacks
	 
		gl.glPushMatrix();
			float bot = 0.20f;
			
			obs.drawCone(gl, bot,0.0f,1.0f);
				//public void drawCone(GL2 gl, float bot, float top, float height){
		gl.glPopMatrix();
	}
  private int animateClaws(int frame){
  
 
  int ani1 = (int)(frame*2.5f)%40;
  int ani2 = (int)(frame*2.5f)%80;
  if(ani2<40)
	return ani2-25;
  else
	return 15-ani1;
  }
  
  public void changeAngle(float angle){
		angle = getAngle() + angle;
  
  }
  
  public float getAngle(){
	return angle;
  }
 
}