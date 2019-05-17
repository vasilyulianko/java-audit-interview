package models;


import org.joda.time.DateTime;

public class Audit {

    private int id;
    private int tenant ;
    private int user_id;
    private DateTime event_time; 
    private String operation;
    private String user_role;
    private int identifier ;
    private String action ;
    private String details;
}
