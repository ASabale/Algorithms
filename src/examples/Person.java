package examples;

public class Person {
    private String name;
    private int socialSecNum;
    private Address address;
    private BirthDate date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSocialSecNum() {
        return socialSecNum;
    }

    public void setSocialSecNum(int socialSecNum) {
        this.socialSecNum = socialSecNum;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public BirthDate getDate() {
        return date;
    }

    public void setDate(BirthDate date) {
        this.date = date;
    }
}
