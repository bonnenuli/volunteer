package View;

import utils.Session;

import java.util.Date;

public class VolunteerSign {
    private String name;
    private String code;

    public VolunteerSign(){super();}
    public VolunteerSign(Integer id, String name, String code)
    {
        super();
        this.name=name;
        this.code=code;
    }

    public static VolunteerSign getEmp(VolunteerSign code) {
        return code;
    }

    public static void addClockInRecord(VolunteerSign v) {
        Date now = new Date();
    }

    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public String getCode(){return code;}
    public void setCode(String code){this.code=code;}


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        VolunteerSign volunteer = (VolunteerSign) obj;
        return name == volunteer.name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                ", name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
