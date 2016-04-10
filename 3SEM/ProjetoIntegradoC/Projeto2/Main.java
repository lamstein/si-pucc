import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by rafael on 4/9/16.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        StringTokenizer token;
        MatrizVerdade mVerdade = new MatrizVerdade();
        Controlador controlador;
        BufferedReader ler = new BufferedReader(new InputStreamReader(System.in));
        String exp = "";
        Integer opt = 1;

        while (opt > 0) {
            System.out.println("O que você deseja fazer?");
            System.out.println("1 - Resolver uma nova expressão\n" +
                               "2 - Consultar o histórico de expressões\n" +
                               "0 - Sair do sistemas");

            opt = Integer.parseInt(ler.readLine());

            switch (opt){
                case 1:
                    while (exp.length() < 3) {
                        System.out.println("Informe a expressão matemática a ser resolvida:");
                        try {
                            exp = ler.readLine();
                        } catch (Exception e) {}

                        if (exp.length() < 3){
                            System.out.println("Sua expressão não contém elementos suficientes. Tente novamente.");
                        } else {
                            controlador = new Controlador(exp);
                            controlador.resolver();
                        }
                    }
                    break;
                case 2:
                    mVerdade.getVerdade("asd","asd");
                    break;
            }
        }
    }
}
