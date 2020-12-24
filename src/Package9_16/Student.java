package Package9_16;

public class Student {
    private Long id;
    private String username;
    private Address address;

    public Student() {
    }

    public Address getAddress() {
        return address;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Student(Long id, String username, Address address) {
        this.id = id;
        this.username = username;
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", address=" + address.toString1() +
                '}';
    }
}

class Address{
    private String country;
    private String province;
    private String city;

    public Address(String country, String province, String city) {
        this.country = country;
        this.province = province;
        this.city = city;
    }

    @Override
    public String toString() {
        return country+"-"+province+"-"+city;
    }

    public String toString1() {
        return "{" +
                "country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
