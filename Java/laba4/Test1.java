public class Test1 {
    public static void main( String[] args) {

        int[] array = { 1, 2, 3, 4 ,4};

        double t = average(array);

        System.out.println("Середнє значення елементів суми елементів масиву" + t);


       
    }

     public static double average( int[] numbers){
        int sum = 0;
        int n = numbers.length;
        for( int k=0 ; k< n; k++) {
        
            sum += numbers[k];
           
        }
        return (double) sum / n; 
        
     }
     
}
