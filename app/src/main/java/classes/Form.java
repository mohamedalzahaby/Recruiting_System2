package classes;

public class Form extends TimeStamps {
    protected String name;
    protected int creatorId;
    protected int departmentId;

    public Form(String id, String name, int creatorId, int departmentId) {
        super(id);
        this.name = name;
        this.creatorId = creatorId;
        this.departmentId = departmentId;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }



}
