package src.lld.loadBalancer;

public interface IWorker {
    void executeTasks(int ramCon, int cpuUtilization) throws Exception;
}
