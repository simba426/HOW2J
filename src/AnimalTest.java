public class AnimalTest {

}

interface Pet {
    String getName();
    void setName(String name);
    void play();
}

abstract class Animal {
    protected int leg;

    protected Animal(int leg) {
        this.leg = leg;
    }

    abstract void eat();

    public void walk() {
        System.out.println("Walk with " + this.leg + " legs.");
    }
}

class Spider extends Animal {
    public Spider() {
        super(8);
    }

    public void eat() {
        System.out.println("Spider eat!");
    }
}

class Cat extends Animal implements Pet {
    String name;
    public Cat(String name) {
        super(4);
        this.name = name;
    }

    public Cat() {
        this("");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void eat() {
        System.out.println("Cat eat.");
    }

    public void play() {
        System.out.println("Cat play.");
    }
}

class Fish extends Animal implements Pet{
    private String name;
    public Fish() {
        super(0);
        this.name = "";
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void walk() {
        System.out.println("Can't walk");
    }

    public void eat() {
        System.out.println("Fish eat");
    }

    public void play() {
        System.out.println("Cat play");
    }
}
