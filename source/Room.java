import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import render.*;

public class Room{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private float slices = 0;
  private float x = 0;
  private float y = 0;
  private Mesh meshWall;
  private Render wall;
 public Room(float slices, float x ,float y) {
 
	this.slices = slices;
	this.x = x;
	this.y = y;

 
 }
 public Room() {
 }
	public Render renderWall(GL2 gl) {              // Draw The Room (Box)
		meshWall = ProceduralMeshFactory.createPlane(10,10,100,100,1,1);  // Create the mesh structure
		Material mat = meshWall.getMaterial();   // Get a reference to the current material
										// of the mesh (i.e. diffuse, specular, etc)
										// Then set a new diffuse colour for the mesh's material
		mat.setDiffuse(new float[]{0.3f,0.3f,1f, 1f}); // Colour will be mostly blue.
		wall = new Render(meshWall);    // Create a new Render object for the mesh
		wall.initialiseDisplayList(gl);  // We'll use a display list for the plane
		return wall;
	
	}

	private void drawFloor(GL2 gl,float x,float y){

	
	}
	
	
	
}