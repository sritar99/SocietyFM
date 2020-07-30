# SocietyFM-Society Financial Management

# Objective
The Startup Firm, eSociety is planning to host a cloud based application for managing the financial operations typically done in a house society. The housing society gets funds for its short and long term operations by collecting monthly maintenance fees from the families who resides in a given society/apartment. In order to calculate how much funds should be collected per family on a monthly basis, is fundamentally derived from amount of corpus funds available, cash in hand and estimated cost for the planned activities to be carried or being carried out in a given financial year

At present these details were maintained in a spreadsheet, and it has its own issues when comes to calculations, human introduced data error, missing required precession etc. in addition,the invoice being generated for any out ward payment is been done manually. Due to the manual maintenance of financial records, getting a yoy spending report is become too tedious and difficult to extract in a given amount of time. 

To bring in transparency in making payments to the work being carried out in a society, its planned to bring in Maker-Checker options. This option will make a Checker (approver) to view and validate the details before approving any request for payment or any new activity.

# Requirements

Considering all these points, its planned to develop a web application that will perform following operations

1.User Login to the Portal via username and password

2.The application allows on boarding/managing of families living in the society. 

3.The application keeps track of monthly maintenance payment received from each family.

4.The monthly maintenance to be paid within 10 of each month, system will generate a email remainder from 5th to 10th of every month.

5.A fine of rupees 100 is collected for all delayed payment

6.At any point of time, the user can see how much amount has been paid, and who are all the defaulters for a given month.

7.System will take the request for any out ward payment against the invoice. However for the payment to approved, a checker user is required to come and view the details presented,and his consent for the payment.

8.Any Activities whether cost related or not cost related are captured in the system, and tracked

9.System generates report for any monthly payment the society has to make. Ex Paying the Securities, Salary for Vendors who is working on the apartment.


# Reports

a.In ward Payment for a given date range

b.Families who make frequent delayed payment

c.Yearly spending’s

d.Increase of spending’s YoY basis (max last 6 years)

# Technology Stack

HTML5, JSP, BootStrap, JSTL,CSS3,jQuery

HTTP Servlets
(Layer Adoption Servlets à Service Façade à Service Components à Data Components)
DTO for Data Transfers
 
Exception Handling & Logger

Database:	MySQL 5+

Build Management:Maven 3


# Working Application

Follow the instructions in Readme of SocietyFmAdmin Repo.
