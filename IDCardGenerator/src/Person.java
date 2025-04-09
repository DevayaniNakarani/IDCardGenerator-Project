public class Person {
    private String name, age, department, year, bloodGroup, address, mobile;
    private String imagePath;

    public Person(String name, String age, String department, String year, String bloodGroup,
                  String address, String mobile, String imagePath) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.year = year;
        this.bloodGroup = bloodGroup;
        this.address = address;
        this.mobile = mobile;
        this.imagePath = imagePath;
    }

    // Getters
    public String getName() { return name; }
    public String getAge() { return age; }
    public String getDepartment() { return department; }
    public String getYear() { return year; }
    public String getBloodGroup() { return bloodGroup; }
    public String getAddress() { return address; }
    public String getMobile() { return mobile; }
    public String getImagePath() { return imagePath; }
}
