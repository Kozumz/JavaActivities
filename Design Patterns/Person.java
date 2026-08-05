//Ejercicio para practicar el patron Builder

public class Person {
    String streetAddress, city, companyName, position;

    @Override
    public String toString() {
        return "Person{streetAddress='" + streetAddress + "', city='" + city +
                "', companyName='" + companyName + "', position='" + position + "'}";
    }

    public static class PersonBuilder {
        protected Person p = new Person();

        public PersonAddressBuilder lives() {
            return new PersonAddressBuilder(this.p);

        }

        public PersonJobBuilder works() {
            return new PersonJobBuilder(this.p);
        }

        public Person build() {
            return p;
        }

        public static class PersonAddressBuilder extends PersonBuilder {
            PersonAddressBuilder(Person p) {
                this.p = p;
            }

            public PersonAddressBuilder at(String streetAddress) {
                this.p.streetAddress = streetAddress;
                return this;
            }

            public PersonAddressBuilder in(String city) {
                this.p.city = city;
                return this;
            }
        }

        public static class PersonJobBuilder extends PersonBuilder {
            PersonJobBuilder(Person p) {
                this.p = p;
            }

            public PersonJobBuilder at(String companyName) {
                this.p.companyName = companyName;
                return this;
            }

            public PersonJobBuilder asA(String position) {
                this.p.position = position;
                return this;
            }
        }

    }

    public static void main(String[] args) {
        Person person = new Person.PersonBuilder()
                .lives()
                .at("Av. Patria 123")
                .in("Zapopan")
                .works()
                .at("IBM")
                .asA("Junior Developer")
                .build();

        System.out.println(person);
    }
}
