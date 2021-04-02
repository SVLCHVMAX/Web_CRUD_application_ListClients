package app.model;

/**
 * Класс модэль клиента
 */

public class Client extends BaseModel {

    private String lastName;
    private String name;
    private String middleName;
    private String email;
    private String telNumber;

    public Client() {

    }

    public Client(String lastName, String name, String middleName, String email, String telNumber) {
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.email = email;
        this.telNumber = telNumber;
    }

    public Client(int id, String lastName, String name, String middleName, String email, String telNumber) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.middleName = middleName;
        this.email = email;
        this.telNumber = telNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", middleName='" + middleName + '\'' +
                ", email='" + email + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
