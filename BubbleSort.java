package bubble.sort;

/**
 *
 * @author Yehor Shevchenko
 * 

 * BubbleSort Class implements functions to sort int [] efficiently.
 */
public class BubbleSort {

   
    /** 
    * Class constructor.
    */
    public BubbleSort() {  
    }
    
    static int [] nums;
    
    //statistics
    static int compares = 0;
    static int swaps = 0;
    static int type;
    
    
    /** 
    * Sort an INT Array by ASC or DESC.
    * @param a your array. Accepts int a[]
    * @param t type. Accepts a string "ASC" or "DESC".
    * @return sorted array int []
    */    
    public  int[] sort(int a [], String t){
        
        switch (t) {
            case "ASC":
                type = 0;
                break;
            case "DESC":
                type = 1;
                break;
        }
        
        nums = a;
        
        int n = nums.length;
        int z = 0; //number of swaps per row
       
        for(int k = n-1; k > 0; k--) {
            
            for(int i = 0; i < k; i++){
                //holds the count of swaps per row
                z += check(i, i+1);   
            }
            //if swaps per row = 0, don't have to start new rows     
            if(z == 0) {k = 0;} 
            z = 0;        
        }  
       
    return nums;
    }
    
   
    
   /** 
    * Check if needs to swap numbers.
    * @param a first value
    * @param b second value
    * @return i 1 if changed once
    */
    private int check(int a, int b){
        compares++;
        int i = 0;
        
         if (type == 0) {   
            if(nums[b] < nums[a]){
                swap(a,b);
                i = 1;
            }  
         }
         else {
            if (type == 1) {   
                if(nums[b] > nums[a]){
                swap(a,b);
                i = 1;
                }
            }
         }
        return i;
    }
    
     /** 
    * Swaps numbers.
    * @param a first value
    * @param b second value
    * @return tag
    */
    private void swap(int a, int b){
        
        swaps++;       
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;   
    }
    
    /** 
    * Shows number of compares and swaps
    */
    public void stats(){
        
        System.out.println("Compares : " + compares);
        System.out.println("Swaps : " + swaps);
    }
    
}
