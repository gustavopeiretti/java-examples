package patterns.proxy;

public class ProxyBatchProcess implements BatchProcess {

    private BatchProcessImpl batchProcess;
    private String fileName;

    public ProxyBatchProcess(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void process() {
        if (batchProcess == null) {
            batchProcess = new BatchProcessImpl(fileName);
        }
        batchProcess.process();
    }
}
