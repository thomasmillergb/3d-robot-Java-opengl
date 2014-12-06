/*
Author: Steve Maddock
Last updated: 24 October 2013
*/
package textures;
import java.io.File;
import java.awt.image.*;
import javax.imageio.*;
import com.jogamp.opengl.util.awt.*;

import javax.media.opengl.*;
import com.jogamp.opengl.util.*;
import com.jogamp.opengl.util.texture.*;
import com.jogamp.opengl.util.texture.awt.*;





public class Textures {
  
  public Textures() {

  }
   public Texture loadTexture(GL2 gl, String filename) {
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
    catch(
Exception e) {
      System.out.println("Error loading texture " + filename); 
    }
    return tex;
  } // end of loadTexture()  
  
  

	

}


