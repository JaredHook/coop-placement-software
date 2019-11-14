package coop.sft;

public class Person {

// TODO: decide if we can use different data types in java template for our variables
// TODO: fields must be added to the ui form
// TODO: ensure all fields are accounted for in template

    private String firstName;
    private String lastName;
    private String course;
    private String batch;
    private String year;
    private String coopHost;
    private String startDate;
    private String endDate;
    private String wsib;
    private String insurance;
    private String contactName;
    private String contactNumber;
    private String contactEmail;
    private String contractSignedOn;
    // these fields must still be added to the form
    private String actualEndDate;
    private String evaluation1DueDate;
    private String evaluation1SubmittedOn;
    private String evaluation2DueDate;
    private String evaluation2SubmittedOn;
    private String timesheetDueDate;
    private String timesheetSubmittedOn;

    // these fields no longer required on ui form - only on word doc template.
    //private String followUps;
    //private String passFailEntered;
    //private String attendanceEntered;
    //private String officeManager;
    //private String placementCoordinator;


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
    public void setWsib(String wsib) { this.wsib = wsib; }
    public void setInsurance(String insurance) { this.insurance = insurance; }
    public void setContractSignedOn(String contractSignedOn){ this.contractSignedOn = contractSignedOn; }
    public void setContactName(String contactName) { this.contactName = contactName; }
    public void setContactEmail(String contactEmail) { this.contactEmail = contactEmail; }
    public void setActualEndDate(String actualEndDate) { this.actualEndDate = actualEndDate; }
    public void setEvaluation1DueDate(String evaluation1DueDate) { this.evaluation1DueDate = evaluation1DueDate; }
    public void setEvaluation1SubmittedOn(String evaluation1SubmittedOn) { this.evaluation1SubmittedOn = evaluation1SubmittedOn; }
    public void setEvaluation2DueDate(String evaluation2DueDate) { this.evaluation2DueDate = evaluation2DueDate; }
    public void setEvaluation2SubmittedOn(String evaluation2SubmittedOn) { this.evaluation2SubmittedOn = evaluation2SubmittedOn; }
    public void setTimesheetDueDate(String timesheetDueDate) { this.timesheetDueDate = timesheetDueDate; }
    public void setTimesheetSubmittedOn(String timesheetSubmittedOn) { this.timesheetSubmittedOn = timesheetSubmittedOn; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }

    // these fields no longer required on ui form - only on word doc template.
    //public void setFollowUps(String followUps) { this.followUps = followUps; }
    //public void setPassFailEntered(String passFailEntered) { this.passFailEntered = passFailEntered; }
    //public void setAttendanceEntered(String attendanceEntered) { this.attendanceEntered = attendanceEntered; }
    //public void setOfficeManager(String officeManager) { this.officeManager = officeManager; }
    //public void setPlacementCoordinator(String placementCoordinator) { this.placementCoordinator = placementCoordinator; }


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
    public String getWsib() { return wsib; }
    public String getInsurance() { return insurance; }
    public String getContractSignedOn() { return contractSignedOn; }
    public String getContactName() { return contactName; }
    public String getContactEmail() { return contactEmail; }
    public String getActualEndDate() { return actualEndDate; }
    public String getEvaluation1DueDate() { return evaluation1DueDate; }
    public String getEvaluation1SubmittedOn() { return evaluation1SubmittedOn; }
    public String getEvaluation2DueDate() { return evaluation2DueDate; }
    public String getEvaluation2SubmittedOn() { return evaluation2SubmittedOn; }
    public String getTimesheetDueDate() { return timesheetDueDate; }
    public String getTimesheetSubmittedOn() { return timesheetSubmittedOn; }
    public String getContactNumber() { return contactNumber; }

    // no longer required on ui form - only on word doc template.
    //public String getFollowUps() { return followUps; }
    //public String getPassFailEntered() { return passFailEntered; }
    //public String getAttendanceEntered() { return attendanceEntered; }
    //public String getOfficeManager() { return officeManager; }
    //public String getPlacementCoordinator() { return placementCoordinator; }

//    }

}
