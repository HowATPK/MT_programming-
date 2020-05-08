import java.util.*;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainApp{
    public static void main(String args[]){
        //--------------------------------------------deklaracje zmiennych----------------------------------------------
        Random r=new Random();
        String Symbols="abcdefghijklmnoprstuwz123456789";
        int n=15,m=10;
        List<char[]> charArray = new ArrayList<char[]>(n);
        for(int i=0;i<n;i++) charArray.add(new char[m]);
        //--------------------------------------------inicjalizacja listy i wypisanie jej-------------------------------
        for (int i = 0; i <n ; i++)
        {
            for (int j = 0; j < m; j++)
            {
                charArray.get(i)[j]=Symbols.charAt(r.nextInt(Symbols.length()));
            }
        }
        for (int i = 0; i <n ; i++)
        {
            for (int j = 0; j < m; j++) System.out.print(charArray.get(i)[j]);
            System.out.println();
        }
        System.out.println("\n\n");
        //-----------------------------------------------threads--------------------------------------------------------
        int num_threads = 10;
        OperationalThread[] NewThr = new OperationalThread[num_threads];
        for (int i = 0; i < num_threads; i++) {
            (NewThr[i] = new OperationalThread(charArray,n,m,Symbols.charAt(r.nextInt(Symbols.length())),Symbols.charAt(r.nextInt(Symbols.length())),Symbols.charAt(r.nextInt(Symbols.length())),i)).start();
        }

        for (int i = 0; i < num_threads; i++) {
            try {
                NewThr[i].join();
            } catch (InterruptedException e) {
            }
        }
    }
}


