package crud;

import java.util.List;
import java.util.Scanner;
import dao.PromocaoDAO;
import modelos.Promocao;

public class PromocaoCRUD {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        PromocaoDAO promocaoDAO = new PromocaoDAO();

        int opcao = 0;

        do {
            System.out.println("\n============= PROMOÇÃO ==============\n");
            System.out.println("1- CRIAR   2- CONSULTAR   3- ATUALIZAR  4- DELETAR   5- CONSULTAR ID   0- SAIR");
            opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite os detalhes da promoção:");
                    String detalhes = s.nextLine();
                    System.out.println("Digite a data de início (AAAA-MM-DD):");
                    String dataInicio = s.nextLine();
                    System.out.println("Digite a data de término (AAAA-MM-DD):");
                    String dataFim = s.nextLine();

                    Promocao promocao = new Promocao(0, detalhes, dataInicio, dataFim);
                    promocaoDAO.create(promocao);
                    break;

                case 2:
                    List<Promocao> promocoes = promocaoDAO.read();
                    for (Promocao p : promocoes) {
                        System.out.println(p.toString());
                    }
                    break;

                case 3:
                    System.out.println("Digite o ID da promoção a ser atualizada:");
                    int idAtualizar = s.nextInt();
                    s.nextLine();
                    System.out.println("Digite os novos detalhes da promoção:");
                    String novosDetalhes = s.nextLine();
                    System.out.println("Digite a nova data de início (AAAA-MM-DD):");
                    String novaDataInicio = s.nextLine();
                    System.out.println("Digite a nova data de término (AAAA-MM-DD):");
                    String novaDataFim = s.nextLine();

                    Promocao promocaoAtualizada = new Promocao(idAtualizar, novosDetalhes, novaDataInicio, novaDataFim);
                    promocaoDAO.update(promocaoAtualizada);
                    break;

                case 4:
                    System.out.println("Digite o ID da promoção a ser excluída:");
                    int idExcluir = s.nextInt();
                    promocaoDAO.delete(idExcluir);
                    break;

                case 5:
                    System.out.println("Digite o ID da promoção a ser consultada:");
                    int idConsultar = s.nextInt();
                    Promocao promocaoConsultada = promocaoDAO.readById(idConsultar);
                    if (promocaoConsultada != null) {
                        System.out.println(promocaoConsultada.toString());
                    } else {
                        System.out.println("Promoção não encontrada.");
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
