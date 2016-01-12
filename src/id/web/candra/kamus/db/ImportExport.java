/*
 * Kelas Export import
 * kelas ini bertugas untuk memexport data dari tabel korea
 * dan mengimport data ke table korea
 */

package id.web.candra.kamus.db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;



public class ImportExport
{
    public ImportExport()
    {
    }

 
    public boolean importData(Connection conn,String filename)
    {
        Statement stmt;
        String query;

        try
        {
             stmt = conn.createStatement();
           // stmt = conn.createStatement(
  //  ResultSet.TYPE_SCROLL_SENSITIVE,
  //  ResultSet.CONCUR_UPDATABLE);

      //      query = "LOAD DATA INFILE '"+filename+
   // "' INTO TABLE korea(korea,lafal,indonesia);";
              query="LOAD DATA INFILE '" + filename +
                "' INTO TABLE korea  FIELDS TERMINATED BY ',' ENCLOSED BY '\"' ESCAPED BY '\\\\' LINES TERMINATED BY '\r\n\' ";

            stmt.executeUpdate(query);
                return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            stmt = null;
            return false;
        }
    }
    /*
     * fungsi untuk mengexport table, kebalikan dari import
     * perhatkan kata into OUTFILE.
     * secara default , mysql akan menampilkan ke layar namun parameter
     * outfile mengarahkan output bukan ke layar namun ke file dengan format
     * CSV, coma separated value
     */
    public boolean exportData(Connection conn,String filename) {
        Statement stmt;
        String query;
        try {
            stmt = conn.createStatement();
                  //  ResultSet.TYPE_SCROLL_SENSITIVE,
                   // ResultSet.CONCUR_UPDATABLE);
            
            //For comma separated file
          //  query = "SELECT korea,lafal,indonesia into OUTFILE  '"+filename+
            //        "' FIELDS TERMINATED BY ','  FROM korea t";

             query = "SELECT * into OUTFILE  '"+filename+"'  FIELDS TERMINATED BY ',' LINES TERMINATED BY '\r\n' FROM korea";
            stmt.executeQuery(query);
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            stmt = null;
            return false;
        }
    }

        public boolean emptyData(Connection conn)
    {
        Statement stmt;
        String query;

        try
        {
            stmt = conn.createStatement(
    ResultSet.TYPE_SCROLL_SENSITIVE,
    ResultSet.CONCUR_UPDATABLE);

            query = "TRUNCATE TABLE  korea";

            stmt.executeUpdate(query);
            return true;

        }
        catch(Exception e)
        {
            e.printStackTrace();
            stmt = null;
            return false;
        }
    }
}