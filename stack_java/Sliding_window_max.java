import java.util.*;

public class Sliding_window_max {

  public static int[] solve(int[]

    i

    
    int[] nge = new int[n];
    
    for(int i= n-1;i>= 0 ;i--){
        while(!st.isEmpty() && arr[i] > arr[st.peek()])st.pop();
        
        nge[i] = st.isEmpty() ? n : st.peek();

        st.push(i);
    }
 
    int j = 0;
    for(int i=0;i<n;i++)
 



  }

}