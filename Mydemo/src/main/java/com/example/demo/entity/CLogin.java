package com.example.demo.entity;

public class CLogin {
        private Integer id;

        private String username;

        private String userid;

        private String password;
         private String   Perms;

        public CLogin() {
            super();
        }

        public CLogin(String username, String password) {
            this.username = username;
            this.password = password;
        }

        public CLogin(String username, String userid, String password,String  Perms) {
            this.userid = userid;
            this.username = username;
            this.password = password;
            this.Perms=Perms;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPerms() {
        return Perms;
      }

        public void setPerms(String perms) {
        Perms = perms;
    }


    @Override
    public String toString() {
        return "CLogin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", userid='" + userid + '\'' +
                ", password='" + password + '\'' +
                ", Perms='" + Perms + '\'' +
                '}';
    }
}
