package classes;

public class User extends TimeStamps {

    protected int userTypeId;
    protected String name;
    protected String email;
    protected String universityCard;
    protected boolean emailVerified;
    protected boolean ismale;

    public String getUniversityCard() {
        return universityCard;
    }

    public void setUniversityCard(String universityCard) {
        this.universityCard = universityCard;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public boolean isIsmale() {
        return ismale;
    }

    public void setIsmale(boolean ismale) {
        this.ismale = ismale;
    }


    public User(String id, int userTypeId, String name, String email, boolean emailVerified, String password, boolean ismale) {
        super(id);
        this.userTypeId = userTypeId;
        this.name = name;
        this.email = email;
        this.emailVerified = emailVerified;
        this.ismale = ismale;
        this.universityCard = universityCard;
    }




}
