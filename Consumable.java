import java.util.Date;

public class Consumable {
    
    private String name;
    private Date startingDate;
    private Date endingDate;
    private int totalTime;
    private double rating;
    private int totalDays = 0 ;
     
    public Consumable(String name){         
        this.name = name;
    }
    
    public void updateTime(int time){
        totalTime = totalTime + time;
    }

    public void updateDays(int days){
        totalDays = totalDays + days;
    }

    void display(){
        System.out.println(this.name+"\t"+this.totalDays+"\t       "+this.totalTime+"\t     "+this.rating);
    }

    void displayDetails(){
        System.out.println("Name: "+name);
        System.out.println("Consumption Starting date: "+ startingDate );
        System.out.println("Consumption Starting date: "+ endingDate ) ;
        System.out.println("Total consumption time: "+ totalTime);
        System.out.println("Total consumption days: "+totalDays);
        System.out.println("Personal Rating: "+rating);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Date getStartingDate() {
        return this.startingDate;
    }

    public void setStartingDate(Date startingDate) {
        this.startingDate = startingDate;
    }

    public Date getEndingDate() {
        return this.endingDate;
    }

    public void setEndingDate(Date endingDate) {
        this.endingDate = endingDate;
    }

    public int getTotalTime() {
        return this.totalTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getTotalDays() {
        return this.totalDays;
    }

    public void setTotalDays(int totalDays) {
        this.totalDays = totalDays;
    }

}
