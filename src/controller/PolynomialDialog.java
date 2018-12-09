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
import javax.swing.JDialog;

import model.Polynomial;

public class PolynomialDialog implements GLEventListener {
    
    private Polynomial p;
    private double left, right, bottom, top;

    public PolynomialDialog(Polynomial p, double left, double right, double bottom, double top) {
        this.p = p;
        this.left = left;
        this.right = right;
        this.bottom = bottom;
        this.top = top;
    }

    /*
    public static void main(String[] args) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);

        GLCapabilities capabilities = new GLCapabilities(profile);

        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(new PolynomialDialog());

        JFrame frame = new JFrame("");
        frame.getContentPane().add(canvas);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    */
    
    public static void showDialog(Polynomial p, double left, double right, double bottom, double top) {
        GLProfile profile = GLProfile.get(GLProfile.GL2);

        GLCapabilities capabilities = new GLCapabilities(profile);

        GLCanvas canvas = new GLCanvas(capabilities);
        canvas.addGLEventListener(new PolynomialDialog(p, left, right, bottom, top));

        JDialog frame = new JDialog();
        frame.getContentPane().add(canvas);
        frame.setSize(500, 500);
        frame.setTitle(p.getFunc().toString());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        
        GL2 gl = drawable.getGL().getGL2();
        
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glEnable(GL2.GL_LINE);
        
        gl.glColor3f(0.58f, 0.58f, 0.58f);
        gl.glLineWidth(1f);
        
        gl.glBegin(GL2.GL_LINES);
            gl.glVertex2d(left, 0);
            gl.glVertex2d(right, 0);
            gl.glVertex2d(0, bottom);
            gl.glVertex2d(0, top);
        gl.glEnd();
        
        for(double x = left; x <= right; x++) {
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(x, 0.25);
                gl.glVertex2d(x, -0.25);
            gl.glEnd();
        }
        for(double y = bottom; y <= top; y++) {
            gl.glBegin(GL2.GL_LINES);
                gl.glVertex2d(-0.25, y);
                gl.glVertex2d(0.25, y);
            gl.glEnd();
        }
        
        gl.glColor3f(0f, 0f, 0f);
        gl.glLineWidth(1.25f);
        gl.glBegin(GL2.GL_LINE_LOOP);
        for(double x = left; x <= right; x += 0.05) {
            gl.glVertex2d(x, this.p.getFunc().value(x));
        }
        gl.glEnd();
        
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

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1f);
        //gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glMatrixMode(GL2.GL_MATRIX_MODE);
        gl.glLoadIdentity();

        GLU glu = new GLU();
        glu.gluOrtho2D(this.left, this.right, this.bottom, this.top);
    }

    @Override
    public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
        // TODO Auto-generated method stub

    }
}
