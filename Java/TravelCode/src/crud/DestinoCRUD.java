package crud;

import java.util.List;
import java.util.Scanner;
import dao.DestinoDAO;
import modelos.Destino;

public class DestinoCRUD {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        DestinoDAO destinoDAO = new DestinoDAO();

        int opcao = 0;

        do {
            System.out.println("\n============= DESTINO ==============\n");
            System.out.println("1- CRIAR   2- CONSULTAR   3- ATUALIZAR  4- DELETAR   5- CONSULTAR ID   0- SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do destino:");
                    String nomeDestino = s.nextLine();
                    System.out.println("Digite a descrição:");
                    String descricao = s.nextLine();
                    System.out.println("Digite o ID da promoção:");
                    int idPromocao = s.nextInt();

                    Destino destino = new Destino(0, nomeDestino, descricao, idPromocao);
                    destinoDAO.create(destino);
                    break;

                case 2:
                    List<Destino> destinos = destinoDAO.read();
                    for (Destino d : destinos) {
                        System.out.println(d.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID do destino a ser atualizado:");
                    int idAtualizar = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite o novo nome do destino:");
                    String novoNomeDestino = s.nextLine();
                    System.out.println("Digite a nova descrição:");
                    String novaDescricao = s.nextLine();
                    System.out.println("Digite o novo ID da promoção:");
                    int novoIdPromocao = s.nextInt();

                    Destino destinoAtualizado = new Destino(idAtualizar, novoNomeDestino, novaDescricao, novoIdPromocao);
                    destinoDAO.update(destinoAtualizado);
                    break;

                case 4:
                    System.out.println("Digite o ID do destino a ser excluído:");
                    int idExcluir = s.nextInt();
                    destinoDAO.delete(idExcluir);
                    break;

                case 5:
                    System.out.println("Digite o ID do destino a ser consultado:");
                    int idConsultar = s.nextInt();
                    Destino destinoConsultado = destinoDAO.readById(idConsultar);
                    if (destinoConsultado != null) {
                        System.out.println(destinoConsultado.toString());
                    } else {
                        System.out.println("Destino não encontrado.");
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
