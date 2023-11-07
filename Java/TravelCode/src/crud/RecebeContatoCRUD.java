package crud;

import dao.RecebeContatoDAO;
import modelos.Contato;
import modelos.Destino;
import modelos.RecebeContato;

import java.util.List;
import java.util.Scanner;

public class RecebeContatoCRUD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        RecebeContatoDAO recebeContatoDAO = new RecebeContatoDAO();

        int opcao = 0;

        do {
            System.out.println("\n============= RECEBE CONTATO ==============\n");
            System.out.println("1- CRIAR   2- CONSULTAR   3- ATUALIZAR  4- DELETAR   0- SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o ID do contato:");
                    int contatoId = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o ID do destino:");
                    int destinoId = s.nextInt();

                    // Crie instâncias de Contato e Destino com os IDs fornecidos
                    Contato contato = new Contato();
                    contato.setID_Contato(contatoId);
                    Destino destino = new Destino();
                    destino.setID_Destino(destinoId);

                    // Crie uma instância de RecebeContato com as instâncias de Contato e Destino
                    RecebeContato recebeContato = new RecebeContato();
                    recebeContato.setID_Contato(contato);
                    recebeContato.setID_Destino(destino);

                    // Agora você pode salvar o RecebeContato no banco de dados
                    recebeContatoDAO.create(recebeContato);
                    break;

                case 2:
                    List<RecebeContato> recebeContatos = recebeContatoDAO.read();
                    for (RecebeContato rc : recebeContatos) {
                        System.out.println(rc.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o novo ID do Contato:");
                    int novoContatoId = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o novo ID do Destino:");
                    int novoDestinoId = s.nextInt();

                    // Crie instâncias de Contato e Destino com os novos IDs fornecidos
                    Contato novoContato = new Contato();
                    novoContato.setID_Contato(novoContatoId);
                    Destino novoDestino = new Destino();
                    novoDestino.setID_Destino(novoDestinoId);

                    // Crie uma instância de RecebeContato com as novas instâncias de Contato e Destino
                    RecebeContato recebContatoAtualizado = new RecebeContato();
                    recebContatoAtualizado.setID_Contato(novoContato);
                    recebContatoAtualizado.setID_Destino(novoDestino);

                    // Agora você pode atualizar o RecebeContato no banco de dados
                    recebeContatoDAO.update(recebContatoAtualizado);
                    break;

                case 4:
                    System.out.println("Digite o ID do RecebeContato a ser excluído:");
                    int idExcluir = s.nextInt();
                    recebeContatoDAO.delete(idExcluir);
                    break;

                default:
                    break;
            }
        } while (opcao != 0);

        System.out.println("Até mais");
        s.close();
    }
}
