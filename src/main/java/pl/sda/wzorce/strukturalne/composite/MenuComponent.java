package pl.sda.wzorce.strukturalne.composite;


import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class MenuComponent {

    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}

@AllArgsConstructor
class MenuItem extends MenuComponent {
    String name;
    String description;


    public String getName() {
        return name;
    }

    public void print() {
        System.out.print("  " + getName());
    }
}

class Menu extends MenuComponent {
    List<MenuComponent> menuComponents = new ArrayList();
    String name;
    String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void add(MenuComponent menuComponent) {
        menuComponents.add(menuComponent);
    }

    public void remove(MenuComponent menuComponent) {
        menuComponents.remove(menuComponent);
    }

    public MenuComponent getChild(int i) {
        return menuComponents.get(i);
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void print() {
        System.out.print("\n" + getName());
        System.out.println(", " + getDescription());
        System.out.println("---------------------");

        Iterator iterator = menuComponents.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuComponent = (MenuComponent)iterator.next();
            menuComponent.print();
        }
    }
}

class CompositeApp {

    public static void main(String[] args) {


        Menu file = new Menu("File", "File list");
        file.add(new MenuItem("New", "New File"));
        file.add(new MenuItem("Open", "Open File"));
        file.add(new MenuItem("Save", "Save File"));

        Menu settings = new Menu("Settings", "Settings list");
        settings.add(new MenuItem("JDK", "JDK Settings"));

        file.add(settings);

        file.print();



    }

}



