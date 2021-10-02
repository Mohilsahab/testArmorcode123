package src.lld.loadBalancer;

import java.util.ArrayList;
import java.util.List;

public class LoadBalancer {

    //Load Balancer

    List<Worker> workers = new ArrayList<>();
    int count;

    LoadBalancer(int count, int maxTasks) {
        for (int i=0;i<count; i++) {
            workers.add(new Worker(0 , maxTasks, 100, 100));
        }
        this.count = count;
    }

    public int executeTasks(int ramCon, int cpuUtilization) throws Exception {
        //getRandomNumber Less Than workers size
        int ran = 0;
        for (int i = 0; i < 10; i++) {
            ran = (int)(Math.random())%count;
        }
        if (workers == null || workers.size() ==0) {
            throw new Exception("Excpetion occurred");
        }
        Worker worker = workers.get(ran);
        worker.executeTasks(ramCon, cpuUtilization);
        return ran;
    }
}
