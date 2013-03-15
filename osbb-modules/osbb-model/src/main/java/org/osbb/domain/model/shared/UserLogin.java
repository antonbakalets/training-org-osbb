package org.osbb.domain.model.shared;

import java.io.Serializable;
import javax.persistence.*;
import org.osbb.domain.model.Identifiable;

/**
 *
 * @author Anton Bakalets
 */
@Entity()
@Table(name = "User_Login")
public class UserLogin implements Serializable, Identifiable<Integer> {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "login_id")
    protected Integer id;
    
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    
    @Basic(optional = false)
    @Column(name = "database_name")
    private String databaseName;
    
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    
    @Column(name = "activation_uuid")
    private String activationUUID;
    
    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getActivationUUID() {
        return activationUUID;
    }

    public void setActivationUUID(String activationUUID) {
        this.activationUUID = activationUUID;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }
    
    @Override
    public String toString() {
        return "UserLogin[ id=" + id + ", database=" + databaseName + " ]";
    }   
   
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UserLogin)) {
            return false;
        }
        UserLogin other = (UserLogin) object;
        if ((this.id == null && other.getId() != null) || (this.id != null && !this.id.equals(other.getId()))) {
            return false;
        }
        return true;
    }
}
