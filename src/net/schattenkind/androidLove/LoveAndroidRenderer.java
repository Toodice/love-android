package net.schattenkind.androidLove;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.opengl.GLSurfaceView;

public class LoveAndroidRenderer implements GLSurfaceView.Renderer {
	private FloatBuffer triangleVB;
	private LoveVM vm;
	public int mScreenW = 0;
	public int mScreenH = 0;

	public LoveAndroidRenderer (LoveVM vm) { this.vm = vm; }
	
	private void initShapes() {
		float triangleCoords[] = {
				// X, Y, Z
				-0.5f, -0.25f, 0, 0.5f, -0.25f, 0, 0.0f, 0.559016994f, 0 };

		// initialize vertex Buffer for triangle
		ByteBuffer vbb = ByteBuffer.allocateDirect(
		// (# of coordinate values * 4 bytes per float)
				triangleCoords.length * 4);
		vbb.order(ByteOrder.nativeOrder());// use the device hardware's native
											// byte order
		triangleVB = vbb.asFloatBuffer(); // create a floating point buffer from
											// the ByteBuffer
		triangleVB.put(triangleCoords); // add the coordinates to the
										// FloatBuffer
		triangleVB.position(0); // set the buffer to read the first coordinate

	}
	
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {
		// Set the background frame color
		//~ gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
		gl.glColor4f(1f, 1f, 1f, 1f);

		// initialize the triangle vertex array
		initShapes();

		// Enable use of vertex arrays
		//~ gl.glEnableClientState(GL10.GL_VERTEX_ARRAY); // moved to onDrawFrame
		
		vm.notifyGL(gl);
	}

	public void onDrawFrame(GL10 gl) {
		// Redraw background color
		gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		// Draw the triangle
		/*
		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		gl.glColor4f(0.63671875f, 0.76953125f, 0.22265625f, 0.0f);
		gl.glVertexPointer(3, GL10.GL_FLOAT, 0, triangleVB);
		gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);
		gl.glDisableClientState(GL10.GL_VERTEX_ARRAY);
		*/
		
		vm.notifyGL(gl);
		vm.draw(gl);
	}

	public void onSurfaceChanged(GL10 gl, int width, int height) {
		mScreenW = width;
		mScreenH = height;
		//~ gl.glViewport(0, 0, width, height);
		//~ gl.glViewport(0, height, 2, 2); // (evil dark voodoo magic) love2d pixel coord system: 0,0=top,left w,h=bottom,right
		//~ gl.glScalef(1,-1,1);
		
		gl.glViewport(0, 0, width, height); // (evil dark voodoo magic) love2d pixel coord system: 0,0=top,left w,h=bottom,right
				
		vm.notifyScreenSize((float)width, (float)height);
		vm.notifyGL(gl);
	}

}