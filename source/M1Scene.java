/*
Author: Steve Maddock
Last updated: 24 October 2013
*/

import java.io.File;
import java.awt.image.*;
import javax.imageio.*;
import com.jogamp.opengl.util.awt.*;

import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;

import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import render.*;
import myLights.*;


import parts.robotParts.*;

public class M1Scene {
  private int frame;
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();

  private final double INC_ROTATE=2.0;

  private double rotate=0.0;
  private boolean objectsOn = true;

  private int canvaswidth=0, canvasheight=0;

  private Light light1;
  private Camera camera;
  private Mesh meshPlane, meshCylinder, meshCube; 
  private Render room; 
  private Texture WallTex;
  public MyLights lights;

  public M1Scene(GL2 gl, Camera camera) {
	float frame = 0.0f;

	lights = new MyLights();
	lights.drawLights(gl);
    this.camera = camera;
	 createRenderObjects(gl);  
   
  }
   private Texture loadTexture(GL2 gl, String filename) {
    Texture tex = null;
    // since file loading is involved, must use try...catch
    try {
      File f = new File(filename);

      // The following line results in a texture that is flipped vertically (i.e. is upside down)
      // due to OpenGL and Java (0,0) position being different:
      // tex = TextureIO.newTexture(new File(filename), false);

      // So, instead, use the following three lines which flip the image vertically:
      BufferedImage img = ImageIO.read(f); // read file into BufferedImage
      ImageUtil.flipImageVertically(img);
	  
	    // No mip-mapping.
      tex = AWTTextureIO.newTexture(GLProfile.getDefault(), img, false);

      // Different filter settings can be used to give different effects when the texture
      // is applied to a set of polygons.
      tex.setTexParameteri(gl, GL2.GL_TEXTURE_MAG_FILTER, GL2.GL_LINEAR);
      tex.setTexParameteri(gl, GL2.GL_TEXTURE_MIN_FILTER, GL2.GL_LINEAR);
   
    }
    catch(Exception e) {
      System.out.println("Error loading texture " + filename); 
    }
    return tex;
  } // end of loadTexture()  
  
  
  // called from SG1.reshape() if user resizes the window
  public void setCanvasSize(int w, int h) {
    canvaswidth=w;
    canvasheight=h;
  }
 // private void doLight1(GL2 gl) {     light1.use(gl, glut, false);   } 
  public void setObjectsDisplay(boolean b) {
    objectsOn = b;
  }




  
  public void reset() {
    rotate=0.0;
    setObjectsDisplay(true);
  }

  public void incRotate() {
    rotate=(rotate+INC_ROTATE)%360;
  }

  public void update() {
    incRotate();
  }


  
  public void render(GL2 gl) {
    gl.glClear(GL2.GL_COLOR_BUFFER_BIT|GL2.GL_DEPTH_BUFFER_BIT);
    gl.glLoadIdentity();
    camera.view(glu);      // Orientate the camera
	frame++;

	
	
	
	drawRobot(gl);
	drawRoom(gl);
	lights.doLights(gl);
	
  }
  private void drawRobot(GL2 gl){
	Robot robot = new Robot(frame);

	robot.drawRobot(gl,lights,true);
	Robot robot2 = new Robot(frame-60);

	//robot2.drawRobot(gl,lights,false);
	
  }

	private void createRenderObjects(GL2 gl) {
	
		WallTex= loadTexture(gl, "textures/brick_test3.jpg");
		Room wall = new Room(20,20,WallTex);
		room = wall.renderWall(gl);

}
	private void drawRoom(GL2 gl){
		
		
		for(int i = 0; i<4; i++){
			gl.glRotated(90,0,0,1);
			gl.glPushMatrix();
			gl.glTranslated(0,-10,0);
			room.renderDisplayList(gl);
			gl.glPopMatrix();
		}
		
		for(int i = 0; i<2; i++){
			gl.glRotated(180,1,0,0);
			gl.glPushMatrix();
			gl.glRotated(90,1,0,0);
			gl.glTranslated(0,-10,0);
			
			room.renderDisplayList(gl);
			gl.glPopMatrix();
	}
	
		
		
		
		
		
	}

	

  

}


