public class UserInfo {
    public String first_name;
    public int id;
    public String last_name;
    public boolean can_invite_to_chats;

    public UserInfo(int id, String first_name, String last_name, boolean can_invite_to_chats){
        this.first_name = first_name;
        this.last_name = last_name;
        this.id = id;
        this.can_invite_to_chats = can_invite_to_chats;
    }
}
