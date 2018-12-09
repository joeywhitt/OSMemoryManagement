package model.process;

import model.MemoryManager;
import model.MemoryObserver;

import java.util.LinkedList;
import java.util.List;

import static javafx.scene.input.KeyCode.O;

public class ProcessSourceObservable {

    private static int id = 1;

    private List<ProcessSourceObserver> observers;
    public ProcessSourceObservable(){
        observers=new LinkedList<>();
    }
    public void addObserver(ProcessSourceObserver obs){
        observers.add(obs);
    }
    public void removeObserver(ProcessSourceObserver obs){
        observers.remove(obs);
    }
    protected void notifyNewProcess(Process p){
        for(ProcessSourceObserver o:observers){
            o.newProcess(p);
        }
    }
    protected void notifyKillProcess(Process p){
        for(ProcessSourceObserver o:observers){
            o.killProcess(p);
        }
    }

    public static ProcessSourceObservable getSimSource(){
        final SimSource simSource = new SimSource(100, id);
        id++;
        return simSource;
    }

    public static ProcessSourceObservable getLocalSource(){
        final LocalSource localSource = new LocalSource(id);
        id++;
        return localSource;
    }
}
