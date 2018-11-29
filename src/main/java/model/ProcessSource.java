package model;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface ProcessSource {

    public List<Process> getAll();
    
    public Process generateProcess();

    public default CompletableFuture<Process> generateAsync() {
        return CompletableFuture.supplyAsync(this::generateProcess);
    }
}
