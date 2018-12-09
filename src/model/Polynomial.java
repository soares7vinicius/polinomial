package model;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;

public class Polynomial {
    private static LaguerreSolver SOLVER = new LaguerreSolver();
    
    public PolynomialFunction func;
    public Complex[] roots;

    public Polynomial(PolynomialFunction func, Complex[] roots) {
        this.func = func;
        this.roots = roots;
    }
    
    public void solve(double initial){
        this.roots = SOLVER.solveAllComplex(func.getCoefficients(), initial);
    }
    
}
