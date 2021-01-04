package src.loadBalancer;

public interface IWorker {
    void executeTasks(int ramCon, int cpuUtilization) throws Exception;
}
