/*
 * KELAS Kamus merupakan kelas Model, kelas ini merupakan kelas pembantu untuk
 * kelas KoreaDAO
 * ciri dari kelas ini adalah fieldnya harus sama persis dengan kolom kolom
 * table korea (No, Kamus,Lafal,Indonesia)
 * fungsi yang ada cuma getter(mendapatkan nilai)
 * dan setter(memberi nilai kedalam field)
 */

package id.web.candra.kamus.db;

/**
 *
 * @author candra
 */
public class Kamus {
private int no;
    private String korea;
    private String lafal;
    private String indonesia;

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the korea
     */
    public String getKorea() {
        return korea;
    }

    /**
     * @param korea the korea to set
     */
    public void setKorea(String korea) {
        this.korea = korea;
    }

    /**
     * @return the lafal
     */
    public String getLafal() {
        return lafal;
    }

    /**
     * @param lafal the lafal to set
     */
    public void setLafal(String lafal) {
        this.lafal = lafal;
    }

    /**
     * @return the indonesia
     */
    public String getIndonesia() {
        return indonesia;
    }

    /**
     * @param indonesia the indonesia to set
     */
    public void setIndonesia(String indonesia) {
        this.indonesia = indonesia;
    }

}
