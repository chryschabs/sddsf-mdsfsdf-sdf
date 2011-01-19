import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.media.opengl.GL;


public class BoxFace {
	GL gl;
	public Point3D[] corners;
	
	//CC
	public BoxFace(Point3D firstCorner, Point3D secCorner, Point3D thirdCorner, Point3D forthCorner){
		corners = new Point3D[4];
		corners[0]=firstCorner;
		corners[1]=secCorner;
		corners[2]=thirdCorner;
		corners[3]=forthCorner;
	}

	/**
	 * 		serCorner()
	 * @param corner to set
	 * @param pos - between 0 and 3
	 *///CC
	public void setCorner(Point3D corner, int pos) {
		if(pos >= 0 && pos <= 3){
			if(corner != null){
				switch(pos){
				case 0:corners[0] = corner;break;
				case 1:corners[1] = corner;break;
				case 2:corners[2] = corner;break;
				case 3:corners[3] = corner;break;
				}
			}
		}
	}
	
	public boolean includesSelectedPoint(Point3D pt2Compare, Point3D[] face){
		boolean includesPt;
		includesPt = false;
		if(faceHasValidCorners(face)){
			
		}
		
		
		return includesPt;
	}
	
	/**
	 * 		hasSameX
	 * @param pt
	 * @param face
	 * @return true if compared point has the same x coordinate as all the face's corner.
	 */
	public boolean hasSameX(Point3D pt, Point3D[] face){
		boolean hasSameX;
		hasSameX = false;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		for(int i = 0; i < face.length; i++){
			if(df.format(pt.x()).equals(df.format(face[i].x()))){
				hasSameX = true;
			}
		}
		return hasSameX;
	}
	
	/**
	 * 		hasSameY
	 * @param pt
	 * @param face
	 * @return true if compared point has the same y coordinate as all the face's corner.
	 */
	public boolean hasSameY(Point3D pt, Point3D[] face){
		boolean hasSameY;
		hasSameY = false;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		for(int i = 0; i < face.length; i++){
			if(df.format(pt.y()).equals(df.format(face[i].y()))){
				hasSameY = true;
			}
		}
		return hasSameY;
	}
	
	/**
	 * 		hasSameZ
	 * @param pt
	 * @param face
	 * @return true if compared point has the same z coordinate as all the face's corner.
	 */
	public boolean hasSameZ(Point3D pt, Point3D[] face){
		boolean hasSameZ;
		hasSameZ = false;
		DecimalFormat df = new DecimalFormat("#.##");
		df.setRoundingMode(RoundingMode.HALF_EVEN);
		for(int i = 0; i < face.length; i++){
			if(df.format(pt.z()).equals(df.format(face[i].z()))){
				hasSameZ = true;
			}
		}
		return hasSameZ;
	}
	
	//check if face has 4 valid corners
	public boolean faceHasValidCorners(Point3D[] face2Check){
		boolean isFaceValid;
		isFaceValid = false;
		int faceIterator;
		if(face2Check.length != 4) return false;
		for(faceIterator = 0; faceIterator < face2Check.length; faceIterator++){
			if(face2Check[faceIterator] != null){
				isFaceValid = true;
			}
		}
		return isFaceValid;
	}

	public void drawAsSelected(){
		gl.glBegin( GL.GL_LINES );
			gl.glColor3f(1,0,0);
			gl.glVertex3fv( corners[0].get(), 0 );
			gl.glVertex3fv( corners[3].get(), 0 );
		gl.glEnd();
		
		gl.glBegin( GL.GL_LINES );
			gl.glColor3f(1,0,0);
			gl.glVertex3fv( corners[1].get(), 0 );
			gl.glVertex3fv( corners[2].get(), 0 );
		gl.glEnd();
	}
	
	public String toString(){
		return "corner #1: (" + corners[0].toString() + "), corner #2: (" + corners[1].toString()
			+ "), corner #3: (" + corners[2].toString() + "), corner #4: (" + corners[3].toString();
	}
}
