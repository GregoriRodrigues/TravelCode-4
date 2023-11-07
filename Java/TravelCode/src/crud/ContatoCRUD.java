package crud;

import java.util.List;
import java.util.Scanner;
import dao.ContatoDAO;
import modelos.Contato;

public class ContatoCRUD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        ContatoDAO contatoDAO = new ContatoDAO();
        
        int opcao = 0;
        
        do {
            System.out.println("\n============= CONTATO ==============\n");
            System.out.println("1- CRIAR   2- CONSULTAR   3- ATUALIZAR  4- DELETAR   5- CONSULTAR ID   0- SAIR");
            opcao = s.nextInt();
            s.nextLine();
            
            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome:");
                    String nome = s.nextLine();
                    System.out.println("Digite o email:");
                    String email = s.nextLine();
                    System.out.println("Digite a mensagem:");
                    String mensagem = s.nextLine();
                    System.out.println("Digite o telefone:");
                    String telefone = s.nextLine();
                    System.out.println("Digite o assunto:");
                    String assunto = s.nextLine();
                    
                    Contato contato = new Contato(0, mensagem, email, nome, telefone, assunto);
                    contatoDAO.create(contato);
                    break;
                    
                case 2:
                    List<Contato> contatos = contatoDAO.read();
                    for (Contato c : contatos) {
                        System.out.println(c.toString());
                    }
                    break;
                    
                case 3:
                    System.out.println("Digite o ID do contato a ser atualizado:");
                    int idAtualizar = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite a nova mensagem:");
                    String novaMensagem = s.nextLine();
                    System.out.println("Digite o novo email:");
                    String novoEmail = s.nextLine();
                    System.out.println("Digite o novo nome:");
                    String novoNome = s.nextLine();
                    System.out.println("Digite o novo telefone:");
                    String novoTelefone = s.nextLine();
                    System.out.println("Digite o novo assunto:");
                    String novoAssunto = s.nextLine();
                    
                    Contato contatoAtualizado = new Contato(idAtualizar, novaMensagem, novoEmail, novoNome, novoTelefone, novoAssunto);
                    contatoDAO.update(contatoAtualizado);
                    break;
                    
                case 4:
                    System.out.println("Digite o ID do contato a ser excluído:");
                    int idExcluir = s.nextInt();
                    contatoDAO.delete(idExcluir);
                    break;
                    
                case 5:
                    System.out.println("Digite o ID do contato a ser consultado:");
                    int idConsultar = s.nextInt();
                    Contato contatoConsultado = contatoDAO.readById(idConsultar);
                    if (contatoConsultado != null) {
                        System.out.println(contatoConsultado.toString());
                    } else {
                        System.out.println("Contato não encontrado.");
                    }
                    break;
                    
                default:
                    break;
            }
            
        } while (opcao != 0);
        
        System.out.println("Até mais");
        s.close();
    }
}
