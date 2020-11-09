
package Server.serverCommunication;

import java.io.Serializable;
import java.util.HashMap;

public class InfoServer implements Serializable{
    private HashMap<Integer,ServerInfoToClients> usersRegistrations;

    public InfoServer() {
        this.usersRegistrations = new HashMap<>();
    }

    public HashMap<Integer, ServerInfoToClients> getUsersRegistrations() {
        return usersRegistrations;
    }
    
    public ServerInfoToClients getServerInfo(int index){
        return usersRegistrations.get(index);
    }
    
    public boolean setClient(int index,int nClients){
        ServerInfoToClients aux = usersRegistrations.get(index);
        
        if(aux != null){
            aux.setnClients(nClients);
            return true;
        }
        return false;
    }
    
}
