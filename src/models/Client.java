package models;

public class Client {
    private String name;
    private String cpf;
    private int age;

    // Construtor
    public Client(String name, String cpf, int age) {
        this.name = name;
        this.cpf = cpf;
        this.age = age;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public int getAge() {
        return age;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void displayInfo() {
        System.out.println("Client: " + name);
        System.out.println("CPF: " + cpf);
        System.out.println("Age: " + age);
    }
}
