/**
2018
 Banu
 * 
 */


/**
 * @author Banu
 *
 */
package assing.Ab;
import java.util.*;
public class RePOS {
	private static int TotalPrice=0;
    private static int quantityNo=0;
    static int j=0;

        static Scanner sc=new Scanner(System.in);
        static String summary[][]=new String[100][6];


        public static  void login()
        {

            String admin[]={"jeno","jeno123"};

            ArrayList<String> user=new ArrayList<String>();
            ArrayList<String>pwd=new ArrayList<String>();
            user.add("banu");
            pwd.add("banu123");

            String position;
            String username,password;

            System.out.println("\n**********************************************       Login      *************************************************");
            System.out.println("Enter your position admin or cashier /n position(admin=a / cashier=u)");
            position=sc.next();
            System.out.println("User_Name :");
            username=sc.next();
            System.out.println("PassWord :");
            password=sc.next();

            if(position.equals("a") && username.equals(admin[0]) && password.equals(admin[1]))
            {
                admin_Login(user,pwd);
            }
            else if(position.equals("u") && username.equals(user.get(0)) && password.equals(pwd.get(0)) )
            {
                cashier_Login(username);
            }
            else
            {

                System.out.println("PassWord or UserName Incorrect !!!");
                System.out.println("Try Again !!!");

                login();
            }

        }

        public static void cashier_Login(String username)
        {

            System.out.println(" Hi! "+ username.toUpperCase()+"! WELCOME TO POINT OF SALE SYSTEM.." );
            Add_Item(username,getTotalPrice(), quantityNo);

        }


        public static void Add_Item(String username, int TotalPrice, int quantityNo){
          //  int TotalPrice=0;
            int cus_no=1;
            int i=0;
            String ans;
            int Unitprice[]=new int[100];
            int price[]=new int[100];
            int quantity[]=new int[100];
            String product[]=new String[100];

            System.out.println("\n++++++++++++++++++++++++++++++++++++++++++++    		Add Items   	+++++++++++++++++++++++++++++++++++++++++++");
            System.out.println();
            //System.out.println(" %%%%%%           			PLEASE ENTER 0 TO FINISH  ADDING ITEMS !!!!   				%%%%%%%%%%%%%%%%%%%%%%%%%");
            System.out.println();


            while ( i<100)
            {

                System.out.print("Enter Product Name:");
                product[i]=sc.next();

                System.out.print("Enter quantity:");
                quantity[i]=sc.nextInt();
                System.out.print("unit Price : ");
                Unitprice[i]=sc.nextInt();
                price[i]=Unitprice[i]*quantity[i];
                System.out.println("Price : "+price[i]);
                j=j+1;
                quantityNo = j ;
                TotalPrice+=price[i];
                System.out.print(TotalPrice);
                System.out.println();

                System.out.println("Do you want add more items?(Yes = y // No = n)");
                ans=sc.next();
                if(ans.equals("y")||ans.equals("Y")){

                    Add_Item(username,TotalPrice,quantityNo);

                }
                else{
                    Make_Sale(TotalPrice,quantityNo,Unitprice,price,quantity,product,username);
                }

            }

        }

        public static void Make_Sale(int TotalPrice,int no,int Unitprice[],int price[],int quantity[],String product[],String username )
        {
            Date date=new Date();
            String str =String.format("Current Date/Time : %tc", date );
            int amount_Pay,Balance;

            System.out.println("Total Price: "+TotalPrice);
            System.out.println("No Of Items : "+no);
            System.out.print("Enter Amount Pay:");
            amount_Pay=sc.nextInt();
            Balance=amount_Pay-TotalPrice;
            System.out.println("Balance Pay:"+Balance);
            System.out.println("======================================================");


            summary[0][0]=username;
            summary[0][1]=" ";
            for(int i=0;i<=no;i++)
            {
                summary[0][1]= summary[0][1].concat(product[i] +" "+quantity[i]+"\n");
            }
            summary[0][2]=String.valueOf(TotalPrice);
            summary[0][3]=String.valueOf(amount_Pay);
            summary[0][4]= String.valueOf(Balance);
            summary[0][5]=str;





            System.out.println("  Thank You   ");
            String answer="y";
            System.out.println("Do you want logout ?(Yes = y // No = n)");
            answer=sc.next();
            if(answer.equals("n")||answer.equals("N")){
                cashier_Login(username);
            }
            else {
                login();
            }

        }



        public  static void admin_Login(ArrayList cun,ArrayList pwd)
        {
            int option;

            System.out.println("					Hi! Admin, WELCOME TO POINT OF SALE SYSTEM..");
            System.out.println("*****************************************************************************************************************\n");
            System.out.println("1. Show Daily Summary \n 2. Add / Remove User \n 3.  logout\n Select activity : ");
            option=sc.nextInt();
            System.out.println();
            if(option==1)
                show_DailySummary();
            else if(option==2)
                Add_RemoveUser(cun,pwd);
            else if(option==3)
                login();
            else
            {
                System.out.println("Error..Please Select 1 / 2/3...");
                System.out.print("1. Show Daily Summary \n 2. Add / Remove User\n 3.  logout \n Select activity : ");
                option=sc.nextInt();
                System.out.println();
            }
        }

        public static void Add_RemoveUser(ArrayList user,ArrayList pwd){
            int option;
            String new_user,password,con_pas,delete_user;
            System.out.print("1. Add User\n 2.Remove User \n Select activity : ");
            option=sc.nextInt();
            if(option==1)
            {
                System.out.println();
                System.out.print("Enter New UserName :  ");
                new_user=sc.next();
                System.out.print("Enter Password : ");
                password=sc.next();
                System.out.print("Confirm Password : ");
                con_pas=sc.next();
                System.out.println();

                if(password.equals(con_pas))
                {
                    user.add(new_user);
                    pwd.add(password);
                    System.out.println(" you have created New User "+ new_user +" SuccessFully !");

                }

                else
                    System.out.println(" Password and confirm Password are not matched !");
            }

            else if(option==2)
            {
                System.out.println();
                System.out.print("Enter  UserName to Delete :  ");
                delete_user=sc.next();
                user.remove(delete_user);
            }

        }

        public static void show_DailySummary(){
            System.out.println("	Daily Summary	");
            System.out.println("Cashier Name : " + summary[0][0] +"\t\t\t\tDate : "+ summary[0][5]);
            System.out.println(" Product Detail: "+ summary[0][1]);
            System.out.println("Total_Price : "+ summary[0][2]);
            System.out.println("Amount_Pay : "+ summary[0][3]);
            System.out.println("Balance : "+ summary[0][4]);
            System.out.println();

        }


        public static void main(String[] args)
        {

            System.out.println("-------------------------------------------###    POINT OF SALES SYSTEM    ###-----------------------------------");

            login();
        }

    public static int getTotalPrice() {
        return TotalPrice;
    }
}
	


