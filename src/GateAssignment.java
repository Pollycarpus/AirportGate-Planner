/**
 * @author Rabbi Fijar Mayoza -- 13516081 -- Teknik Informatika ITB
 */

import java.util.*;

import com.sun.javafx.runtime.SystemProperties;

//Main Program
class GateAssignment {
    public static List<Flight> queueList = new ArrayList<Flight>();
    public static List<Flight> ungatedList = new ArrayList<Flight>();
    public static List<Integer> gateScheduler = new ArrayList<Integer>(); 

    public static void main(String[] args) {
        //Inisiasi data
        Time a1 = new Time(9, 0); Time d1 = new Time(14, 0); Flight f1 = new Flight(1, a1, d1);
        Time a2 = new Time(9, 6); Time d2 = new Time(10, 0); Flight f2 = new Flight(2, a2, d2);
        Time a3 = new Time(9, 10); Time d3 = new Time(10, 15); Flight f3 = new Flight(3, a3, d3);
        Time a4 = new Time(9, 21); Time d4 = new Time(10, 25); Flight f4 = new Flight(4, a4, d4);
        Time a5 = new Time(9, 40); Time d5 = new Time(10, 40); Flight f5 = new Flight(5, a5, d5);
        Time a6 = new Time(10, 0); Time d6 = new Time(10, 45); Flight f6 = new Flight(6, a6, d6);
        Time a7 = new Time(10, 15); Time d7 = new Time(10, 50); Flight f7 = new Flight(7, a7, d7);
        Time a8 = new Time(10, 25); Time d8 = new Time(11, 22); Flight f8 = new Flight(8, a8, d8);
        Time a9 = new Time(10, 50); Time d9 = new Time(11, 30); Flight f9 = new Flight(9, a9, d9);
        Time a10 = new Time(11, 22); Time d10 = new Time(11, 55); Flight f10 = new Flight(10, a10, d10);
        Time a11 = new Time(11, 37); Time d11 = new Time(12, 10); Flight f11 = new Flight(11, a11, d11);
        Time a12 = new Time(11, 52); Time d12 = new Time(12, 20); Flight f12 = new Flight(12, a12, d12);
        Time a13 = new Time(12, 10); Time d13 = new Time(12, 50); Flight f13 = new Flight(13, a13, d13);
        Time a14 = new Time(12, 20); Time d14 = new Time(13, 0); Flight f14 = new Flight(14, a14, d14);
        Time a15 = new Time(12, 50); Time d15 = new Time(13, 10); Flight f15 = new Flight(15, a15, d15);
        Time a16 = new Time(13, 5); Time d16 = new Time(13, 35); Flight f16 = new Flight(16, a16, d16);
        Time a17 = new Time(13, 10); Time d17 = new Time(13, 55); Flight f17 = new Flight(17, a17, d17);
        Time a18 = new Time(13, 35); Time d18 = new Time(14, 20); Flight f18 = new Flight(18, a18, d18);
        Time a19 = new Time(13, 55); Time d19 = new Time(14, 40); Flight f19 = new Flight(19, a19, d19);
        Time a20 = new Time(14, 0); Time d20 = new Time(15, 0); Flight f20 = new Flight(20, a20, d20);

        queueList.add(f1);
        queueList.add(f2);
        queueList.add(f3);
        queueList.add(f4);
        queueList.add(f5);
        queueList.add(f6);
        queueList.add(f7);
        queueList.add(f8);
        queueList.add(f9);
        queueList.add(f10);
        queueList.add(f11);
        queueList.add(f12);
        queueList.add(f13);
        queueList.add(f14);
        queueList.add(f15);
        queueList.add(f16);
        queueList.add(f17);
        queueList.add(f18);
        queueList.add(f19);
        queueList.add(f20);

        //Algoritma
        
        int m;
        int gNum, min, idmin;
        boolean found;

        Scanner input = new Scanner(System.in);

        System.out.println("Masukkan jumlah gate :");
        m = input.nextInt();

        for(int i = 0; i < m; i++){
            gateScheduler.add(-1);
        }

        for(int i = 0; i < queueList.size(); i++){
            gNum = 1;
            //System.out.println(queueList.get(i).getId());
            found = false;
            idmin = 0;
            min = 99999;
            for(gNum = 1; gNum <= gateScheduler.size(); gNum++){
                if((gateScheduler.get(gNum - 1) <= queueList.get(i).getArr().convertToSecond())){
                    int x = queueList.get(i).getArr().convertToSecond() - gateScheduler.get(gNum - 1);
                    if(x < min){
                        min = x;
                        idmin = gNum - 1;
                    }
                    found = true;
                }
            }
            if(found){
                if(queueList.get(i).getDep().convertToSecond() - queueList.get(i).getArr().convertToSecond() >= 4 * 3600){
                    Flight temp = new Flight();
                    temp = queueList.get(i).tow();
                    temp.setId(queueList.get(i).getId());
                    int j = 0;
                    while(j < queueList.size()){
                        if(queueList.get(j).getDep().convertToSecond() > temp.getDep().convertToSecond()){
                            queueList.add(j, temp);
                            break;
                        }else{
                            j++;
                        }
                    }
                }
                queueList.get(i).setGate(idmin+1);
                gateScheduler.set(idmin, queueList.get(i).getDep().convertToSecond());
            } else {
                Flight temp = new Flight();
                temp = queueList.remove(i);
                ungatedList.add(temp);
                i--;
            }
        }
        for(int i = 0; i < queueList.size(); i++){
            System.out.println("ID Penerbangan : " + queueList.get(i).getId() + " #Gate : " + queueList.get(i).getGate()); 
            System.out.println("Jadwal Pemakaian Gate: ");
            queueList.get(i).getArr().printTime();
            System.out.println("Sampai ");
            queueList.get(i).getDep().printTime();
            System.out.println("------------------------------");
        }
        
        for(int i = 0; i < ungatedList.size(); i++){
            System.out.println("ID Penerbangan Ungated: " + ungatedList.get(i).getId());
            System.out.println("------------------------------");
        }

        System.out.println("Persentase penerbangan yang dilayani oleh gate : "+ (queueList.size() - ungatedList.size()) * 100.0 / queueList.size() + " %");
    }
}
