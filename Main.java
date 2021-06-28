import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ConsumableList consumableList = new ConsumableList();
        ConsumableFactory consumableFactory = new ConsumableFactory();

        String empty;

        outerloop:
        while (true) {
  
            System.out.println("\n\nMY CONSUMED PIECES OF ART\n");
            System.out.println("Enter '1', to add a consumable.");
            System.out.println("Enter '2', to edit a consumable.");
            System.out.println("Enter '3', to delete a consumable.");
            System.out.println("Enter '4', to see the consumables.");
            System.out.println("Enter '5' to see overall info.");
    
            Scanner sc = new Scanner(System.in);
            int input = sc.nextInt();
    
            switch (input) {
                //Adding consumable
                case 1:
                    System.out.println("Enter the type of the consumable(Book/Series/Movie): ");        
                    String type = sc.next();                                                            //Taking consumable type
                    empty = sc.nextLine();

                    System.out.println("Enter "+type+" name: ");                                        
                    String name = sc.nextLine();                                                        //Taking consumable name

                    Consumable c = consumableFactory.getConsumable(type, name);                         //Creating object of that type
                    
                    consumableList.addNewConsumable(c);                                                 //Adding consumable to the list of all consumables

                    System.out.println("Enter starting date(YYYY-MM-DD/press enter to ignore): ");      //Taking starting date
                    String startingDate = sc.nextLine();
                    if(!startingDate.isBlank()){
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            c.setStartingDate(dateFormat.parse(startingDate));                          //Assigining the starting date to the objects instance variable
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                    
                    System.out.println("Enter ending date(YYYY-MM-DD/press enter to ignore): ");        
                    String endingDate = sc.nextLine();                                                  //Taking ending date
                    if(!endingDate.isBlank()){
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                        try {
                            c.setEndingDate(dateFormat.parse(endingDate));                              //Assigining the ending date to the objects instance variable
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("Enter total consumption time in  hours: ");     
                    int totalTime = sc.nextInt();                                                       //Taking total time of consumption for that object
                    empty = sc.nextLine();
                    c.setTotalTime(totalTime);                                                          //Assigining the total time to the objects instance variable
                    consumableList.updateTotalTime(c, totalTime);                                       //Updating total time for each type and across all type

                    System.out.println("Enter rating out of 10(press enter to ignore): ");
                    String sRating = sc.nextLine();                                                     //Using nextLine() to take blank input of rating.
                    if(!sRating.isBlank()){
                        double rating = Double.parseDouble(sRating);
                        c.setRating(rating);                                                            //Assigining the rating to the objects instance variable
                    }
                    consumableList.setAvgRatingAndTotalNumber();                                        //updating Average Rating

                    System.out.println("Enter total days of consumption");
                    int totalDays = sc.nextInt();                                                       //Taking total days of consumption for that object.
                    empty = sc.nextLine();
                    c.setTotalDays(totalDays);                                                          //Assigining total days to the objects instance variable
                    consumableList.updateTotalDays(c, c.getTotalDays());                                //Updating total days
                    break;
                
                //Edit consumable
                case 2:
                    System.out.println("Enter Consumable Name: ");
                    String name2 = sc.next();
                    empty = sc.nextLine();                                                               //Taking consumable name
                    Consumable consumable = consumableList.findConsumable(name2);                        //Finding the consumable object from the consumable list through name.
                    
                    if(consumable.getEndingDate()==null){                                                //Checking ending date is added or not
                        System.out.println("Press 1 to add time in hours.");
                        System.out.println("Press 2 to add days.");
                        System.out.println("Press 3 to update rating.");
                        System.out.println("Press 4 to enter ending date.");
                        int in = sc.nextInt();

                        switch (in) {
                            //Editing time
                            case 1:
                                System.out.println("Add time in hours: ");
                                int time = sc.nextInt();
                                consumable.updateTime(time);
                                consumableList.updateTotalTime(consumable, time);
                                break;
                            
                            //Editing day
                            case 2:
                                System.out.println("Add days: ");
                                int days = sc.nextInt();
                                consumable.updateDays(days);
                                consumableList.updateTotalDays(consumable, days);
                                break;
                            
                            //Editing rating
                            case 3:
                                System.out.println("Enter updated rating: ");
                                double ratings = sc.nextDouble();
                                empty = sc.nextLine();
                                consumable.setRating(ratings);
                                break;
                            
                            //Editing ending date
                            case 4:
                                System.out.println("Enter ending date(YYYY-MM-DD): ");
                                endingDate = sc.nextLine();
                                if(!endingDate.isBlank()){
                                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
                                    try {
                                        consumable.setEndingDate(dateFormat.parse(endingDate));
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }
                                break;
                            default:
                                break;
                        }
                    }
                    else{
                        System.out.println("Cannot update. Ending date already defined.");
                    }
                    break;

                //Deleting a consumable
                case 3:
                    System.out.println("Enter the consumable name: ");
                    name = sc.nextLine();
                    consumableList.delConsumable(name);
                    break;

                //Display consumables individually
                case 4:
                    System.out.println("Enter the type of the consumables(Book/Series/Movie): ");
                    type = sc.next();
                    empty = sc.nextLine();
                    consumableList.displaySameConsumables(type);                                        //Displaying consumables for particular type

                    System.out.println("Pick individual one consumable: ");
                    name = sc.nextLine();
                    if(!name.isBlank()){
                        Consumable consumable2 = consumableList.findConsumable(name);                   //Finding individual consumable object
                        consumable2.displayDetails();                                                   //Displaying that individual objects info
                    }
                    break;

                //Display overall
                case 5:
                    consumableList.displayOverall();
                    break;
                
                //To exit
                case 0:
                    break outerloop; 
                
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }            
    }
}
