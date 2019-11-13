package coop.sft;

public class Person {

// TODO: decide if we can use different data types in java template for our date variables
// TODO: fields must be added to the ui form
// TODO: add Actual-End-Date, Evaluation-1-Due-Date, Evaluation-1-Submitted-On,
// TODO: add Evaluation-2-Due-Date, Evaluation-2-Submitted-On, Timesheet-Due-Date, Timesheet-Submitted-On,
// TODO: add Contact-Number, Follow-ups, Pass-Fail-Entered, Attendance-Entered, Office-Manager, Placement-Coordinator
// TODO: ensure all fields are accounted for


    private String firstName;
    private String lastName;
    private String course;
    private String batch;
    private String year;
    private String coopHost;
    private String startDate;
    private String endDate;
    private String projectName;
    private String coopPlacement;
    private String wsib;
    private String placement;
    private String insurance;
    private String contractSignedOn;
    private String contactAdd;
    private String workAdd;


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setCourse(String course) {
        this.course = course;
    }
    public void setBatch(String batch) {
        this.batch = batch;
    }
    public void setYear(String year) { this.year = year; }
    public void setCoopHost(String coopHost) { this.coopHost = coopHost; }
    public void setStartDate(String startDate) { this.startDate = startDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }
    public void setProjectName(String projectName) { this.projectName = projectName; }
    public void setCoopPlacement(String coopPlacement) { this.coopPlacement = coopPlacement; }
    public void setWsib(String wsib) { this.wsib = wsib; }
    public void setPlacement(String placement) { this.placement = placement; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
    public void setContractSignedOn(String contractSignedOn){ this.contractSignedOn = contractSignedOn; }
    public void setContactAdd(String contactAdd) { this.contactAdd = contactAdd; }
    public void setWorkAdd(String workAdd) { this.workAdd = workAdd; }


    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getCourse() {
        return course;
    }
    public String getBatch() { return batch; }
    public String getYear() { return year; }
    public String getCoopHost() { return coopHost; }
    public String getStartDate() { return startDate; }
    public String getEndDate() { return endDate; }
    public String getProjectName() { return projectName; }
    public String getCoopPlacement() { return coopPlacement; }
    public String getWsib() { return wsib; }
    public String getPlacement() { return placement; }
    public String getInsurance() { return insurance; }
    public String getContractSignedOn() { return contractSignedOn; }
    public String getContactAdd() { return contactAdd; }
    public String getWorkAdd() { return workAdd; }






//    }

}
