package practice;

public class QuickSort {
	
	int partition(Integer expenses[], int low, int high) 
    { 
        int pivot = expenses[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            if (expenses[j] < pivot) 
            { 
                i++;  
                int temp = expenses[i]; 
                expenses[i] = expenses[j]; 
                expenses[j] = temp; 
            } 
        } 
  
        int temp = expenses[i+1]; 
        expenses[i+1] = expenses[high]; 
        expenses[high] = temp;   
        return i+1; 
    } 
  
    void sort(Integer expenses[], int low, int high) 
    { 
        if (low < high) 
        { 
            int pi = partition(expenses, low, high); 
  
            sort(expenses, low, pi-1); 
            sort(expenses, pi+1, high); 
        } 
    } 
}
