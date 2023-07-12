package components;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.swing.JPanel;

public class MainOffice implements Runnable{
	private ReadWriteLock lock = new ReentrantReadWriteLock();
	private Customer c1,c2;
	private Executor executor;

	private static volatile MainOffice mainOffice = null;
	private static int clock=0;
	private static Hub hub;
	private ArrayList<Package> packages=new ArrayList<Package>();
	private JPanel panel;
	private int maxPackages;
	private boolean threadSuspend = false;
	private File file;
	private int numOfCustomers = 2;
	

	
	private MainOffice(int branches, int trucksForBranch, JPanel panel, int maxPack) {
		this.panel = panel;
		this.maxPackages = maxPack;
		addHub(trucksForBranch);
		addBranches(branches, trucksForBranch);
		this.c1 = new Customer(1,branches);
		this.c2 = new Customer(2,branches);
		this.executor = Executors.newFixedThreadPool(2);
		file=new File("p.txt");
		System.out.println("\n\n========================== START ==========================");
	}

	public File getFile() {
		return file;
	}
	
	public static MainOffice getInstance() {
		if (mainOffice == null) {
			try {
				throw new Exception("Object not created");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainOffice;
	}

	public static MainOffice setInstance(int branches, int trucksForBranch, JPanel panel, int maxPack) {
 		if (mainOffice == null)
			synchronized (MainOffice.class) {
				if (mainOffice == null)
					mainOffice = new MainOffice(branches, trucksForBranch, panel, maxPack);
			}
		return mainOffice;
	}

	public static Hub getHub() {
		return hub;
	}


	public static int getClock() {
		return clock;
	}

	@Override
	public void run() {
		Thread hubThrad = new Thread(hub);
		hubThrad.start();
		for (Truck t : hub.listTrucks) {
			Thread trackThread = new Thread(t);
			trackThread.start();
		}
		for (Branch b : hub.getBranches()) {
			Thread branch = new Thread(b);
			for (Truck t : b.listTrucks) {
				Thread trackThread = new Thread(t);
				trackThread.start();
			}
			branch.start();
		}
		while (true) {
			synchronized (this) {
				while (threadSuspend)
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

				if (!(c1.isEnd()))
					new Thread(c1).start();
				else if (numOfCustomers < 10) {
					c1 = new Customer(numOfCustomers + 1, hub.getBranches().size());
					numOfCustomers++;
				}
				if (!(c2.isEnd()))
					new Thread(c2).start();
				else if (numOfCustomers < 10) {
					c2 = new Customer(numOfCustomers + 1, hub.getBranches().size());
					numOfCustomers++;
				}
			}
			tick();
		}
	}

	
	public void printReport() {
		for (Package p: packages) {
			System.out.println("\nTRACKING " +p);
			for (Tracking t: p.getTracking())
				System.out.println(t);
		}
	}

	public String clockString() {
		String s="";
		int minutes=clock/60;
		int seconds=clock%60;
		s+=(minutes<10) ? "0" + minutes : minutes;
		s+=":";
		s+=(seconds<10) ? "0" + seconds : seconds;
		return s;
	}

	
	public void tick() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(clockString());
		clock++;
		panel.repaint();
	}


	public Package addPackage(Address sender) {
		Random r = new Random();
		Package p;
		Branch br;
		Priority priority=Priority.values()[r.nextInt(3)];
		Address dest = new Address(r.nextInt(hub.getBranches().size()), r.nextInt(999999)+100000);
		switch (r.nextInt(3)){
			case 0:
				p = new SmallPackage(priority,  sender, dest, r.nextBoolean() );
				br = hub.getBranches().get(sender.zip);
				br.addPackage(p);
				p.setBranch(br);
				break;
			case 1:
				p = new StandardPackage(priority,  sender, dest, r.nextFloat()+(r.nextInt(9)+1));
				br = hub.getBranches().get(sender.zip);
				br.addPackage(p);
				p.setBranch(br);
				break;
			case 2:
				p=new NonStandardPackage(priority,  sender, dest,  r.nextInt(1000), r.nextInt(500), r.nextInt(400));
				hub.addPackage(p);
				break;
			default:
				p=null;
		}
		this.packages.add(p);
		maxPackages--;
		return p;
	}
	
	public void branchWork(Branch b) {
		for (Truck t : b.listTrucks) {
			t.work();
		}
		b.work();
	}

	
	public void addHub(int trucksForBranch) {
		hub=new Hub();
		for (int i=0; i<trucksForBranch; i++) {
			Truck t = new StandardTruck();
			hub.addTruck(t);
		}
		Truck t=new NonStandardTruck();
		hub.addTruck(t);
	}
	
	
	public void addBranches(int branches, int trucks) {
		for (int i=0; i<branches; i++) {
			Branch branch=new Branch();
			for (int j=0; j<trucks; j++) {
				branch.addTruck(new Van());
			}
			hub.add_branch(branch);
		}
	}

	public void addBranch(Branch b) {
		hub.add_branch(b);
	}

	public Branch getBranch(String BranchId) {
		Branch cachedBranch = getHub().getBranches().get(Integer.parseInt(BranchId));
		return cachedBranch.clone();
	}
	
	public ArrayList<Package> getPackages(){
		return this.packages;
	}


	public synchronized void setSuspend() {
	   	threadSuspend = true;
		for (Truck t : hub.listTrucks) {
			t.setSuspend();
		}
		for (Branch b: hub.getBranches()) {
			for (Truck t : b.listTrucks) {
				t.setSuspend();
			}
			b.setSuspend();
		}
		hub.setSuspend();
	}
	
	
	public synchronized void setResume() {
	   	threadSuspend = false;
	   	notify();
	   	hub.setResume();
		for (Truck t : hub.listTrucks) {
			t.setResume();
		}
		for (Branch b: hub.getBranches()) {
			b.setResume();
			for (Truck t : b.listTrucks) {
				t.setResume();;
			}
		}
	}

	public ReadWriteLock getLock() {
		return lock;
	}


	public int getMaxPackages() {
		return maxPackages;
	}

	public String Read() {
		String line = "";
		String result ="";
		Path currentRelativePath = Paths.get("");
		lock.readLock().lock();
		try {
			BufferedReader br = new BufferedReader(
					new FileReader(currentRelativePath.toAbsolutePath().toString() +"\\"+ MainOffice.getInstance().getFile()));
			while ((line = br.readLine()) != null) // returns a Boolean value
			{
				result+=line;
				result+='\n';
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			lock.readLock().unlock();
		}
		return result;
	}

	


}






