package app.students.controller;

import app.students.dao.StudentDao;
import app.students.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentController extends HttpServlet
{
    private static String INSERT_OR_UPDATE = "/student.jsp";
    private static String LIST_STUDENTS = "/listStudent.jsp";

    private StudentDao studentDao;

    public StudentController()
    {
        studentDao = new StudentDao();
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        String forward;
        String action = request.getParameter( "action" );

        if ( "listStudent".equalsIgnoreCase( action ) )
        {
            forward = LIST_STUDENTS;
            request.setAttribute( "students", studentDao.getAllStudents() );
        }
        else if ( "edit".equalsIgnoreCase( action ) )
        {
            forward = INSERT_OR_UPDATE;
            Integer studentId = Integer.parseInt( request.getParameter( "studentId" ) );
            if ( studentId == null )
            {
                throw new IllegalArgumentException( "Id cannot be null" );
            }

            Student student = studentDao.getStudentById( studentId );
            request.setAttribute( "student", student );
        }
        else if ( "delete".equalsIgnoreCase( action ) )
        {
            Integer studentId = Integer.parseInt( request.getParameter( "studentId" ) );
            if ( studentId == null )
            {
                throw new IllegalArgumentException( "Id cannot be null" );
            }

            studentDao.removeStudent( studentId );

            forward = LIST_STUDENTS;
            request.setAttribute( "students", studentDao.getAllStudents() );
        }
        else
        {
            forward = INSERT_OR_UPDATE;
        }

        RequestDispatcher view = request.getRequestDispatcher( forward );
        view.forward( request, response );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException
    {
        Student student = new Student();
        student.setFirstname( request.getParameter( "firstname" ) );
        student.setLastname( request.getParameter( "lastname" ) );

        try
        {
            Date dob = new SimpleDateFormat( "MM/dd/yyyy" ).parse( request.getParameter( "dateOfBirth" ) );
            student.setDateOfBirth( dob );
        }
        catch ( ParseException e )
        {
            e.printStackTrace();
        }

        student.setAddress( request.getParameter( "address" ) );
        String studentId = request.getParameter( "studentId" );

        if ( studentId == null || studentId.isEmpty() )
        {
            studentDao.createStudent( student );
        }
        else
        {
            student.setStudentId( Integer.parseInt( studentId ) );
            studentDao.updateStudent( student );
        }

        RequestDispatcher view = request.getRequestDispatcher( LIST_STUDENTS );
        request.setAttribute( "students", studentDao.getAllStudents() );
        view.forward( request, response );
    }
}