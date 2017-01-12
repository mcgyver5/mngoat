package dao;
import java.util.List;
import beans.BikePart;

public interface BikePartDAO {

    List<BikePart> findAll();
    List<BikePart> findById();
    List<BikePart> findByName();
    boolean insertBikePart(BikePart bikePart);
    boolean updateBikePart(BikePart bikePart);
    boolean deleteBikePart(BikePart bikePart);

}
