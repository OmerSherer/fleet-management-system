package frontend.serializable;

import java.io.Serializable;

public class AgentData implements Serializable {
    public String ID;

    public AgentData() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

}
