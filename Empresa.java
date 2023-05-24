import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Funcionario {
    private String nome;
    private String setor;

    public Funcionario(String nome, String setor) {
        this.nome = nome;
        this.setor = setor;
    }

    public String getNome() {
        return nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}

public class Empresa {
    private List<Funcionario> funcionarios;

    public Empresa() {
        funcionarios = new ArrayList<>();
    }

    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    public void removerFuncionario(int indice) {
        if (indice >= 0 && indice < funcionarios.size()) {
            funcionarios.remove(indice);
        } else {
            System.out.println("Índice inválido. Não foi possível remover o funcionário.");
        }
    }

    public void alterarSetorFuncionario(int indice, String novoSetor) {
        if (indice >= 0 && indice < funcionarios.size()) {
            Funcionario funcionario = funcionarios.get(indice);
            funcionario.setSetor(novoSetor);
            System.out.println("Setor do funcionário alterado com sucesso.");
        } else {
            System.out.println("Índice inválido. Não foi possível alterar o setor do funcionário.");
        }
    }

    public void exibirFuncionarios() {
        if (funcionarios.isEmpty()) {
            System.out.println("A empresa não possui funcionários.");
        } else {
            System.out.println("Funcionários da empresa:");
            for (int i = 0; i < funcionarios.size(); i++) {
                Funcionario funcionario = funcionarios.get(i);
                System.out.println(i + ". " + funcionario.getNome() + " - Setor: " + funcionario.getSetor());
            }
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;
        while (continuar) {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Adicionar funcionário");
            System.out.println("2. Remover funcionário");
            System.out.println("3. Alterar setor do funcionário");
            System.out.println("4. Exibir funcionários");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha após a leitura do número

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do funcionário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o setor do funcionário:");
                    String setor = scanner.nextLine();
                    Funcionario funcionario = new Funcionario(nome, setor);
                    empresa.adicionarFuncionario(funcionario);
                    System.out.println("Funcionário adicionado com sucesso.");
                    break;
                case 2:
                    System.out.println("Digite o índice do funcionário a ser removido:");
                    int indiceRemocao = scanner.nextInt();
                    empresa.removerFuncionario(indiceRemocao);
                    break;
                case 3:
                    System.out.println("Digite o índice do funcionário a ter o setor alterado:");
                    int indiceAlteracao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a quebra de linha após a leitura do número
                    System.out.println("Digite o novo setor do funcionário:");
                    String novoSetor = scanner.nextLine();
                    empresa.alterarSetorFuncionario(indiceAlteracao, novoSetor);
                    break;
                case 4:
                    empresa.exibirFuncionarios();
                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }
}
