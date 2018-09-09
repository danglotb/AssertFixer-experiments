package zuryanov.servlets.logic;

import zuryanov.servlets.persistent.DBStore;
import zuryanov.servlets.persistent.Store;

import java.util.List;
/**
 * @author Alexei Zuryanov (zuryanovalexei@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ValidateService implements Validate {

    private final Store logic = DBStore.getInstance();


    private static final ValidateService VALIDATE_SERVICE = new ValidateService();
    private ValidateService() {
    }

    public static ValidateService getInstance() {
        return VALIDATE_SERVICE;
    }

    @Override
    public String add(String name, String country, String city) {
        ((DBStore) logic).add(name, country, city);
        return name;
    }

    @Override
    public String update(int id, String name, String country, String city) {
        return logic.update(id, name, country, city);
    }

    @Override
    public String delete(int id) {
        return logic.delete(id);
    }

    @Override
    public List<String> findAll() {
        return logic.findAll();
    }

    @Override
    public String findById(int id) {
        return logic.findById(id);
    }

    public int findByName(String name) {
        return ((DBStore) logic).findByName(name);
    }

    public String findCityById(int id) {
        return  ((DBStore) logic).findCityById(id);
    }

    public String findCountryById(int id) {
        return  ((DBStore) logic).findCountryById(id);
    }

    public boolean isCredentional(String login, String password) {
        return ((DBStore) logic).isCredentional(login, password);
    }

    public List<String> findRole() {
        return ((DBStore) logic).findRole();
    }
    public List<String> findCountry() {
        return ((DBStore) logic).findCountry();
    }
    public List<String> findCity() {
        return ((DBStore) logic).findCity();
    }

}
