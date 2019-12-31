package classes;

public class Applicant {
    private String ID,uniID,name,email,mobile,gender,adrs,faculty,committee,to,from,date;

    public Applicant() {
    }

    public Applicant(String ID, String uniID, String name, String email, String mobile, String gender, String adrs, String faculty, String committee, String to, String from, String date) {
        this.ID = ID;
        this.uniID = uniID;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.gender = gender;
        this.adrs = adrs;
        this.faculty = faculty;
        this.committee = committee;
        this.to = to;
        this.from = from;
        this.date = date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUniID() {
        return uniID;
    }

    public void setUniID(String uniID) {
        this.uniID = uniID;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAdrs() {
        return adrs;
    }

    public void setAdrs(String adrs) {
        this.adrs = adrs;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCommittee() {
        return committee;
    }

    public void setCommittee(String committee) {
        this.committee = committee;
    }
}
