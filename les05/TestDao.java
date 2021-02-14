package les05;

public class TestDao {

    public static void main(String[] args) {
        Dao<Film, Long> dao = new Dao<>(Film.class, Long.class);
        Film film = dao.findById(22L);
        System.out.println(film);
        System.out.println(dao.findAll());
        Film f1 = new Film();
        f1.setTitle("Test");
        System.out.println(dao.save(f1));
        dao.deleteById(8L);
        System.out.println(dao.findAll());
        dao.close();
    }
}
