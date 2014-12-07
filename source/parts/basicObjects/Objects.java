package parts.basicObjects;
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;

//import textures 
import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

public class Objects{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  //private Render sphere;
 public Objects() {

 
 }

 	public void drawspher(GL2 gl, float radius){
		
			gl.glPushMatrix();
			
			// Draw sphere (possible styles: FILL, LINE, POINT).
			gl.glColor3f(0.3f, 0.5f, 1f);
			GLUquadric QUAD = glu.gluNewQuadric();
			
			
			glu.gluQuadricDrawStyle(QUAD, GLU.GLU_LINE);
			glu.gluQuadricNormals(QUAD, GLU.GLU_FLAT);
			glu.gluQuadricOrientation(QUAD, GLU.GLU_OUTSIDE);
			glu.gluQuadricDrawStyle(QUAD, GLU.GLU_FILL);
			
			final int SLICES = 16;
			final int STACKS = 16;
			glu.gluSphere(QUAD, radius, SLICES, STACKS);
			glu.gluDeleteQuadric(QUAD);
				
			gl.glPopMatrix();
	}

	
	
	
		
	public void drawCylinder(GL2 gl, float height, float radius){
	gl.glPushMatrix();	
		gl.glColor3f(0.3f, 0.5f, 1f);
		GLUquadric QUAD = glu.gluNewQuadric();
		final int SLICES = 16;
		
		//quad,base,top,height,slices,stacks
		glu.gluCylinder(QUAD, radius, radius, height, SLICES, 16);
		
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