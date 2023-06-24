package it.unicas.products.pojo;

public class MedicationInfo {
    private Integer user_id;
    private Integer id;
    private String  name;
    private Integer dose;
    private String treatment_for;
    private String date_started;
    private String date_end;

    public MedicationInfo(String name, Integer dose, String treatment_for, String date_started,
                   String date_end) {
        super();
        this.name = name;
        this.dose = dose;
        this.treatment_for = treatment_for;
        this.date_started = date_started;
        this.date_end = date_end;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDose() {
        return dose;
    }

    public void setDose(Integer dose) {
        this.dose = dose;
    }

    public String getTreatment_for() {
        return treatment_for;
    }

    public void setTreatment_for(String treatment_for) {
        this.treatment_for = treatment_for;
    }

    public String getDate_started() {
        return date_started;
    }

    public void setDate_started(String date_started) {
        this.date_started = date_started;
    }

    public String getDate_end() {
        return date_end;
    }

    public void setDate_end(String date_end) {
        this.date_end = date_end;
    }

    @Override
    public String toString() {
        return "MedicationInfo{" +
                "user_id=" + user_id +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", dose=" + dose +
                ", treatment_for='" + treatment_for + '\'' +
                ", date_started='" + date_started + '\'' +
                ", date_end='" + date_end + '\'' +
                '}';
    }
}
