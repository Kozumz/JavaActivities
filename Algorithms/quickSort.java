package Algorithms;
public class quickSort {
    public static void main(String [] args){
        int [] arr = {2,1,5,4,7,8,4,9,10,12};
        int n = arr.length;
        sort(arr, 0 , n-1);
    }

    public static int partition(int[] arr, int left, int right){
        int pivot = left 


        return pivot;
    }

    public static void sort(int [] arr, int left, int right){
        if(left < right){

            int pivot = partition(arr, left, right);

            //Mayores
            sort(arr, pivot + 1, right);
            //Menores
            sort(arr, left, pivot - 1);

        }
        
    }

    public static void swap(int [] arr){

    }
}