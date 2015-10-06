package language;

import java.util.Objects;

/**
 *
 * @author Fintan Kelly
 */
public class UserClass {

    String userName;
    int userID;

    public UserClass() {
        userName = "";
        userID = -1;
    }

    public UserClass(String name) {
        userName = name;
        userID = -1;
    }

    public UserClass(String name, int id) {
        this(name);
        userID = id;
    }

    public String getName() {
        return userName;
    }

    public int getID() {
        return userID;
    }

    public void setName(String name) {
        userName = name;
    }

    public void setID(int id) {
        userID = id;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Username: ").append(userName).append("\n");
        builder.append("User ID: ").append(userID).append("\n");
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof UserClass) {
            UserClass object = (UserClass) obj;
            if ((object.getName().equals(userName)) && (object.getID() == userID)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, userID);
    }
}
