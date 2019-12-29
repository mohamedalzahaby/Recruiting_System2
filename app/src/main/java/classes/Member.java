package classes;

public class Member extends User {

    protected int departmentID;

    public Member(String id, int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale) {
        super(id, userTypeId, name, email, emailVerified, password, ismale);
    }

    public Member(int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale) {
        super(userTypeId, name, email, emailVerified, password, ismale);
    }

    public int getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(int departmentID) {
        this.departmentID = departmentID;
    }


}
