package pl.sda.wzorce.konstrukcyjne.builder;

// przykladowe uzycie
// Person person = new PersonBuilderFluent().withName("Janusz").withSurname("Nosacz").create();

class BuilderApp {
    public static void main(String[] args) {
        Person person = new PersonBuilderFluent().withName("Janusz").withSurname("Nosacz").create();
        System.out.println(person);
    }

    private static void lecture() {
        Person person = new Person("jan", "kowalski", -1, null);
        System.out.println(person.toString());

        PersonBuilder builder = new PersonBuilder();
        builder.setName("jacek");
        builder.setHasACar(false);
        Person personDefault = builder.create();
        System.out.println(personDefault.toString());

        // kon
        DoctorPerson gadzet = new DoctorPerson(null, "gadżet", 15, null, false, null, "123");
        System.out.println(gadzet.toString());

        DoctorPersonBuilder builder1 = new DoctorPersonBuilder();
        builder1.setSurname("gadzet");
        builder1.setAge(15);
        builder1.setUuid("123");
        DoctorPerson doctorPerson = builder1.create();
        System.out.println(doctorPerson.toString());


        PersonLombok build = PersonLombok.builder().name("sebix").build();
        System.out.println(build.toString());
    }
}
