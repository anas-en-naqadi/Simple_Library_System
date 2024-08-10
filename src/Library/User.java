package Library;

public abstract class User {
    private String name, userId, email, password;


    public User(String n, String u, String e, String p) {
        name = n;
        userId = u;
        email = e;
        password = p;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
// getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String id) {
        this.userId = id;
    }

    // functions

    public Boolean changePassword(String current_pass, String new_pass) {
        if (password.equals(current_pass))
            password = new_pass;
        else
            return false;

        return true;
    }

    public abstract String getRole();

    @Override
    public String toString() {
        return
                "name='" + name + '\'' +
                        ", userId='" + userId + '\'' +
                        ", email='" + email + '\'' +
                        ", password='" + password;
    }
}
