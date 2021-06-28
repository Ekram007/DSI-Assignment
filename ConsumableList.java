
import java.util.ArrayList;

public class ConsumableList {
    
    private ArrayList<Consumable> consumableList = new ArrayList<Consumable>();  //

    private int totalTime;
    private int bookTime , seriesTime, movieTime;

    private int totalDays;
    private int bookDays, seriesDays, movieDays;

    private double avgRating;
    private double avgBookRating, avgSeriesRating, avgMovieRating;

    private int totalNumbConsumable;
    private int totalNumberBook, totalNumberSeries, totalNumberMovies;

    void addNewConsumable(Consumable c){
        consumableList.add(c);
        
    }

    void delConsumable(String name){
        consumableList.remove(findConsumable(name));
        setAvgRatingAndTotalNumber();
    }

    Consumable findConsumable(String name){
        for(int i=0; i<consumableList.size(); i++){
            if(consumableList.get(i).getName().equals(name)){
                return consumableList.get(i);
            }
        }
        return null;
    }

    void updateTotalTime(Consumable c, int time){
        totalTime = totalTime + time;
        

        if(c.getClass().getName().equals("Book")){
            bookTime = bookTime + time;
        }
        else if(c.getClass().getName().equals("Series")){
            seriesTime = seriesTime + time;
        }
        else{
            movieTime = movieTime + time;
        }
    }

    void updateTotalDays(Consumable c, int days){
        totalDays = totalDays + days;
        
        if(c.getClass().getName().equals("Book")){
            bookDays = bookDays + days;
        }
        else if(c.getClass().getName().equals("Series")){
            seriesDays = seriesDays + days;
        }
        else{
            movieDays = movieDays + days;
        }
    }

    void setAvgRatingAndTotalNumber(){
        totalNumberBook = 0; totalNumberSeries=0; totalNumberMovies=0;
        double totalRating = 0, totalBookRating = 0 , totalSeriesRating = 0, totalMovieRating = 0;

        totalNumbConsumable = consumableList.size();
        for(int i =0 ; i<consumableList.size(); i++){
            totalRating = totalRating + consumableList.get(i).getRating();
            if(consumableList.get(i).getClass().getName().equals("Book")){
                totalBookRating = totalBookRating + consumableList.get(i).getRating();
                totalNumberBook++;
            }
            else if(consumableList.get(i).getClass().getName().equals("Series")){
                totalSeriesRating = totalSeriesRating + consumableList.get(i).getRating();
                totalNumberSeries++;
            }
            else{
                totalMovieRating = totalMovieRating + consumableList.get(i).getRating();
                totalNumberSeries++;
            }
            
            try {
                avgRating = totalRating/totalNumbConsumable;
                avgBookRating = totalBookRating/totalNumberBook;
                avgSeriesRating = totalSeriesRating/totalNumberSeries;
                avgMovieRating = totalMovieRating/totalNumberMovies;
            }
            catch (ArithmeticException e) {
                // Exception handler
            }

        }
    }
   
    void displaySameConsumables(String name){
        System.out.println("Name\t  Total Days\tTotal Time\tRating");
        for(int i =0 ; i<consumableList.size(); i++){
            if(consumableList.get(i).getClass().getName().equals(name)){
                consumableList.get(i).display();
            }
        }
    }
    
    void displayOverall(){
        System.out.println("The total consumption time in hours across all types: " + totalTime);
        System.out.println("The total consumption time for Book: "+ bookTime + ", Series: "+seriesTime +", Movies: "+movieTime);
        System.out.println("The total days of consumption across all types: "+totalDays);
        System.out.println("The total consumption days for Book: "+ bookDays + ", Series: "+seriesDays +", Movies: "+movieDays);
        System.out.println("Average rating across all types: "+avgRating);
        System.out.println("AVerage rating for Book: "+avgBookRating+", Series: "+avgSeriesRating+", Movies: "+avgMovieRating);
        System.out.println("Total number of consumable across all types: "+totalNumbConsumable);
        System.out.println("Total number of Book: "+totalNumberBook+", Series: "+totalNumberSeries+", Movies: "+totalNumberMovies);
    }



    

}
