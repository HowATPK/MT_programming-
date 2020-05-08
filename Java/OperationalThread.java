import java.util.*;

class OperationalThread extends Thread{

private List<char[]> charArray;
private int counter1,counter2,counter3,number,n,m;
private char a,b,c;

public OperationalThread(List<char[]> arraych,int n,int m,char a,char b,char c,int number){

    this.charArray=arraych;
    this.n=n; this.m=m; this.number=number;
    this.a=a; this.b=b; this.c=c;
    }

    public void run() {
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            //System.out.print(charArray.get(i)[j]);
            if(charArray.get(i)[j]==a)counter1++;
            if(charArray.get(i)[j]==b)counter2++;
            if(charArray.get(i)[j]==c)counter3++;
        }
    }
        System.out.println("Wątek: "+number+"  znaków:"+a+" :"+counter1);
        System.out.println("Wątek: "+number+"  znaków:"+b+" :"+counter2);
        System.out.println("Wątek: "+number+"  znaków:"+c+" :"+counter3);
    }

}

