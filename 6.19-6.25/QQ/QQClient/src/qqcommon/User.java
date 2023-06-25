package qqcommon;

import java.io.Serializable;

/**
 * 该程序的说明如下：
 * 表示一个用户/客户信息
 */
public class User implements Serializable {
    private static final long serialVersionUID = 1l;
    private String userId;
    private String passwd;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
