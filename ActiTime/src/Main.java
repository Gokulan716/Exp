import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;  
		Scanner sc=new Scanner(System.in);  
		n=sc.nextInt();  
		int[] a = new int[n];  
		System.out.println("Enter the elements of the array: ");  
		for(int i=0; i<=n; i++)  
		{  
			a[i]=sc.nextInt();  
		}  
		for(int i=0;i<a.length;i++){
			int count=0;
			int first=0;
			first=a[i];
			if(a[i+1]-a[i]==1){
				count++;
				int last=a[i]+count;
				i++;
				System.out.println(first + " " + last);
			}
			else{
				System.out.println(a[i]);
			}
		}
	}
}
