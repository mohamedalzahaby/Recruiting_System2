package classes;

public class Question extends TimeStamps {

    protected String name;
    protected String dataType;
    protected String creatorId;
    protected String formId;

    public Question(String name, String dataType, String creatorId, String formId) {
        this.name = name;
        this.dataType = dataType;
        this.creatorId = creatorId;
        this.formId = formId;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}



