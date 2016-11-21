package dao;

import java.util.List;

import beans.Hint;

public interface HintDAO {

    List<Hint> findAll();
    List<Hint> findById();
    List<Hint> findByName(String name);
    boolean deleteById(int Id);
    boolean insertHint(Hint hint);
    boolean updateHint(Hint hint);
    boolean deleteHint(Hint hint);
}
