package classes;

public class Head extends User {
    protected String password;
    protected int departmentID;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }

    public Head(String id, int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale, String password1, int departmentID) {
        super(id, userTypeId, name, email, emailVerified, password, ismale);
        this.password = password1;
        this.departmentID = departmentID;
    }
}
