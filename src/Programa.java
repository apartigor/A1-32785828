import java.io.IOException;
import java.util.List;

public class Programa {

    public static void main(String[] args) {
        GerenciadorDeArquivos gerenciador = new GerenciadorDeArquivos();
        try {
            List<Aluno> listaDeAlunos = gerenciador.lerAlunos("src/alunos.csv");
            gerenciador.escreverResumo("src/resumo.csv", listaDeAlunos);
            System.out.println("Resumo gerado com sucesso!");
        } catch (IOException e) {
            System.out.println("Houve um erro ao processar os arquivos.");
        }
    }
}
