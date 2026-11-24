package org.parkinglot.parkinglot.common;

public class UserDTO
{
    Long id;
    String email;
    String password;
    String username;

    public UserDTO(Long id, String email, String password, String username)
    {
        this.id = id;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public UserDTO(Long id, String username, String email)
    {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getUsername() { return username; }
}
