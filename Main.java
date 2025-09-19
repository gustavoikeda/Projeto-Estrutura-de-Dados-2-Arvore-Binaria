//Gustavo Kiyoshi Ikeda RA: 10439179
//Jiye Huang
import java.io.File;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        File Nomes = new File("Nomes.txt); 
        Raizes rz = new Raizes();
        Floresta fl = new Floresta();
        List<No> nos = new ArrayList<>();
        boolean continuar = true;

        try (Scanner leitor = new Scanner(Nomes))
        {
            while (leitor.hasNextLine())
            {
                String linha = leitor.nextLine();
                String[] filho_pai = linha.split("\\s+");
                No filho = getOuCriaNo(filho_pai[0], nos);
                No pai = getOuCriaNo(filho_pai[1], nos);
                fl.inserir_no_arvore(filho, pai, rz);
            }
        } catch (IOException e){
            System.err.println("Arquivo nao encontrado" + e.getMessage());
        }

        while (continuar) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite os nomes das pessoas para verificar a relacao.\nDigite 'sair' para encerrar.");
            String nomes = scan.nextLine();
            if (nomes.equalsIgnoreCase("sair"))
            {
                continuar = false;
                System.out.println("Ate mais!");
            } else {
                String[] partes = nomes.split("\\s+");
                No pessoa1 = getOuCriaNo(partes[0], nos);
                No pessoa2 = getOuCriaNo(partes[1], nos);
                String resultado = fl.relacao(pessoa1, pessoa2, rz);
                System.out.println(resultado);
            }
        }
    }

    private static No getOuCriaNo(String nome, List<No> nos){
        for (No no : nos)
        {
            if (no.getNome().equals(nome))
            {
                return no;
            }
        }
        No novoNo = new No(nome);
        nos.add(novoNo);
        return novoNo;
    }
}
