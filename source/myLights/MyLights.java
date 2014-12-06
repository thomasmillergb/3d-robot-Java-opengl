package myLights;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
public class MyLights {

  private Light eyeLight0,eyeLight1,eyeLight2,eyeLight3,globalLight;
  private GLU glu = new GLU();
  private GLUT glut = new GLUT();
  private double rotate=0.0;
  
  //List<Light> lights = new ArrayList<MyObject>();
  public MyLights(){
  }
  
  public void drawLights(GL2 gl){
		eyeLight0(gl);
		eyeLight1(gl);

		globalLight(gl);
	
		
  }

  private void eyeLight1(GL2 gl){
		float[] position = {0,0,0,0}; 
		final float[] ambient = {1.0f,1.0f,1.0f}; 
		final float[] diffuse= {1.0f,1.0f,1.0f}; 
		final float[] specular= {0.0f,0.0f,10f}; 
		
		float[] direction = {0.0f,-0.2f,1.0f};
		eyeLight1 = new Light(GL2.GL_LIGHT1,position,ambient,diffuse,specular, true);
		eyeLight3 = new Light(GL2.GL_LIGHT2,position,ambient,diffuse,specular, true);
		eyeLight1.makeSpotlight(direction, 10f);
		eyeLight3.makeSpotlight(direction, 10f);
  
  /*

*/
  
  }
  private void eyeLight0(GL2 gl){
	
    	float[] position = {0,0,0,0}; 
		final float[] ambient = {1.0f,1.0f,1.0f}; 
		final float[] diffuse= {1.0f,1.0f,1.0f}; 
		final float[] specular= {0.0f,0.0f,10f}; 
		
		float[] direction = {0.0f,-0.2f,1.0f};
		eyeLight0 = new Light(GL2.GL_LIGHT3,position,ambient,diffuse,specular, true);
		eyeLight2 = new Light(GL2.GL_LIGHT4,position,ambient,diffuse,specular, true);
		eyeLight0.makeSpotlight(direction, 10f);
		eyeLight2.makeSpotlight(direction, 10f);
	
  }
  private void globalLight(GL2 gl){
  
  	final float[] position = {0,0,0,1};

	final float[] ambient = {0.75f,0.75f,0.75f}; 
	final float[] diffuse= {0.1f,0.1f,0.1f}; 
	final float[] specular= {0.1f,1.1f,0.1f}; 

	globalLight = new Light(GL2.GL_LIGHT5,position,ambient,diffuse,specular, true);
	
  }

  
  
  
  public void doLights(GL2 gl){
 
	doGlobalLight(gl);
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
  
  
  
    public void doGlobalLight(GL2 gl) {
	
      globalLight.use(gl, glut, false);
	
 
  }
  
    public Light getLight() {
    return eyeLight0;
  }
  
  
  
  
  
  
  

}
