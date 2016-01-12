/*
 * kelas KamusDAO
 * kelas ini beisi operasi utama (CRUD)
 * insert update delete tampil dan cari
 * kelas ini merupakan kelas inti untuk pengolahan data di
 * tabel korea
 */
package id.web.candra.kamus.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KamusDAO {

    public Connection connection;

    public KamusDAO(Connection connection) {
        this.connection = connection;
    }

    public void insert(Kamus k) throws SQLException {
        String sql = "insert into korea (korea,lafal,indonesia) "
                + "values (?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);

        ps.setString(1, k.getKorea());
        ps.setString(2, k.getLafal());
        ps.setString(3, k.getIndonesia());


        ps.executeUpdate();
    }

    public void update(int no, Kamus k) throws SQLException {
        String sql = "update korea set korea.korea=?,korea.lafal=?,korea.indonesia=? where no=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, k.getKorea());
        ps.setString(2, k.getLafal());
        ps.setString(3, k.getIndonesia());
        ps.setInt(4, no);


        ps.executeUpdate();
    }

    public void delete(int no) throws SQLException {
        String sql = "delete from korea where no=?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, no);

        ps.executeUpdate();
    }

    public List<Kamus> selectAll() throws SQLException {
        String sql = "select * from korea";

        PreparedStatement ps = connection.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        List<Kamus> list = new ArrayList<Kamus>();

        while (rs.next()) {
            Kamus k = new Kamus();
            k.setNo(rs.getInt(1));
           k.setKorea(rs.getString(2));
            k.setLafal(rs.getString(3));
            k.setIndonesia(rs.getString(4));

            list.add(k);
        }
        return list;
    }
/*
    public List<Korea> selectAllByNo(int no) throws SQLException {
        String sql = "select no,korea,lafal,indonesia from koreatbl where no like ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + no + "%");
        ResultSet rs = ps.executeQuery();
        List<Korea> list = new ArrayList<Korea>();

        while (rs.next()) {
            Kamus k = new Kamus();
            k.setNo(rs.getInt("no"));
            k.setKorea(rs.getString("korea"));
            k.setKorea(rs.getString("lafal"));
            k.setKorea(rs.getString("indonesia"));

            list.add(k);
        }
        return list;
    }
*/
    /*
     * Fungsi ini dipakai saat melakukan pencarian kamus di form utama
     * perhaikan sqlnya
     */
    public List<Kamus> selectAllByIndonesian(String indo) throws SQLException {
        String sql = "select * from korea where indonesia like ?";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, "%" + indo + "%");
        ResultSet rs = ps.executeQuery();
        List<Kamus> list = new ArrayList<Kamus>();

        while (rs.next()) {

            Kamus k = new Kamus();
            k.setNo(rs.getInt(1));
            k.setKorea(rs.getString(2));
            k.setLafal(rs.getString(3));
            k.setIndonesia(rs.getString(4));

            list.add(k);
        }
        return list;
    }
}
