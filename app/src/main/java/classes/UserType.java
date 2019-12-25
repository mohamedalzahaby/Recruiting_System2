package classes;

public class UserType extends TimeStamps{
    protected String name;

    public UserType(String id, String name, int parentId) {
        super(id);
        this.name = name;
        this.parentId = parentId;
    }

    protected int parentId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }




}
