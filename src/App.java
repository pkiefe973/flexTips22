/*
Created by Patrick Kiefer - for use by Comcast personnel only
This program is designed to format URL-encoded JSON objects for use as
Flex editorial stories in MAX. Documentation can be found at the following URL:

https://etwiki.sys.comcast.net/pages/viewpage.action?spaceKey=XDSS&title=Stories+MAX+Programming

Feedback/improvement requests can be sent to patrick_kiefer@comcast.com. Fair warning: I know nothing about web programming, so this is a currently standalone Java product.

v1 (August 2022) - implement basic functionality (using console UI) with bilingual support
v2 (Q3/Q4 2022) - add visual UI support/discuss integration into existing products
*/
import java.util.*;


public class App {

    public static void main(String[] args) throws Exception {
        String releaseNotes = "Added support through case 6";
        System.out.println("\n---------------------\nFlex Editorial Stories Generator\nv1.3 - 9/27/2022\nRelease notes: " + releaseNotes + "\nAuthor: patrick_kiefer@comcast.com\n---------------------\n");

        int caseNum;
        //App a = new App();
        //a.getUserInput();
       // getUserInput();

        displayHowTo();


       

       Scanner sc = new Scanner(System.in);
       caseNum = sc.nextInt();
       sc.close();

       

       Thread.sleep(2000);

       
       final String bilingual, headerTitleEng, headerTitleSpa, cardTitleEng, cardTitleSpa, cardBodyEng, cardBodySpa, button1TextEng, button1TextSpa, button1Deeplink, button2TextSpa, button2TextEng, button2Deeplink, addToListPrompt;

       headerTitleEng = "Xfinity Rewards Movie";
       headerTitleSpa = "Película de Xfinity Rewards";


       cardTitleEng = "Say 'Purchases' into your voice remote";
       cardBodyEng = "It may take up to two hours for the movie to appear in your purchases folder. The promotion will be applied automatically - you'll see the discount on your next bill.";
       
       cardTitleSpa = "Di compras en tu control remoto";
       cardBodySpa = "Puede tardar hasta 2 horas para que la película aparezca en tu sección de compras. La promoción se aplica automáticamente. Verás el descuento en la próxima factura.";


       button1TextEng = "Get the Xfinity App";
       button1TextSpa = "Obtén la Xfinity app";
       button1Deeplink = "appmanager:launchApplication#appId=int.fe.leadgen.prod&additionalLaunchParams=%7B%22urlComponents.query.listingId%22%3A%22leadgen-xfinity-rewards-2021-q3%22%2C%22urlComponents.query.recordId%22%3A%2271370a3f-acd8-4605-82d5-88e58797bd84%22%2C%22urlComponents.query.displayStyle%22%3A%22x1%22%2C%22urlComponents.query.launchedFrom%22%3A%22tipcard%22%7D";


       //tipCard t = new tipCard("Planifica tu voto","Disponible en inglés y español","Planifica Tu Voto está disponible en NBCNews.com/PlanYourVote y PlanificaTuVoto.com.");
        tipCard t = new tipCard(headerTitleEng,cardTitleEng,cardBodyEng,headerTitleSpa,cardTitleSpa,cardBodySpa);

        //tipCard t = new tipCard(headerTitleEng,cardTitleEng,cardBodyEng,button1TextEng,button1Deeplink,headerTitleSpa,cardTitleSpa,cardBodySpa,button1TextSpa);

        t.populateJSON();
        System.out.println("Attempting to copy to clipboard...");
        t.copyJsonToClipboard();
        System.out.println("Encoded query copied to clipboard - complete.");
        System.out.println("\nRaw Query: \n\n" + t.getRawQuery() + "\n\n\nEncoded Query: \n\n" + t.getEncodedQuery());
    }

    //debug switch
    boolean debug = false;

    /*debug copy/pastable
     * 
     * if(debug) System.out.println("DEBUG OUTPUT: " + [VAR_NAME]);
     */

    //instance variables for tip card population
    // set to *private*, protected, final, etc
    static String bilingual, headerTitleEng, headerTitleSpa, cardTitleEng, cardTitleSpa, cardBodyEng, cardBodySpa, button1TextEng, button1TextSp, button1Deeplink, button2TextSpa, button2TextEng, button2Deeplink, addToListPrompt;
    static boolean collectBilingual, addToMyList = false;
    static int maxButtons = 2;
    static int buttonCount;
    
  

     //populate instance variables with user data
    public static void getUserInput(){
       
        //create object for user input
        Scanner sc = new Scanner(System.in);

        //gather parameters required for tip card configuration
        System.out.println("Does this card require bilingual support? (Y/N): ");
        bilingual = sc.next();
        if(bilingual.equalsIgnoreCase("Y")) collectBilingual = true;

        System.out.println("Does this card require an add to my list option? (Y/N): ");
        if(addToListPrompt.equalsIgnoreCase("Y")){
            maxButtons = 1;
            addToMyList = true;
        }

        //determine button count desired, reject if out of bounds
        int i = 0;
        while(i == 0){
            System.out.println("How many buttons does this card have (not including Add to My List): ");
            buttonCount = sc.nextInt();
            if(buttonCount > maxButtons){
                i = 0;
                System.out.println("You have exceeded the maximum number of buttons. Please enter a value of " + maxButtons + " or lower.");
            }

        }

        System.out.println("\nInput English header title: ");
        headerTitleEng = sc.next();
        if(collectBilingual){
            System.out.println("\nInput Spanish header title: ");
            headerTitleSpa = sc.next();
        }
        System.out.println("\nInput English card title: ");
        cardTitleEng = sc.next();
        if(collectBilingual){
            System.out.println("\nInput Spanish card title: ");
            cardTitleSpa = sc.next();
        }
        System.out.println("\nInput English card body: ");
        cardBodyEng = sc.next();
        if(collectBilingual){
            System.out.println("\nInput Spanish card body: ");
            cardBodySpa = sc.next();
        }

    }

        public static void displayHowTo(){
            System.out.println("HOW TO USE THIS TIP CARD GENERATOR\n\nLocate the type of tip card you'd like to create in the list below:\n\n1) English only, no buttons\n2) English + Spanish, no buttons\n3) English only, 1 custom button\n4) English only, 1 add to my list button\n5) English + Spanish, 1 custom button\n6) English + Spanish, 1 add to my list button\n**ADDITIONAL TYPES WILL BE ADDED**\n\nEnter the number of the type of tip card you'd like to create:");

        }

    }


