import java.util.*;

public class Time {
    private int hour;
    private int minute;

    public Time() {
        // Set seluruh atribut dengan nilai 0
        hour = 0;
        minute = 0;
    }

    public Time(int hour, int minute) {
		this.hour = hour;
		this.minute = minute;
    }

    public Time(Time t) {
        // Set atribut dengan atribut milik t
        this.hour = t.hour;
        this.minute = t.minute;
    }

    public int getHour() {
		return hour;
    }

    public void setHour(int hour) {
		this.hour = hour;
    }

    public int getMinute() {
		return minute;
    }

    public void setMinute(int minute) {
		this.minute = minute;
    }


    public int convertToSecond() {
		return (hour * 3600) + (minute * 60);
    }

    public Time add(Time t) {
        // Return penjumlahan dua objek jam, yaitu *this* dan t.
        // Apabila hasil penjumlahan melebihi 23:59:59, maka Anda harus mengonversinya seperti tampilan jam digital asli.
        // Contoh : 24:00:00 dituliskan 00:00:00, 25:00:00 dituliskan 01:00:00, dst.
        Time T = new Time();
        int total;
        
		    total = this.convertToSecond() + (t.hour * 3600 + t.minute * 60);
		    total = total % (60 * 60 * 24);
	
	    	T.hour = total / 3600;
		    T.minute = total % 3600 / 60;
		
		    return T;
    }

    public Time minus(Time t) {
        // Return selisih antara dua objek jam, yaitu *this* dan t.
        // Perhitungan selisih hanya dapat dilakukan jika objek ruas kiri lebih akhir dari atau sama dengan objek ruas kanan.
        // Jika objek ruas kiri lebih awal, maka kembalikan nilai objek ruas kiri.
        // Contoh: 00:00:01 - 00:00:02 = 00:00:01
        Time T = new Time();
        int total;
        
        if (this.convertToSecond() < (t.hour * 3600 + t.minute * 60)) {
			return this;
		} else {
			total = this.convertToSecond() - (t.hour * 3600 + t.minute * 60);
			//total = total / 3600 * 60;
		
			T.hour = total / 3600;
			T.minute = total % 3600 / 60;
		
			return T;
		}
    }

    public boolean lessThan(Time t) {
        // Returns true jika *this* < t menurut definisi waktu
        return this.convertToSecond() < (t.hour * 3600 + t.minute * 60);
    }

    public boolean greaterThan(Time t) {
        // Returns true jika *this* > t menurut definisi waktu
        return this.convertToSecond() > (t.hour * 3600 + t.minute * 60);
    }

    public void printTime() {
        // Menuliskan jam dalam format hh:mm:ss diakhiri dengan newline. Perhatikan bahwa setiap parameter harus dituliskan 2 digit.
        System.out.printf("%02d:%02d\n", hour, minute);
    }

    public static void main (String[] args) {
        /*Time t0 = new Time(10, 0);
        Time t1 = new Time(9, 0);
        Time t2 = new Time();

        t2 = t0.add(t1);

        t2.printTime();*/
	}
}
