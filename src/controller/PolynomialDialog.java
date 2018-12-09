package controller;

import javax.swing.JFrame;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.awt.GLJPanel;
import com.jogamp.opengl.glu.GLU;

public class PolynomialDialog implements GLEventListener {

    public static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);

        GLCapabilities capabilities = new GLCapabilities(profile);

        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(new PolynomialDialog());

        JFrame frame = new JFrame("Linhas");
        frame.getContentPane().add(canvas);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    public GLJPanel panel() {
        GLProfile profile = GLProfile.get(GLProfile.GL2);

        GLCapabilities capabilities = new GLCapabilities(profile);

        GLJPanel panel = new GLJPanel(capabilities);
        panel.addGLEventListener(new PolynomialDialog());
        
        return panel;
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

        GL2 gl = drawable.getGL().getGL2();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(1.0f, 1.0f, 1.0f);

        int patterns[] = { 0x00FF, 0x00FF, 0x0C0F, 0x0C0F, 0xAAAA, 0xAAAA, 0xAAAA, 0xAAAA };
        int factors[] = { 1, 2, 1, 3, 1, 2, 3, 4 };
        
        gl.glLineWidth(1f);
        gl.glEnable(GL2.GL_LINE_STIPPLE);
        double f = -0.9;
        for(int i = 0; i < patterns.length; i++, f += 0.2) {
            gl.glLineStipple(factors[i], (short)patterns[i]);
            gl.glBegin(GL.GL_LINES);
            gl.glVertex2f(-1f, (float) f);
            gl.glVertex2f(1f, (float) f);
            gl.glEnd();
        }

        gl.glFlush();
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MATRIX_MODE);
        gl.glLoadIdentity();

        GLU glu = new GLU();
        //glu.gluOrtho2D(0.0, 200.0, 0.0, 150.0);
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // TODO Auto-generated method stub

    }
}
