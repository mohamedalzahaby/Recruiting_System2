package classes;

public class Question extends TimeStamps {

    protected String name;
    protected int dataType;
    protected int creatorId;
    protected int formId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public int getFormId() {
        return formId;
    }

    public void setFormId(int formId) {
        this.formId = formId;
    }

    public Question(String id, String name, int dataType, int creatorId, int formId) {
        super(id);
        this.name = name;
        this.dataType = dataType;
        this.creatorId = creatorId;
        this.formId = formId;
    }
}
