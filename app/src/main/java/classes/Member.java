package classes;

public class Member {
    String ID,Committee,Adrs,Gender,Fac,Name,Mobile,UniID,Email;

    public Member() {
    }

    public Member(String ID, String committee, String adrs, String gender, String fac, String name, String mobile, String uniID, String email) {
        this.ID = ID;
        Committee = committee;
        Adrs = adrs;
        Gender=gender;
        Fac = fac;
        Name = name;
        Mobile = mobile;
        UniID = uniID;
        Email = email;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setCommittee(String committee) {
        Committee = committee;
    }

    public void setAdrs(String adrs) {
        Adrs = adrs;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public void setFac(String fac) {
        Fac = fac;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public void setUniID(String uniID) {
        UniID = uniID;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getID() {
        return ID;
    }

    public String getCommittee() {
        return Committee;
    }

    public String getAdrs() {
        return Adrs;
    }

    public String getGender() {
        return Gender;
    }

    public String getFac() {
        return Fac;
    }

    public String getName() {
        return Name;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getUniID() {
        return UniID;
    }

    public String getEmail() {
        return Email;
    }
}
