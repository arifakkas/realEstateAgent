
package se311project;

import java.io.IOException;
import java.io.Serializable;

public class agentAdapter implements Serializable{
    
    private static agentAdapter _adapter;
    
    public agentAdapter(){
        
    }
    public static agentAdapter getAdapter(){
        if(_adapter == null){
            _adapter = new agentAdapter();
        }
        return _adapter;
    }
    
    void execute(Command command) throws IOException, ClassNotFoundException{
        command.executeCommand();
    }
    
}
