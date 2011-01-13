import javax.media.opengl.GL;


public class BoxFace {
	GL gl;
	public Point3D[] corners;

	public void setCorner(Point3D corner0,Point3D corner1,Point3D corner2,Point3D corner3) {
		corners[0]=corner0;
		corners[1]=corner1;
		corners[2]=corner2;
		corners[3]=corner3;
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
}
