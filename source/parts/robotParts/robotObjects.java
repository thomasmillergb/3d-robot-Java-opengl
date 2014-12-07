package parts.robotParts;
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

public class robotObjects{
  
  private GLU glu = new GLU();
  private GLUT glut = new GLUT(); 
  private Objects obs = new Objects();
 public robotObjects() {
	
 }

   
  
	public void drawEye(GL2 gl){
		gl.glPushMatrix();
			final float scale = 0.2f;
			gl.glScalef(scale, scale, scale);
			obs.drawspher(gl, 1.0f);
		gl.glPopMatrix();
	}
	public void drawMainHead(GL2 gl,float radius){
		obs.drawspher(gl, radius);
	
	}
	
     public void drawRobotArm(GL2 gl, float length){
	 Textures load = new Textures();
     Texture robotTex= load.loadTexture(gl, "textures/brick_texture.jpg");
	 
   gl.glPushMatrix();
		obs.drawCylinder(gl, length,0.4f, robotTex);
   gl.glPopMatrix();
   }
   public void drawRobotJoint(GL2 gl){
   gl.glPushMatrix();
		obs.drawspher(gl, 0.5f);
   gl.glPopMatrix();
   }
	
	
	public void drawBaseHand(GL2 gl){
	gl.glPushMatrix();
		
		obs.drawCylinder(gl, 0.25f,0.52f);
	gl.glPopMatrix();
	
	}
}