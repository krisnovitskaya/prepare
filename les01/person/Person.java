package les1.person;

import lombok.ToString;

@ToString
public class Person {
    private String firstName;
    private String lastName;
    private String middleName;
    private String country;
    private String address;
    private String phone;
    private int age;
    private String gender;



    public static class PersonBuilder{
        private Person person = new Person();

        public PersonBuilder firstName(String firstName){
            this.person.firstName = firstName;
            return this;
        }
        public PersonBuilder lastName(String lastName){
            this.person.lastName = lastName;
            return this;
        }
        public PersonBuilder middleName(String middleName){
            this.person.middleName = middleName;
            return this;
        }
        public PersonBuilder country(String country){
            this.person.country = country;
            return this;
        }
        public PersonBuilder address(String address){
            this.person.address = address;
            return this;
        }

        public PersonBuilder phone(String phone){
            this.person.phone = phone;
            return this;
        }

        public PersonBuilder gender(String gender){
            this.person.gender = gender;
            return this;
        }

        public PersonBuilder age(int age){
            this.person.age = age;
            return this;
        }

        public Person build(){
            return this.person;
        }
    }

}
