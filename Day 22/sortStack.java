//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG {
    public Stack<Integer> sort(Stack<Integer> s) {
        sortStack(s);
        return s;
    }
    
	void sortStack(Stack<Integer> s) {
		if (!s.isEmpty()) {
		    int temp = s.pop();
		    
		    sortStack(s);
		    
		    sortInserted(s, temp);
		}
	}
	
	void sortInserted(Stack<Integer> s, int temp) {
	    if (s.isEmpty() || temp >= s.peek()) {
	        s.push(temp);
	        return;
	    }
	    
	    int temp2 = s.pop();
	    
	    sortInserted(s, temp);
	    
	    s.push(temp2);
	}
}
