/**
 * Created by rafael on 4/9/16.
 */
public class MatrizVerdade {
    protected Boolean[][] matriz;
    protected String[] indices;
    protected int[] teste;
    public MatrizVerdade() {
        this.matriz = new Boolean[][] { {false,false,false,false,false,false,true},
                                        {false,true,true,true,true,true,true},
                                        {false,false,true,true,true,true,true},
                                        {false,false,true,true,true,true,true},
                                        {false,false,false,false,true,true,true},
                                        {false,false,false,false,true,true,true},
                                        {false,false,false,false,false,false,false} };

        this.indices = new String[] {"(", "^", "*", "/", "+", "-", ")"}; // OPERANDOS
        this.teste = new int[10];
        this.teste[1] = 1;
    }

    public Boolean getVerdade(String token, String pop) throws Exception {
        System.out.print(this.teste.length);
        return false;
//        int l, c;
//        l = this.indexOf(token);
//        c = this.indexOf(pop);
//
//        if (l < 0 || c < 0)
//            throw new Exception("Sua expressão contém operandos inválidos!");
//
//        return this.matriz[c][l];
    }

    protected Integer indexOf(String v) {
        Integer i;

        for (i = 0; i < this.indices.length; i++)
            if (this.indices[i] == v)
                return i;

        return -1;
    }
}
