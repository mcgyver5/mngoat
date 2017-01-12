package dao;
import java.util.List;
import beans.BikeTire;

public interface BikeTireDAO {

    List<BikeTire> findAll();
    List<BikeTire> findById();
    List<BikeTire> findByName();
    boolean insertBikeTire(BikeTire bikeTire);
    boolean updateBikeTire(BikeTire bikeTire);
    boolean deleteBikeTire(BikeTire bikeTire);

}
