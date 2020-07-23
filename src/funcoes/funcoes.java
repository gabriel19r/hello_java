package funcoes;

import javax.swing.JOptionPane;

public class funcoes {
    public static void main(String[]args){

        int num=0;
        int fatorial=0;

        num=Integer.parseInt(JOptionPane.showInputDialog("Qual é o número?"));

        fatorial=funcFatorial(num);

        JOptionPane.showMessageDialog(null,"O fatorial de "+num+" é "+fatorial);
    }

    static int funcFatorial(int num){
        int aux=1;
        for(int i=num;i>0;i--){
            aux=aux*num;
            num--;
        }
        return aux;
    }
}
