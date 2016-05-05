package app.students.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil
{
    private static Connection connection;

    public static Connection getConnection()
    {
        if ( connection != null )
            return connection;
        else
        {
            try
            {
                Properties prop = new Properties();
                InputStream inputStream = DatabaseUtil.class.getClassLoader().getResourceAsStream( "/db.properties" );
                prop.load( inputStream );

                String driver = prop.getProperty( "driver" );
                String url = prop.getProperty( "url" );
                String user = prop.getProperty( "user" );
                String password = prop.getProperty( "password" );

                Class.forName( driver );
                connection = DriverManager.getConnection( url, user, password );
            }
            catch ( Exception e )
            {
                e.printStackTrace();
            }

            return connection;
        }
    }
}
