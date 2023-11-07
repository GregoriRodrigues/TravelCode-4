package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelos.Destino;
import connection.ConnectionMySQL;

public class DestinoDAO {
    public void create(Destino destino) {
        System.out.println("*** CREATE ***");

        String sql = "INSERT INTO Destino (Nome_Destino, Descricao, ID_Promocao) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstm.setString(1, destino.getNome_Destino());
            pstm.setString(2, destino.getDescricao());
            pstm.setInt(3, destino.getID_Promocao());

            pstm.execute();

            try (ResultSet generatedKeys = pstm.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    destino.setID_Destino(generatedKeys.getInt(1));
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

    public List<Destino> read() {
        List<Destino> destinos = new ArrayList<Destino>();

        System.out.println("*** READ ***");

        String sql = "SELECT * FROM Destino";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            rset = pstm.executeQuery();

            while (rset.next()) {
                Destino destino = new Destino();

                destino.setID_Destino(rset.getInt("ID_Destino"));
                destino.setNome_Destino(rset.getString("Nome_Destino"));
                destino.setDescricao(rset.getString("Descricao"));
                destino.setID_Promocao(rset.getInt("ID_Promocao"));

                destinos.add(destino);
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

        return destinos;
    }

    public void update(Destino destino) {
        System.out.println("*** UPDATE ***");

        String sql = "UPDATE Destino SET Nome_Destino=?, Descricao=?, ID_Promocao=? WHERE ID_Destino=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setString(1, destino.getNome_Destino());
            pstm.setString(2, destino.getDescricao());
            pstm.setInt(3, destino.getID_Promocao());
            pstm.setInt(4, destino.getID_Destino());

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

    public void delete(int id) {
        System.out.println("*** DELETE ***");

        String sql = "DELETE FROM Destino WHERE ID_Destino=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

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

    public Destino readById(int id) {
        System.out.println("*** READ BY ID ***");

        String sql = "SELECT * FROM Destino WHERE ID_Destino=?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Destino destino = new Destino();

        try {
            conn = ConnectionMySQL.createConnectionMySQL();

            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            rset = pstm.executeQuery();

            while (rset.next()) {
                destino.setID_Destino(rset.getInt("ID_Destino"));
                destino.setNome_Destino(rset.getString("Nome_Destino"));
                destino.setDescricao(rset.getString("Descricao"));
                destino.setID_Promocao(rset.getInt("ID_Promocao"));
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

        return destino;
    }
}
