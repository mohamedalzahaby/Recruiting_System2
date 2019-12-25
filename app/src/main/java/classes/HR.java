package classes;

public class HR extends User {
    public HR(String id, int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale) {
        super(id, userTypeId, name, email, emailVerified, password, ismale);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    protected String password;


}
