

package oddeventhreads;

/**
 *
 * 
 */
class OddNumberThread extends Thread {
    @Override
    public void run() {
        try {
        
            for (int i = 1; i <= 20; i += 2) {
                System.out.println("Odd Thread: " + i);
                Thread.sleep(500); 
            }
        } catch (InterruptedException e) {
            System.err.println("Odd Thread interrupted: " + e.getMessage());
        }
    }
}

class EvenNumberThread extends Thread {
    @Override
    public void run() {
        try {
       
            for (int i = 2; i <= 20; i += 2) {
                System.out.println("Even Thread: " + i);
                Thread.sleep(500);  
            }
        } catch (InterruptedException e) {
            System.err.println("Even Thread interrupted: " + e.getMessage());
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {

        Thread oddThread = new OddNumberThread();
        Thread evenThread = new EvenNumberThread();

        try {
       
            oddThread.start();
            evenThread.start();

            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread interrupted: " + e.getMessage());
        }

        System.out.println("Both threads have finished execution.");
    }
}

