package app.students.model;

import java.util.Date;

public class Student
{

    private int studentId;
    private String firstname;
    private String lastname;
    private String address;
    private Date dateOfBirth;

    public int getStudentId()
    {
        return studentId;
    }

    public void setStudentId( int studentId )
    {
        this.studentId = studentId;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname( String firstname )
    {
        this.firstname = firstname;
    }

    public String getLastname()
    {
        return lastname;
    }

    public void setLastname( String lastname )
    {
        this.lastname = lastname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress( String address )
    {
        this.address = address;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth( Date dateOfBirth )
    {
        this.dateOfBirth = dateOfBirth;
    }
}
