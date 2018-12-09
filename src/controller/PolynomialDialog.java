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
        frame.setSize(400, 400);
        frame.setTitle(p.getFunc().toString());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

        /*
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
        */
    }

    @Override
    public void dispose(GLAutoDrawable arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void init(GLAutoDrawable drawable) {
        // TODO Auto-generated method stub

        GL2 gl = drawable.getGL().getGL2();

        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
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
