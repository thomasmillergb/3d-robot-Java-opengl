import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;


public class Room{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private float slices = 0;
  private float x = 0;
  private float y = 0;
 public Room(float slices, float x ,float y) {
 
	this.slices = slices;
	this.x = x;
	this.y = y;

 
 }
 
     public void drawRoom(GL2 gl) {              // Draw The Room (Box)
	 
        gl.glBegin(GL2.GL_QUADS);                // Begin Drawing Quads
		
	//	for (float xs = 0.0f; xs<= x; xs+=slices){
		//	for (float ys = 0.0f; ys<= y; ys+=slices){

					gl.glNormal3f(1.0f, 0.0f, 0.0f); 
					
					drawFloor(gl,0,0);
		//	}
		//}
		
        gl.glEnd();                             // Done Drawing Quads
    
	
	}
	private void drawFloor(GL2 gl,float x,float y){
		gl.glVertex3f(-1.0f, 0.0f, -1.0f);  
        gl.glVertex3f(-1.0f, 0.0f, 1.0f );
        gl.glVertex3f(1.0f,  0.0f, 1.0f );
		gl.glVertex3f(1.0f, 0.1f, -1.0f); 
		
		gl.glVertex3f(-1.0f, 0.0f, -1.0f); 
        //gl.glVertex3f(1.0f,  0.0f, -1.0f);  
		//gl.glVertex3f(1.0f,  0.0f, 1.0f );
		//gl.glVertex3f(-1.0f, 0.0f, -1.0f); 
	
	}
	
	
	
}