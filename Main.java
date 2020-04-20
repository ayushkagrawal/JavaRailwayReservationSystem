                    /*****************************************************************
                    *                                                                *
                    *           Railway Reservation System                           *
                    *               Developed using following topics:                *
                    *                   1. Inheritance                               *
                    *                   2. Overriding Methods                        *
                    *                   3. Polymorphism                              *
                    *                   4. Abstract Classes                          *
                    *                   5. Interfaces                                *
                    *                                                                *
                    *               Developed By:                                    *
                    *                   Ayush Kumar Agrawal                          *
                    *                                                                *
                    *****************************************************************/

import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

abstract class travellerDetails
{
    String travellerName="";
    int age=0;
    char gender='M';
    String seatChoice="MB";
    String emailId="abc@xyz.com";
    String mobileNumber="0123456789";
    Scanner sdata=new Scanner(System.in);
    travellerDetails()
    {
        travellerName="ABC";
        age=0;
        gender='M';
        seatChoice="MB";
        emailId="cse310java@lpu.co.in";
        mobileNumber="1234567890";

    }
    void getdata()
    {

        System.out.print("\n\nEnter name: ");
        travellerName=sdata.nextLine();
        System.out.print("\nEnter his/her age:");
        age=sdata.nextInt();
        sdata.nextLine();
        System.out.print("\nEnter Email Id:");
        emailId=sdata.nextLine();
        System.out.print("\nEnter Mobile Number:");
        mobileNumber=sdata.nextLine();
        System.out.print("\nEnter preferred berth choice(LB/MB/UB/SL/SU):");
        seatChoice = sdata.nextLine();
        System.out.print("\nEnter Sex(M/F):");
        gender = sdata.next().charAt(0);
        sdata.nextLine();
    }
}
interface mainfunctions
{
    void ticketBook();
    void ticketCancel();
    void displayAvailableTickets();
}
public class Main extends travellerDetails implements mainfunctions
{

    Scanner s2=new Scanner(System.in);
    String fromStation="";
    String toStation="";
    int tcount=300;
    ArrayList<Long> pnr = new ArrayList<Long>();
    long temppnr=235875149;
    int trainNo=12238;
    void getdata()
    {

        System.out.print("\n\nEnter name of traveller: ");
        travellerName=s2.nextLine();
        System.out.print("\nEnter age:");
        age=s2.nextInt();
        s2.nextLine();
        System.out.print("\nEnter Email Id:");
        emailId=s2.nextLine();
        System.out.print("\nEnter Mobile Number:");
        mobileNumber=s2.nextLine();
        System.out.print("\nEnter preferred berth choice(LB/MB/UB/SL/SU):");
        seatChoice = s2.nextLine();
        System.out.print("\nEnter Sex(M/F):");
        gender = s2.next().charAt(0);
        s2.nextLine();
    }
    int seatsLeft1ac=75;
    int seatsLeft2ac=125;
    int seatsLeft3ac=175;
    public static void main(String args[]) throws Exception
    {
            int choice=0;
            char ch='y';
            Main m1=new Main();
            do
            {
            //System.out.print("\f");
            System.out.print("\n\t\t\t\t\t\tMENU");

            System.out.print("\n\t\t###################################################################");
            System.out.print("\n\t\t-------------------------------------------------------------------");
            System.out.print("\n\t\t|                                                                  |");
            System.out.print("\n\t\t|                    Railway Reservation System                    |");
            System.out.print("\n\t\t|__________________________________________________________________|");
            System.out.print("\n\t\t|                                                                  |");
            System.out.print("\n\t\t|                     1. Book ticket                               |");
            System.out.print("\n\t\t|                     2. Cancel ticket                             |");
            System.out.print("\n\t\t|                     3. Display Available tickets                 |");
            System.out.print("\n\t\t|                     4. Exit                                      |");
            System.out.print("\n\t\t--------------------------------------------------------------------");
            System.out.print("\n\n\t\tEnter your choice(1-4):");
            choice=(m1.s2).nextInt();
            switch(choice)
            {
                case 1: m1.ticketBook();
                        break;
                case 2: m1.ticketCancel();
                        break;
                case 3: m1.displayAvailableTickets();
                        break;
                case 4: m1.Exit();
                        break;
                default:System.out.print("Invalid choice!!!!");
            }
            System.out.print("\n\n\n\t\tDo you want to continue(y/n):");
            ch = (m1.s2).next().charAt(0);
            //System.out.print("\n\n"+ch);
            ch=Character.toLowerCase(ch);
            }while(ch!='n');
        }

