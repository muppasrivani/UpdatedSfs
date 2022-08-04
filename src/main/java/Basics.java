import java.util.Scanner;
public class Basics {

	public void stringPractice() {
		String name1="EE Soft";
		String name2="India";
		int num=30;
		
		System.out.println(String.format("The %s is top most institute among %d companies in %s",name1,num,name2));
	}
	public void arrayPractice() {
		int size=10;
		String[] items=new String[size];
		System.out.println("Enter "+size+" items");
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<items.length;i++) {
			items[i]=scan.next();		
		}
		for(int i=0;i<items.length;i++) {
			System.out.println("Item at index "+i+" is "+items[i]);
		}
		
	}
	

}
