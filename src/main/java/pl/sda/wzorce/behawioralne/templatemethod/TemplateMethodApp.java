package pl.sda.wzorce.behawioralne.templatemethod;


public class TemplateMethodApp {
    public static void main(String[] args) {
        MakeCarCombi makeCarCombi = new MakeCarCombi();
        MakeCarHatchback makeCarHatchback = new MakeCarHatchback();

        makeCarCombi.make();
        System.out.println("\n");
        makeCarHatchback.make();
    }
}
