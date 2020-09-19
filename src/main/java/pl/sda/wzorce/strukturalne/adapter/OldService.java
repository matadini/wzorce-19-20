package pl.sda.wzorce.strukturalne.adapter;

class OldService {

    int sum(int[] t) {
        int sum = 0;
        for (int i = 0; i < t.length; ++i) {
            sum += t[i];
        }
        return sum;
    }

    void showPerson(String name, String surname) {
        String x = "Wyswietlam w cudowny sposob dane osoby "
                + name
                + " "
                + surname;
        System.out.println(x);
    }
}
