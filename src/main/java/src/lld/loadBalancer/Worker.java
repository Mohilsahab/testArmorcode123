package src.lld.loadBalancer;

public class Worker implements IWorker{
    int curTaks;
    int maxTasks;
    int ram;
    int cpu;

    Worker(int curTaks, int maxTasks, int ram, int cpu) {
        this.curTaks = curTaks;
        this.maxTasks = maxTasks;
        this.cpu = cpu;
        this.ram = ram;
    }

    public void executeTasks(int ramCon, int cpuUtilization) throws Exception {
        if (this.ram-ramCon <=0
                || this.cpu-cpuUtilization<=0
                || curTaks==maxTasks) {
            throw new Exception("Excpetion occurred");
        }
        this.ram -= ramCon;
        this.cpu-=cpuUtilization;
        curTaks++;
        System.out.println("Tak executing");
    }


}
