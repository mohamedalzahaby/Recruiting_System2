package classes;

public class Board extends TimeStamps{

    private String name;
    private String startDate;
    private String EndDate;


    public Board(String id, String name, String startDate, String endDate) {
        super(id);
        this.name = name;
        this.startDate = startDate;
        EndDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}
