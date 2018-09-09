package zuryanov.servlets.persistent;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/**
 * @author Alexei Zuryanov (zuryanovalexei@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class MemoryStore implements Store {

    private static final MemoryStore MEMORY_STORE = new MemoryStore();
    private MemoryStore() {

    }

    public static MemoryStore getInstance() {
        return MEMORY_STORE;
    }

    private List<String> userStore = new CopyOnWriteArrayList<>();
    @Override
    public void add(String name) {
        userStore.add(name);
    }

    @Override
    public String update(int id, String name, String country, String city) {
        return userStore.set(id, name);
    }

    @Override
    public String delete(int id) {
        return userStore.remove(id);
    }

    @Override
    public List<String> findAll() {
        List<String> result = new CopyOnWriteArrayList<>();
        for (String user : userStore) {
                result.add(user);
        }
        return result;
    }

    @Override
    public String findById(int id) {
        return userStore.get(id);
    }

    @Override
    public int sizeStore() {
        return userStore.size();
    }
}
