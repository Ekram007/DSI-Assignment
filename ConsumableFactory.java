public class ConsumableFactory {
    public Consumable getConsumable (String consumableType, String name){
        if(consumableType.equals("Book")){
            return new Book(name);
        }
        else if(consumableType.equals("Series")){
            return new Series(name);
        }
        else if(consumableType.equals("Movie")){
            return new Movie(name);
        }
        else{
            System.out.println("Invalid Type");
            return null;
        }
    }
}
