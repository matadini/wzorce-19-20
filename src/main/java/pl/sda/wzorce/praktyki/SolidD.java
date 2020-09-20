package pl.sda.wzorce.praktyki;

class SolidD {

    class Bad {
        String name;
        String surname;

        Bad() {
            name = "Jan";
            surname = "Kowalski";
        }
    }

    class Good {
        String name;
        String surname;

        public Good(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }
    }

    public static void main(String[] args) {


    }
}
