package app.students.dao;

import app.students.model.Student;
import app.students.util.DatabaseUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDao
{
    private Connection connection;

    public StudentDao()
    {
        connection = DatabaseUtil.getConnection();
    }

    public void createStudent( final Student student )
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "insert into students(firstname, lastname, dateOfBirth, address) values (?, ?, ?, ? )" );
            preparedStatement.setString( 1, student.getFirstname() );
            preparedStatement.setString( 2, student.getLastname() );
            preparedStatement.setDate( 3, new java.sql.Date( student.getDateOfBirth().getTime() ) );
            preparedStatement.setString( 4, student.getAddress() );
            preparedStatement.executeUpdate();

        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void removeStudent( final int studentId )
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "delete from students where studentId=?" );
            preparedStatement.setInt( 1, studentId );
            preparedStatement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public void updateStudent( final Student student )
    {
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "update students set firstname=?, lastname=?, dateOfBirth=?, address=? where studentId=?" );
            preparedStatement.setString( 1, student.getFirstname() );
            preparedStatement.setString( 2, student.getLastname() );
            preparedStatement.setDate( 3, new java.sql.Date( student.getDateOfBirth().getTime() ) );
            preparedStatement.setString( 4, student.getAddress() );
            preparedStatement.setInt( 5, student.getStudentId() );
            preparedStatement.executeUpdate();
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }
    }

    public List< Student > getAllStudents()
    {
        List< Student > students = new ArrayList< Student >();
        try
        {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery( "select * from students" );

            while ( rs.next() )
            {
                Student student = new Student();
                student.setStudentId( rs.getInt( "studentId" ) );
                student.setFirstname( rs.getString( "firstname" ) );
                student.setLastname( rs.getString( "lastname" ) );
                student.setDateOfBirth( rs.getDate( "dateOfBirth" ) );
                student.setAddress( rs.getString( "address" ) );

                students.add( student );
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }

        return students;
    }

    public Student getStudentById( int studentId )
    {
        Student student = new Student();
        try
        {
            PreparedStatement preparedStatement = connection.prepareStatement( "select * from students where studentId=?" );
            preparedStatement.setInt( 1, studentId );
            ResultSet rs = preparedStatement.executeQuery();

            if ( rs.next() )
            {
                student.setStudentId( rs.getInt( "studentId" ) );
                student.setFirstname( rs.getString( "firstname" ) );
                student.setLastname( rs.getString( "lastname" ) );
                student.setDateOfBirth( rs.getDate( "dateOfBirth" ) );
                student.setAddress( rs.getString( "address" ) );
            }
        }
        catch ( SQLException e )
        {
            e.printStackTrace();
        }

        return student;
    }
}
