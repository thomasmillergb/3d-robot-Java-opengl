
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import render.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

public class Wall{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private float slices = 0;
  private int x = 0;
  private int y = 0;
  private Mesh meshWall;
  private Render wall, floor;
  private Texture tex;

 public Wall(int x, int y,Texture wallTex) {
	this.tex = wallTex;
	this.x = x;
	this.y = y;
 }
	public Render renderWall(GL2 gl) {              // Draw The Room (Box)
		
		meshWall = ProceduralMeshFactory.createPlane(x,y,x*10,y*10,1,1);  // Create the mesh structure
		Material mat = meshWall.getMaterial();   // Get a reference to the current material
										// of the mesh (i.e. diffuse, specular, etc)
										// Then set a new diffuse colour for the mesh's material
		//mat.setDiffuse(new float[]{0.3f,0.3f,1f, 1f}); // Colour will be mostly blue.
		
		wall = new Render(meshWall,tex);    // Create a new Render object for the mesh
		wall.initialiseDisplayList(gl, true);  // We'll use a display list for the plane
		return wall;
	
	}


	
	
}