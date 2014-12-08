
/**
 * A class for a light.
 *
 * @author    Dr Steve Maddock
 * @version   1.0 (26/07/2013)
 */

import javax.media.opengl.glu.GLU;
 
public class Camera {

  public static final double[] DEFAULT_EYE_POSITION = {5.0,5.0,8.0};
  public static final double[] DEFAULT_LOOKAT_POSITION = {10.0,0.0,0.0};
  public static final double[] DEFAULT_UP_DIRECTION = {0.0,1.0,0.0};
  
  private double theta, phi, radius;

  private double[] eye = new double[3];
  private double[] lookAt = new double[3];
  private double[] upvec = new double[3];
  
  /**
   * Constructor.
   */
  public Camera(double theta, double phi, double radius) {
    this.theta = theta;
	  this.phi = phi;
	  this.radius = radius;
	  calcEyePosition();
  }    

  public void updateThetaPhi(double thetaInc, double phiInc) {
    theta += thetaInc;
	phi += phiInc;
	calcEyePosition();
  }
  
  public void updateRadius(double radiusInc) {
    radius += radiusInc;
	  calcEyePosition();
  }

  public double getEyeX() { return eye[0]; }
  public double getEyeY() { return eye[1]; }
  public double getEyeZ() { return eye[2]; }

  public double getUpVecX() { return upvec[0]; }
  public double getUpVecY() { return upvec[1]; }
  public double getUpVecZ() { return upvec[2]; }

  
  private void calcEyePosition() {
    double cy, cz, sy, sz;
    cy = Math.cos(theta);
    sy = Math.sin(theta);
    cz = Math.cos(phi);
    sz = Math.sin(phi);
    	
    eye[0] = radius*cy*cz;
    eye[1] = radius*sz;
    eye[2] = -radius*sy*cz;
    
    upvec[0] = -cy*sz;
    upvec[1] = cz;
    upvec[2] = sy*sz;

    // To keep the camera always pointing upwards, if the y-component
    // of the up vector is negative, invert the whole up vector    
    if (upvec[1]<0) {
      upvec[0]=-upvec[0];
      upvec[1]=-upvec[1];
      upvec[2]=-upvec[2];
    }
  }
  
  public void view(GLU glu) {
    glu.gluLookAt(getEyeX(), getEyeY(), getEyeZ(),
	                0.0f, 0.0f, 0.0f, 
		              getUpVecX(), getUpVecY(), getUpVecZ());
  }
  
  public String toString() {
    return "["+eye[0]+", "+eye[1]+", "+eye[2]+"]";
  }

  public static void main(String[] args) {
    Camera camera = new Camera(Math.toRadians(-45), Math.toRadians(30), 8.0f);
	  System.out.println(camera);
  }
}
