//codechef question
//spell shortening

import java.util.*;


class Codechef
{
     private static String RCI(String inputString, int indexToRemove) {
        StringBuilder modifiedStringBuilder = new StringBuilder(inputString);

        // Remove the character at the specified index
        modifiedStringBuilder.deleteCharAt(indexToRemove);

        // Convert StringBuilder back to String
        return modifiedStringBuilder.toString();
        }
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
			Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        while (a-- > 0) {
            int m = sc.nextInt();
            String s=sc.next();
            char m1=s.charAt(0);
            int flag=0;
                for(int i=1;i<m;i++){
                        char m2=s.charAt(i);
                        if(m1>m2){
                        s=RCI(s,i-1);
                        flag=1; 
                        break;
                        }
                        m1=m2;
                }
                if(flag==0){
                     s=RCI(s,m-1);
                      System.out.println(s);
                }
                else
                      System.out.println(s);
	}
		

	}
}

