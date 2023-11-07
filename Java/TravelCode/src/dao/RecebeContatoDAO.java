package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Contato;
import modelos.Destino;
import modelos.RecebeContato;

public class RecebeContatoDAO {
    public void create(RecebeContato recebeContato) {
        System.out.println("*** CREATE RecebeContato ***");

        String sql = "INSERT INTO RecebeContato (ID_Contato, ID_Destino) VALUES (?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, recebeContato.getID_Contato().getID_Contato());
            pstm.setInt(2, recebeContato.getID_Destino().getID_Destino());

            pstm.execute();

            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    recebeContato.setID_RecebeContato(generatedKeys.getInt(1));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<RecebeContato> read() {
        List<RecebeContato> recebeContatos = new ArrayList<RecebeContato>();

        System.out.println("*** READ RecebeContato ***");

        String sql = "SELECT * FROM RecebeContato";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                RecebeContato recebeContato = new RecebeContato();

                recebeContato.setID_RecebeContato(rset.getInt("ID_RecebeContato"));

                Contato contato = new Contato();
                contato.setID_Contato(rset.getInt("ID_Contato"));
                Destino destino = new Destino();
                destino.setID_Destino(rset.getInt("ID_Destino"));

                recebeContato.setID_Contato(contato);
                recebeContato.setID_Destino(destino);

                recebeContatos.add(recebeContato);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return recebeContatos;
    }

    public void update(RecebeContato recebeContato) {
        System.out.println("*** UPDATE RecebeContato ***");

        String sql = "UPDATE RecebeContato SET ID_Contato=?, ID_Destino=? WHERE ID_RecebeContato=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, recebeContato.getID_Contato().getID_Contato());
            pstm.setInt(2, recebeContato.getID_Destino().getID_Destino());
            pstm.setInt(3, recebeContato.getID_RecebeContato());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(int idRecebeContato) {
        System.out.println("*** DELETE RecebeContato ***");

        String sql = "DELETE FROM RecebeContato WHERE ID_RecebeContato=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, idRecebeContato);

            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
