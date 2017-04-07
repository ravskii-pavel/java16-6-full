package hiber;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

public class WorkDay {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private long employeeId;

    private Date dayStart;

    private Date dayFinish;

    private Date dateCreate;

}
