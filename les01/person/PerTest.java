package les1.person;

public class PerTest {
    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .firstName("Anton")
                .lastName("Vasilkov")
                .age(22)
                .address("Moscow")
                .middleName("Alekseevich")
                .gender("male")
                .phone("12346789")
                .country("Russia")
                .build();

        System.out.println(person);
    }
}
