package model;

import org.apache.commons.math3.analysis.polynomials.PolynomialFunction;
import org.apache.commons.math3.analysis.solvers.LaguerreSolver;
import org.apache.commons.math3.complex.Complex;

public class Polynomial {
    private static LaguerreSolver SOLVER = new LaguerreSolver();
    
    private PolynomialFunction func;

    public Polynomial(double[] coefs) {
        this.func = new PolynomialFunction(coefs);
    }
    
    public Complex[] solve(double initial){
        return SOLVER.solveAllComplex(func.getCoefficients(), initial);
    }

    public PolynomialFunction getFunc() {
        return func;
    }
    
}