        public void ticketBook()
	    {
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            int dd,mm,yy;
            String date1="";
            System.out.print("\n\nEnter Train Number:");
            trainNo=s2.nextInt();
            s2.nextLine();
            System.out.print("\nEnter Source Station code:");
            fromStation=s2.nextLine();

            System.out.print("\nEnter Destination Station code:");
            toStation=s2.nextLine();

            System.out.print("\n\t1. AC 1 Tier\n\t2. AC 2 Tier\n\t3. AC 3 Tier");
            System.out.print("\nPlease enter the class of ticket:");
            int c=s2.nextInt();
            System.out.print("\nPlease enter no. of tickets:");
            int t=s2.nextInt();
            s2.nextLine();
            int ticketAvailable=0;
            if(c==1 && seatsLeft1ac>=t)
            {
                ticketAvailable=1;
            }
            if(c==2 && seatsLeft2ac>=t)
            {
                ticketAvailable=1;
            }
            if(c==3 && seatsLeft3ac>=t)
            {
                ticketAvailable=1;
            }
            if(ticketAvailable==1)
            {
                Main ntd=new Main();
                for(int i=0;i<t;i++)
                {
                    System.out.print("\n\tEnter details for traveller "+(i+1));
                    ntd.getdata();

                }
                temppnr++;
                pnr.add(temppnr);
                System.out.print("Ticket successfully booked with PNR: "+temppnr+" Thanks for transacting with us.");
                if(c==1)
                {
                    seatsLeft1ac-=t;
                    System.out.print("Thanks for paying Rs."+t*4800);
                }
                if(c==2)
                {
                    seatsLeft2ac-=t;
                    System.out.print("Thanks for paying Rs."+t*2500);
                }
                if(c==3)
                {
                    seatsLeft3ac-=t;
                    System.out.print("Thanks for paying Rs."+t*1500);
                }
            }
	    }
        public void ticketCancel()
	    {
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

            int passengerFound=0;
            System.out.print("Please enter your PNR:");
            long p=s2.nextLong();
            System.out.print("\n\t1. AC 1 Tier\n\t2. AC 2 Tier\n\t3. AC 3 Tier\t");
            System.out.print("\nPlease enter the class of ticket:");
            int c1=s2.nextInt();
            for(int i=0;i<tcount;i++)
            {
                if(pnr.get(i)==p)
                {
                    passengerFound=1;
                    pnr.remove(new Long(p));
                    if(c1==1)
                    {
                        seatsLeft1ac++;
                        System.out.print("Please collect refund of Rs 4800.");
                    }

                    if(c1==2)
                    {
                        seatsLeft2ac++;
                        System.out.print("Please collect refund of Rs 2500.");
                    }

                    if(c1==3)
                    {
                        seatsLeft3ac++;
                        System.out.print("Please collect refund of Rs 1500.");
                    }//else
                break;
                }//if
            }
            if(passengerFound==1)
            {
                System.out.print("Ticket successfully Canceled with PNR:"+temppnr);
            }
        }
        public void displayAvailableTickets()
        {
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\n\nSeats Left in following are:");
            System.out.print("\n\nIn AC 1 Tier:"+seatsLeft1ac+" seats left out of 75.");
            System.out.print("\n\nIn AC 2 Tier:"+seatsLeft2ac+" seats left out of 125.");
            System.out.print("\n\nIn AC 3 Tier:"+seatsLeft3ac+" seats left out of 175.");
        }
        public void Exit()
        {
            System.out.print("\n\n\n\\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.print("\n\t\t\t\t#########################################################");
            System.out.print("\n\t\t\t\t# Thanks for giving your valuable time in this project. #");
            System.out.print("\n\t\t\t\t# Developed By: Ayush Kumar Agrawal                     #");
            System.out.print("\n\t\t\t\t# Registration No. : 11813264                           #");
            System.out.print("\n\t\t\t\t# Section : K18PD                                       #");
            System.out.print("\n\t\t\t\t# Roll No. : 28                                         #");
            System.out.print("\n\t\t\t\t#########################################################");
            System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n");
            System.exit(0);
        }
}
