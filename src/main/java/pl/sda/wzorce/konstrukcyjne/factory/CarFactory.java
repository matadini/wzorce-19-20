package pl.sda.wzorce.konstrukcyjne.factory;

class CarFactory {

    static Car create(String vim, Car.Type type) {
        // udaje odpytanie do serwisu 1 ktory zwroci true
        boolean insurance = true;


        // udaje odpytanie do serwisu 2 ktory zwroci qwerty
        String carCode = "qwerty";
        if (type.equals(Car.Type.AUDI)) {
            carCode="audi_audio";
        }

        return new Car(vim, carCode, type, insurance);
    }
}

