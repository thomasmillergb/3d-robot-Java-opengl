
import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import javax.media.opengl.glu.GLUquadric;
import render.*;
import textures.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

public class Room{
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  
 
  private Render room,floor,roof; 

 public Room() {

 }

	public void createRenderObjects(GL2 gl, Texture wallTex,Texture floorTex,Texture roofTex) {


		Wall wall = new Wall(20,20,wallTex);
		Wall floorr = new Wall(20,20,floorTex);
		Wall roofed = new Wall(20,20,roofTex);
		room = wall.renderWall(gl);
		floor = floorr.renderWall(gl);
		roof = roofed.renderWall(gl);

}
	public void drawRoom(GL2 gl){
	drawFloor(gl);
	drawWall(gl);
	drawRoof(gl);
	drawObjects(gl);
	}

	private void drawWall(GL2 gl){
		gl.glPushMatrix();
			gl.glRotated(90,0,0,1);
		
		for(int i = 0; i<4; i++){
			
					
					gl.glRotated(90,1,0,0);
					gl.glPushMatrix();
						gl.glTranslated(0,-10,0);
						gl.glRotated(90,0,1,0);
						room.renderDisplayList(gl);
					gl.glPopMatrix();
			
			
		}
		gl.glPopMatrix();
		
	}
	private void drawFloor(GL2 gl)
	{
		gl.glPushMatrix();
			
			gl.glPushMatrix();
			//gl.glRotated(90,1,0,0);
			gl.glTranslated(0,-10,0);
			
			floor.renderDisplayList(gl);
			gl.glPopMatrix();
		gl.glPopMatrix();
		
	}
	private void drawRoof(GL2 gl)
	{
		gl.glPushMatrix();
			
			gl.glPushMatrix();
			//gl.glRotated(90,1,0,0);
			gl.glTranslated(0,10,0);
			gl.glRotated(180,1,0,0);
			roof.renderDisplayList(gl);
			gl.glPopMatrix();
		gl.glPopMatrix();
		
	}
	private void drawObjects(GL2 gl){
		
		gl.glPushMatrix();
			gl.glTranslated(8,0,0);
			//gl.glColor3d(0.3f, 0.5f, 1f);
			glut.glutSolidTorus(1.0f,4.0f,16,32);
			
		gl.glPopMatrix();
		gl.glPushMatrix();
			gl.glTranslated(0,-3,-8);
			gl.glRotated(90,0,1,0);
			glut.glutSolidTorus(1.0f,5.0f,16,32);
		
		gl.glPopMatrix();
		gl.glPushMatrix();
			gl.glRotated(45,0,1,0);
			gl.glTranslated(0,3,8.5f);
			gl.glRotated(90,0,1,0);
			glut.glutSolidTorus(1.0f,5.0f,16,32);
		
		gl.glPopMatrix();
	
	
	}


	
	
}