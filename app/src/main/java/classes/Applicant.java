package classes;

public class Applicant extends User {


    protected int userId;



    public Applicant(String id, int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale, int userId) {
        super(id, userTypeId, name, email, emailVerified, password, ismale);
        this.userId = userId;
    }
}
