package activity4login;


public class Accounts {
    private String username;
    private String password;
    private int Id;

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public Accounts(int Id,String username, String password) {
        this.Id=Id;
        this.username = username;
        this.password = password;
    }
    public Accounts(int Id){
        this.Id= Id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String toString(){
        return String.format("%d\t%s\t%s", this.Id,this.username,this.password);
    }
    
}
