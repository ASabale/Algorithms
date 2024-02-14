package examples;

public class test {
    public static void main(String[] args) {
//        testPerson();
        testLinkedList();

    }

    private static void testLinkedList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);


        LinkedList list = new LinkedList();

        list.head = node1;
        node1.nextNode = node2;
        node2.nextNode = node3;

        list.print();
    }

    private static void testPerson() {
        BirthDate kishuuBirthdate = new BirthDate();
        kishuuBirthdate.setDay(15);
        kishuuBirthdate.setMonth(BirthDate.month.MAY);
        kishuuBirthdate.setYear(2002);

        Address kishuuAddress = new Address();
        kishuuAddress.setApartment(386);
        kishuuAddress.setCity("Arlington");
        kishuuAddress.setState("Texas");
        kishuuAddress.setStreet("601 summit ave");
        kishuuAddress.setPincode(76013);

        //initialised a reference
        Person kishuu;

        //memory allocation
        kishuu = new Person();

        //fill up the details
        kishuu.setName("Krishna Patel");
        kishuu.setSocialSecNum(123_45_678);
        kishuu.setAddress(kishuuAddress);
        kishuu.setDate(kishuuBirthdate);

        //at this point we have created a person with all information. now we can use it the way we want to.


        System.out.println("The name of person is " + kishuu.getName() + ". Her social security number is " +
                kishuu.getSocialSecNum() + ".");
        System.out.println(kishuu.getName() + " is living in apartment number " + kishuu.getAddress().getApartment() + ".");
        System.out.println("Full address is: " + kishuu.getAddress().getApartment() + "," + kishuu.getAddress().getStreet()
                + "," + kishuu.getAddress().getCity() + "," + kishuu.getAddress().getState()
                + "," + kishuu.getAddress().getPincode()+  ".");
        System.out.println("Her birth date is " + kishuu.getDate().getDay() + "-" +kishuu.getDate().getMonth()
                + "-" + kishuu.getDate().getYear() + "." );
    }
}
