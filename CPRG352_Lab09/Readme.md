README

  Anyone cloning this repo will need to configure their context.xml file.
  Because everyones machines are different they will need to configure
  their port number to their own port, in order to connect to the database.
  
CONFIGURE
  
  Sample of what the context file should include where 3306 
  is your port number;
  
  <?xml version="1.0" encoding="UTF-8"?>
  <Context path="/Lab7">
    <Resource
        name="jdbc/userdb"
        url="jdbc:mysql://localhost:3306/userdb"  
        username="root"
        password="password"
        maxActive="100"
        maxIdle="30"
        maxWait="10000" 
        logAbandoned="true"
        removeAbandoned="true" 
        removeAbandonedTimeout="60"
        driverClassName="com.mysql.jdbc.Driver"
        type="javax.sql.DataSource"
        auth="Container"
    />
  </Context>
