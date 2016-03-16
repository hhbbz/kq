package aode.kq.model;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by 黄柏樟 on 2016/3/8.
 * @Explain: 商家类
 */
@Table(name = "admin")
public class Admin {
    @Id
    private Long id ;
    private String name ;
    private String password ;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
