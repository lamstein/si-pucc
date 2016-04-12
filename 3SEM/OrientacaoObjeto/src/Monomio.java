/**
 * Created by rafael on 4/11/16.
 */
public class Monomio {
    protected double coeficiente, potencia;

    public void setCoeficiente(double c) throws Exception {
        if (c==0) throw new Exception("Coeficiente Inválido!");

        this.coeficiente = c;
    }

    public void setPotencia(double p) {
        this.potencia = p;
    }


    public Monomio (double c, double p) throws Exception{
        this.setCoeficiente (c);
        this.setPotencia (p);
    }

    public Monomio mais(Monomio m) throws Exception{
        if (this.potencia != m.potencia) throw new Exception("Soma de monomios com potencias diferentes!");

        return new Monomio(this.coeficiente + m.coeficiente, this.potencia);
    }

    public Monomio menos(Monomio m) throws Exception {
        if (this.potencia != m.potencia) throw new Exception("Subtração de monomios com potencias diferentes");

        return new Monomio(this.coeficiente-m.coeficiente, this.potencia);
    }

    public double aplicadoA(double x){
        return (Math.pow(x, this.potencia) * this.coeficiente);
    }
}
