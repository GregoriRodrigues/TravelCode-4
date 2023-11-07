package dao;

import connection.ConnectionMySQL;
import modelos.Promocao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PromocaoDAO {
    public void create(Promocao promocao) {
        String sql = "INSERT INTO Promocao (ID_Promocao, Detalhes_Promocao, Data_Inicio, Data_Fim) VALUES (?,?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, promocao.getID_Promocao());
            pstm.setString(2, promocao.getDetalhes_Promocao());
            pstm.setString(3, promocao.getData_Inicio());
            pstm.setString(4, promocao.getData_Fim());

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

    public List<Promocao> read() {
        List<Promocao> promocoes = new ArrayList<>();

        String sql = "SELECT * FROM Promocao";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Promocao promocao = new Promocao();
                promocao.setID_Promocao(rset.getInt("ID_Promocao"));
                promocao.setDetalhes_Promocao(rset.getString("Detalhes_Promocao"));
                promocao.setData_Inicio(rset.getString("Data_Inicio"));
                promocao.setData_Fim(rset.getString("Data_Fim"));
                promocoes.add(promocao);
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

        return promocoes;
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET Detalhes_Promocao=?, Data_Inicio=?, Data_Fim=? WHERE ID_Promocao=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, promocao.getDetalhes_Promocao());
            pstm.setString(2, promocao.getData_Inicio());
            pstm.setString(3, promocao.getData_Fim());
            pstm.setInt(4, promocao.getID_Promocao());

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
        String sql = "DELETE FROM Promocao WHERE ID_Promocao=?";

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

    public Promocao readById(int id) {
        String sql = "SELECT * FROM Promocao WHERE ID_Promocao=?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Promocao promocao = new Promocao();

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            while (rset.next()) {
                promocao.setID_Promocao(rset.getInt("ID_Promocao"));
                promocao.setDetalhes_Promocao(rset.getString("Detalhes_Promocao"));
                promocao.setData_Inicio(rset.getString("Data_Inicio"));
                promocao.setData_Fim(rset.getString("Data_Fim"));
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

        return promocao;
    }
}
