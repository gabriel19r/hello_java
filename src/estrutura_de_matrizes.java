import javax.swing.JOptionPane;

public class estrutura_de_matrizes {
    public static void main(String[]args){

        final int provas=3;
        final int alunos=5;

        float[][]notaProva=new float[alunos][provas];

        float[]medAlunos=new float[alunos];
        float[]medProvas=new float[provas];

        float soma;
        String aux;

        try{

            for(int i=0;i<alunos;i++){
                soma=0;
                for(int j=0;j<provas;j++){
                    aux=JOptionPane.showInputDialog(null,"Digite a nota do aluno: "+(i+1)+" - prova: "+(j+1));
                    notaProva[i][j]=Float.parseFloat(aux);
                    soma=soma+notaProva[i][j];
                }
                medAlunos[i]=soma/provas;
            }

            for(int i=0;i<provas;i++) {
                soma=0;
                for (int j = 0; j < alunos; j++) {
                    soma=soma+notaProva[j][i];
                }
                medProvas[i]=soma/alunos;
            }

            for(int i=0;i<alunos;i++){
                JOptionPane.showMessageDialog(null,"Média do aluno: "+(i+1)+"/"+medAlunos[i]);
            }

            for(int i=0;i<provas;i++){
                JOptionPane.showMessageDialog(null, "Média da prova: "+(i+1)+"/"+medProvas[i]);
            }

        }catch(Exception e){

            JOptionPane.showMessageDialog(null,"Ocorreu um erro durante a leitura!");
        }



    }
}
