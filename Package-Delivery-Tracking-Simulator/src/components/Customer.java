package components;


import java.util.ArrayList;
import java.util.Random;

public class Customer implements Runnable {
    private ArrayList<Package> packages = new ArrayList<Package>();
    private Address sender;
    private int num;
    private int time;
    private int count = 5;
    private int ran;
    

    public Customer(int num, int branches) {
        Random r = new Random();
        time = MainOffice.getClock();
        // time is the clock plus 2-5 seconds
        ran = 2 + (new Random()).nextInt(4);
        time+=ran;
        this.sender = new Address(r.nextInt(branches), r.nextInt(999999) + 100000);
        this.num = (num + 1);
    }

    public Address getAddress() {
        return this.sender;
    }

    public boolean isEnd(){
        if (packages.size()==0) return false;
        for(Package p:packages)
            if (!(p.getStatus()==Status.DELIVERED))
                return false;
        return true;
    }

    @Override
    public void run() {
//        time += ran;
        if (MainOffice.getInstance().getClock() > time) {
            time+=ran;
            if (count > 0) {
                if (MainOffice.getInstance().getMaxPackages() > 0) {
                    Package package1 = MainOffice.getInstance().addPackage(getAddress());
                    packages.add(package1);
                    count--;
                }
            }
        }
    }
}