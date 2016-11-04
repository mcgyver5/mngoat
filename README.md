# mngoat
purposely insecure web application

1) This comes with an embedded database (HSQLDB)

2) Expects to run in an existing Tomcat.  Has not been tested on other web servers.

3) For the file upload feature, this webapp Expects to be able to read and write from whatever System.getProperty("java.io.tmpdir") resolves to 

4) Purposely vulnerable to Application denial of service attacks (as opposed to network oriented distributed D.O.S) and these attacks could have unpredictable effects on the host operating system and web server, so don't run it alongside anything you care about. 
