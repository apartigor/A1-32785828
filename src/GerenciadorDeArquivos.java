import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GerenciadorDeArquivos {

    public List<Aluno> lerAlunos(String alunosFile) throws IOException {
        List<Aluno> alunos = new ArrayList<>();
        FileReader leitor = new FileReader(alunosFile);
        StringBuilder sb = new StringBuilder();
        int i;
        while ((i = leitor.read()) != -1) {
            sb.append((char) i);
        }
        leitor.close();
        String[] linhas = sb.toString().split("\n");
        for (int j = 1; j < linhas.length; j++) {
            String[] values = linhas[j].split(";");
            int matricula = Integer.parseInt(values[0]);
            String nome = values[1];
            double nota = Double.parseDouble(values[2]);
            alunos.add(new Aluno(matricula, nome, nota));
        }
        return alunos;
    }

    public void escreverResumo(String resumoFile, List<Aluno> alunos) throws IOException {
        int totalAlunos = alunos.size();
        int aprovados = 0;
        double menorNota = Double.MAX_VALUE;
        double maiorNota = Double.MIN_VALUE;
        double somaNotas = 0.0;

        for (Aluno aluno : alunos) {
            double nota = aluno.getNota();
            if (nota >= 6.0) {
                aprovados++;
            }
            if (nota < menorNota) {
                menorNota = nota;
            }
            if (nota > maiorNota) {
                maiorNota = nota;
            }
            somaNotas += nota;
        }

        int reprovados = totalAlunos - aprovados;
        double mediaGeral = somaNotas / totalAlunos;
        

        FileWriter escritor = new FileWriter(resumoFile);
        escritor.write("Total de Alunos;Aprovados;Reprovados;Menor Nota;Maior Nota;Media Geral\n");
        escritor.write(totalAlunos + ";" + aprovados + ";" + reprovados + ";" + menorNota + ";" + maiorNota + ";"
                + mediaGeral + "\n");
        escritor.close();
    }
}
