# TOWAN
## FH Joanneum, Information Management: SWENGA

### Team
 - FELLNER Elisabeth
 - FORTMUELLER Vanessa
 - HARING Martin
 - KOGELNIK Stefan
 - SCHOPPER Fabian

### Workload distribution
**FELLNER Elisabeth**
* Forum Implementation
* Forum Functionality
* Forum Design
* Implementation of administrative features

**FORTMUELLER Vanessa**
* Profile page functionality
* Profile page design
* HTML coding
* Profile searching functionality

**HARING Martin**
* Project setup
* Database implementation
* Game Implementation
* Overall design improvements
* Settings functionality
* Error page implementation

**KOGELNIK Stefan**
* Registration Functionality
* Registration page Design
* Login Functionality
* Login page Design
* Logout Functionality
* CSS coding
* Security Management

**SCHOPPER Fabian**
* Password policy management
* Team Motivation
* Software testing on Linux systems

### Setup instructions
Checklist:
 - Download project on GitHub
 - Import to preferred IDE
 - Setup db.properties
 - Run the project
 - Sign up
 - Log in

* Download project on GitHub
Click the "Clone or Download" Button on the project's github page and choose download ZIP.
After the download has finished, extract the contents of the zip archive to a folder of your choice.
Keep in mind that you need to know the exact path of this folder in the next step.

* Import to preferred IDE
Now you need to import the project.
Therefore, open your preferred IDE (eclipse, intelliJ, ...) and choose a workspace.
As soon as the program is ready, start the Import wizard by choosing the File/Import option in the menubar.
In the wizard, choose General/"Existing Projects into Workspace" and click Next.
Use the Browse button to navigate to the folder containing the downloaded data.
Make sure the project is selected and click finish.

* Setup db.properties
In the newly imported project, first left click on src, then right click on src and choose New/File.
If File is not an option, choose New/Other... and search for "file". Choose General/File and click Next.
Name this file db.properties (name needs to match exactly) and click finish.
Open the db.properties file.
First, copy and paste the following three lines into the file. (They represent a database connection)

- db.url=jdbc:mysql://10.25.2.109:3306/IMA15_haring_project_1 
- db.username=IMA15_haring 
- db.password=ima15

If you have access to another database, we deeply recommend using it.
The example database can be used as well, but keep in mind that it is necessary to have a stable 
connection to the internal network of FH Joanneum while using the application.

* Run the project
To make sure that your IDE runs the right application, we recommend to first left click the project,
then right clicking it and then choosing "Run as"/"Run on Server".
Then, choose a server of your choice.

If no server is available, we recommend downloading Tomcat 8 (NOT Tomcat 9!!!!) from the Apache website
(http://tomcat.apache.org/download-80.cgi) and unzipping it into your preferred folder (e.g. C:\Java).
Also, to finish the process, set the environment variable "CATALINA_HOME" so that it points to your folder
(You can set these environment here: "Control Panel"\"System and Security"\System\Advanced\"Environment variables").

After the server has been chosen, the project needs to be added to the server.
The IDE should set this automatically.
To avoid database errors, the Towan project should be the only project on the right side.

Now you can run the application.

* Sign up
You can use the "Sign up" button on the welcome page to create an account.
Please consider our password policies:
- a password must be at least 14 alphanumeric symbols long
After a successful registration, a verification link should be sent to your provided E-Mail address.
You do not need to verify your account; in the current state of the application it is not necessary.

* Log in
After a successful registration, use the "Sign in" button to log into the application.
You will be forwarded to the home page, from where all features of the application can be accessed.

* One last note
This web application offers the user the opportunity to play a browser game.
In order to start this game, you need to follow the instructions given on the game.html page.
In short, it is necessary to download the lwjgl library 
and extract a certain native file from that library to a location your system can find it.
We can only guarantee that the game works on Windows systems.
