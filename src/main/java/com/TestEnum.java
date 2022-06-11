package main.java.com;

public enum TestEnum {

    Dog("汪汪",10),
    Cat("喵喵",5),
    Cow("哞哞",17);


    private final String cName;
    private final int age;

    TestEnum(String cName, int age) {
        this.cName = cName;
        this.age = age;
    }

    public String getcName() {
        return cName;
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {

        TestEnum animal = TestEnum.valueOf("Dog");
        System.out.println(animal.getcName());
        System.out.println(animal.getAge());

        System.out.println("======================");

        for (TestEnum t : TestEnum.values() ){
            System.out.println(t.getcName());
            System.out.println(t.getAge());

        }
    }
}
