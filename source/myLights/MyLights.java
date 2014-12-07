package myLights;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
public class MyLights {

  private Light eyeLight0,eyeLight1,eyeLight2,eyeLight3,globalLight,spotLight1,spotLight2;
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private double rotate=0.0;
  

  public MyLights(){
  }
  
  public void drawLights(GL2 gl){
		eyeLight0(gl);
		eyeLight1(gl);

		globalLight(gl);
		spotLights(gl);
		
  }
  private void spotLights(GL2 gl){
		float[] position = {0,9,0,1}; 
		float[] position2 = {0,-9,0,1};
		final float[] ambient = {1.0f,1.0f,1.0f}; 
		final float[] diffuse= {1.0f,1.0f,1.0f}; 
		final float[] specular= {1.0f,1.0f,1.0f}; 
		
		float[] direction = {0.0f,-10.0f,-7.0f};
		float[] direction2 = {0.0f,100.0f,0.0f};
		spotLight1 = new Light(GL2.GL_LIGHT5,position,ambient,diffuse,specular, true);
		
		spotLight2 = new Light(GL2.GL_LIGHT6,position2,ambient,diffuse,specular, true);
		spotLight1.makeSpotlight(direction, 20f);
		spotLight2.makeSpotlight(direction2, 30f);

  
  }
  private void eyeLight1(GL2 gl){
		float[] position = {0,0,0,1}; 
		final float[] ambient = {1.0f,0.0f,0.0f}; 
		final float[] diffuse= {1.0f,0.0f,0.0f}; 
		final float[] specular= {1.0f,0.0f,0.0f};  
		
		float[] direction = {0.0f,-0.2f,1.0f};
		eyeLight1 = new Light(GL2.GL_LIGHT1,position,ambient,diffuse,specular, true);
		eyeLight3 = new Light(GL2.GL_LIGHT2,position,ambient,diffuse,specular, true);
		eyeLight1.makeSpotlight(direction, 10f);
		eyeLight3.makeSpotlight(direction, 10f);

  
  }
  private void eyeLight0(GL2 gl){
	
    	float[] position = {0,0,0,1}; 
		final float[] ambient = {0.0f,0.0f,1.0f}; 
		final float[] diffuse= {0.0f,0.0f,1.0f}; 
		final float[] specular= {0.0f,0.0f,1.0f}; 
		
		float[] direction = {0.0f,-0.2f,1.0f};
		eyeLight0 = new Light(GL2.GL_LIGHT3,position,ambient,diffuse,specular, true);
		eyeLight2 = new Light(GL2.GL_LIGHT4,position,ambient,diffuse,specular, true);
		eyeLight0.makeSpotlight(direction, 10f);
		eyeLight2.makeSpotlight(direction, 10f);
	
  }
  private void globalLight(GL2 gl){
  
  	final float[] position = {0,2,0,0};

	final float[] ambient = {0.55f,0.55f,0.55f}; 
	final float[] diffuse= {0.5f,0.5f,0.5f}; 
	final float[] specular= {0.5f,0.5f,0.5f}; 

	globalLight = new Light(GL2.GL_LIGHT0,position,ambient,diffuse,specular, true);
	
  }

  
  
  
  public void doRoomLights(GL2 gl,int frame, boolean disco){
 
	 globalLight.use(gl, glut, false);
	  if (disco){
		gl.glRotated(frame*-2, 0.0f,1.0f,0.0f);
		spotLight1.use(gl, glut, false);
	  }
	  else{
		spotLight1.use(gl, glut, false);
	  }
	  
	  spotLight2.use(gl, glut, false);
  }

  
  
  public void doEyeLight(GL2 gl) {
      eyeLight0.use(gl, glut, false);
  }

  public void doEyeLight1(GL2 gl) {

      eyeLight1.use(gl, glut, false);
 
  }
  
    public void doEyeLight2(GL2 gl) {
      eyeLight2.use(gl, glut, false);
  }

  public void doEyeLight3(GL2 gl) {

      eyeLight3.use(gl, glut, false);
 
  }
  
  public Light getLight() {
    return eyeLight0;
  }
    
  public Light getLight1() {
    return eyeLight1;
  }
    
  public Light getLight2() {
    return eyeLight2;
  }
    
  public Light getLight3() {
    return eyeLight3;
  }
    
  public Light getGLight() {
    return globalLight;
  }
  public Light getSpotLight1() {
    return spotLight1;
  }
  public Light getSpotLight2() {
    return spotLight2;
  }
  
  
  
  
  
  
  

}
