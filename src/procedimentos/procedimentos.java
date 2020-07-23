package procedimentos;

import javax.swing.JOptionPane;

public class procedimentos {
    public static void main(String[]args){

        int opc;
        float val1=0;
        float val2=0;
        float res=0;

        val1=Float.parseFloat(JOptionPane.showInputDialog("Digite o primeiro valor"));
        val2=Float.parseFloat(JOptionPane.showInputDialog("Digite o segundo valor"));

        opc=Integer.parseInt(JOptionPane.showInputDialog("Escolha uma opção:\n" +
                "Para o valor1: "+val1+" e para o valor2: "+val2+"\n\n"+
                "1 - Adição\n"+
                "2 - Subtração\n"+
                "3 - Multiplicação\n"+
                "4 - Divisão\n"+
                "Outro - Sair"));

        switch(opc){
            case 1:funcAdicao(val1, val2);
            break;
            case 2:funcSubtracao(val1, val2);
            break;
            case 3:funcMultiplicacao(val1, val2);
            break;
            case 4:funcDivisao(val1, val2);
            break;
            default:JOptionPane.showMessageDialog(null,"Fim do programa.");
        }
    }

    static void funcAdicao(float val1, float val2){

        float res=0;

        res=val1+val2;

        JOptionPane.showMessageDialog(null,"Soma = "+res);
    }

    static void funcSubtracao(float val1, float val2){

        float res=0;

        res=val1-val2;

        JOptionPane.showMessageDialog(null,"Subtração = "+res);
    }

    static void funcMultiplicacao(float val1, float val2){

        float res=0;

        res=val1*val2;

        JOptionPane.showMessageDialog(null,"Multiplicação = "+res);
    }

    static void funcDivisao(float val1, float val2){

        float res=0;

        res=val1/val2;

        JOptionPane.showMessageDialog(null,"Divisão = "+res);
    }
}
