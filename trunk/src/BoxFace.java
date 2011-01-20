import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.media.opengl.GL;


public class BoxFace {
	GL gl;
	public Point3D[] corners;
	private boolean isX = false;
	
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
	
	//returns true if passed-in point belongs to the passed in face.
	public boolean includesSelectedPoint(Point3D pt2Compare){
		boolean includesPt;
		includesPt = false;
		if(faceHasValidCorners()){
			if(hasSameX(pt2Compare)){
				includesPt = true;
			}
			else if(hasSameY(pt2Compare)){
				includesPt = true;
			}
			else if(hasSameZ(pt2Compare)){
				includesPt = true;
			}
		}	
		return includesPt;
	}
	
	/**
	 * 		hasSameX
	 * @param pt
	 * @return true if compared point has the same x coordinate as all the face's corner.
	 */
	/* Explication (Cube):
	 * 
	 *			+'''T'''+
	 * 		+'''''''+   | <- (B, back face)
	 * 	L->	|		| R |
	 * 		|	F	|	+
	 * 		O______	+
	 * 			^
	 * 			S
	 * Consider F the front face of the cube, B the back face,
	 * R the right face, L the left face, T the top face and S the bottom face.
	 * All faces have at least one shared coordinate that is the same for all corners
	 * of that face.
	 * If a selected point has the same X value as the four corners of a face, it
	 * means this point belongs to the face.
	 * In this case, if consider the origin of axis to be centered on the corner O(x,y,z),
	 * the 2 faces with the same X values are R and L. (Say R(X) = +0.25, L(X) = -0.25
	 * The 2 faces with the same Y values are T and S. (T(Y) = +0.25, S(Y) = -0.25)
	 * The 2 faces with the same Z values are F and B. (F(Z) = +0.25, S(Z) = -0.25)
	 * We can apply the same logic to other faces of the cube with Y and Z values.*/
	
	public boolean hasSameX(Point3D pt){
		boolean hasSameX;
		hasSameX = false;
		for(int i = 0; i < this.corners.length; i++){
			if(Utils.trim(pt.x(),4) == Utils.trim(this.corners[i].x(),4)){
				hasSameX = true;
			}
		}
		return hasSameX;
	}
	
	/**
	 * 		hasSameY
	 * @param pt
	 * @return true if compared point has the same y coordinate as all the face's corner.
	 */
	public boolean hasSameY(Point3D pt){
		boolean hasSameY;
		hasSameY = false;
		for(int i = 0; i < this.corners.length; i++){
			if(Utils.trim(pt.y(),4) == Utils.trim(this.corners[i].y(),4)){
				hasSameY = true;
			}
		}
		return hasSameY;
	}
	
	/**
	 * 		hasSameZ
	 * @param pt
	 * @return true if compared point has the same z coordinate as all the face's corner.
	 */
	public boolean hasSameZ(Point3D pt){
		boolean hasSameZ;
		hasSameZ = false;
		for(int i = 0; i < this.corners.length; i++){
			if(Utils.trim(pt.z(),4) == Utils.trim(this.corners[i].z(),4)){
				hasSameZ = true;
			}
		}
		return hasSameZ;
	}
	
	/**
	 * 	faceHasValidCorners()
	 * @return true if none of the corners are null.
	 */
	public boolean faceHasValidCorners(){
		boolean isFaceValid;
		isFaceValid = false;
		int faceIterator;
		for(faceIterator = 0; faceIterator < corners.length; faceIterator++){
			if(corners[faceIterator] != null){
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
			+ "), corner #3: (" + corners[2].toString() + "), corner #4: (" + corners[3].toString() + ")";
	}

	public boolean isX() {
		return isX;
	}

	public void setX(boolean isX) {
		this.isX = isX;
	}
}
