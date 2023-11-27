import java.util.Scanner;

public class DemoThread {

    public static void main(String[] args) throws InterruptedException {
        Thread Dist =new Thread(){
            @Override
            public void run()  {
                Thread PrintPdf =new Thread(){
                    @Override
                    public void run() {
                        Thread Take =new Thread(){
                            @Override
                            public void run() {
                                for (int i = 0; i < 10; i++) {
                                    System.out.println("Take");
                                    try {
                                        Thread.sleep(1000);
                                    }catch (Exception c){}
                                }
                            }
                        };
                        Take.start();
                        try {
                            Take.join();
                        }catch (Exception c){}
                        for (int i = 0; i < 10; i++) {
                            System.out.println("Print");
                            try {
                                Thread.sleep(1000);
                            }catch (Exception c){}
                        }
                    }
                };
                PrintPdf.start();
                try {
                    PrintPdf.join();
                }catch (Exception c){}
                for (int i = 0; i < 10; i++) {
                    System.out.println("Dis");
                    try {
                        Thread.sleep(1000);
                    }catch (Exception c){}
                }
            }
        };
        Dist.start();
    }
}

