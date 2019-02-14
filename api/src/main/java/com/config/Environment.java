package com.config;

import java.util.Map;

public class Environment {
    private String create_employee;
    private String claims;
    private String clients;
    private String Xref;
    private String visit;
    private String Emp_get;
    private String Client_get;
    private String open_evv_member;
    private String alt_evv_emp;
    private String alt_evv_clients;
    private String alt_evv_emp_get;
    private String alt_evv_clients_get;
    private String alt_evv_visit_get;
    private String alt_evv_user;
    private String alt_evv_pass;
    private String alt_evv_accId;
    private String claims_username;
    private String claims_pass;
    private String acc;
    private String AccId;
    private String user_name;
    private String user_pass;
    private String OpenEvv_acc;
    private String OpenEvv_AccId;
    private String OpenEvv_user;
    private String OpenEvv_pass;
    private String molina_UserName;
    private String molina_Password;
    private String db_username;
    private String db_password;
    private String alt_evv_visit_user;
    private String alt_evv_visit_pass;
    private String alt_evv_visit_accId;
    private String member_user;
    private String member_pass;
    private String member_accId;
    private String sftpHost;
    private String sftpUserName;
    private String sftpPassword;
    private String dwh;
    private String alt_evv_clients_v1;
    private String swarm_export_dwh;
    private String oracleUrl;
    private String dwh_oracle_user;
    private String dwh_oracle_pass;

    Map<String, String> Environments;

    public Environment() {
    }

    public String getDwh_oracle_user() {
        return dwh_oracle_user;
    }

    public void setDwh_oracle_user(String dwh_oracle_user) {
        this.dwh_oracle_user = dwh_oracle_user;
    }

    public String getDwh_oracle_pass() {
        return dwh_oracle_pass;
    }

    public void setDwh_oracle_pass(String dwh_oracle_pass) {
        this.dwh_oracle_pass = dwh_oracle_pass;
    }

    public String getOracleUrl() {
        return oracleUrl;
    }

    public void setOracleUrl(String oracleUrl) {
        this.oracleUrl = oracleUrl;
    }

    public String getSwarm_export_dwh() {
        return swarm_export_dwh;
    }

    public void setSwarm_export_dwh(String swarm_export_dwh) {
        this.swarm_export_dwh = swarm_export_dwh;
    }

    public String getAlt_evv_clients_v1() {
        return alt_evv_clients_v1;
    }

    public void setAlt_evv_clients_v1(String alt_evv_clients_v1) {
        this.alt_evv_clients_v1 = alt_evv_clients_v1;
    }

    public void setEnvironments(Map envMap){
        Environments = envMap;
    }

    public String getCreate_employee() {
        return create_employee;
    }

    public void setCreate_employee(String create_employee) {
        this.create_employee = create_employee;
    }

    public String getClaims() {
        return claims;
    }

    public void setClaims(String claims) {
        this.claims = claims;
    }

    public String getClients() {
        return clients;
    }

    public void setClients(String clients) {
        this.clients = clients;
    }

    public String getXref() {
        return Xref;
    }

    public void setXref(String xref) {
        Xref = xref;
    }

    public String getVisit() {
        return visit;
    }

    public void setVisit(String visit) {
        this.visit = visit;
    }

    public String getEmp_get() {
        return Emp_get;
    }

    public void setEmp_get(String emp_get) {
        Emp_get = emp_get;
    }

    public String getClient_get() {
        return Client_get;
    }

    public void setClient_get(String client_get) {
        Client_get = client_get;
    }

    public String getOpen_evv_member() {
        return open_evv_member;
    }

    public void setOpen_evv_member(String open_evv_member) {
        this.open_evv_member = open_evv_member;
    }

    public String getAlt_evv_emp() {
        return alt_evv_emp;
    }

    public void setAlt_evv_emp(String alt_evv_emp) {
        this.alt_evv_emp = alt_evv_emp;
    }

    public String getAlt_evv_clients() {
        return alt_evv_clients;
    }

    public void setAlt_evv_clients(String alt_evv_clients) {
        this.alt_evv_clients = alt_evv_clients;
    }

    public String getAlt_evv_emp_get() {
        return alt_evv_emp_get;
    }

    public void setAlt_evv_emp_get(String alt_evv_emp_get) {
        this.alt_evv_emp_get = alt_evv_emp_get;
    }

    public String getAlt_evv_clients_get() {
        return alt_evv_clients_get;
    }

    public void setAlt_evv_clients_get(String alt_evv_clients_get) {
        this.alt_evv_clients_get = alt_evv_clients_get;
    }

    public String getAlt_evv_visit_get() {
        return alt_evv_visit_get;
    }

    public void setAlt_evv_visit_get(String alt_evv_visit_get) {
        this.alt_evv_visit_get = alt_evv_visit_get;
    }

    public String getAlt_evv_user() {
        return alt_evv_user;
    }

    public void setAlt_evv_user(String alt_evv_user) {
        this.alt_evv_user = alt_evv_user;
    }

    public String getAlt_evv_pass() {
        return alt_evv_pass;
    }

    public void setAlt_evv_pass(String alt_evv_pass) {
        this.alt_evv_pass = alt_evv_pass;
    }

    public String getAlt_evv_accId() {
        return alt_evv_accId;
    }

    public void setAlt_evv_accId(String alt_evv_accId) {
        this.alt_evv_accId = alt_evv_accId;
    }

    public String getClaims_username() {
        return claims_username;
    }

    public void setClaims_username(String claims_username) {
        this.claims_username = claims_username;
    }

    public String getClaims_pass() {
        return claims_pass;
    }

    public void setClaims_pass(String claims_pass) {
        this.claims_pass = claims_pass;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public String getAccId() {
        return AccId;
    }

    public void setAccId(String accId) {
        AccId = accId;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_pass() {
        return user_pass;
    }

    public void setUser_pass(String user_pass) {
        this.user_pass = user_pass;
    }

    public String getOpenEvv_acc() {
        return OpenEvv_acc;
    }

    public void setOpenEvv_acc(String openEvv_acc) {
        OpenEvv_acc = openEvv_acc;
    }

    public String getOpenEvv_AccId() {
        return OpenEvv_AccId;
    }

    public void setOpenEvv_AccId(String openEvv_AccI) {
        OpenEvv_AccId = openEvv_AccI;
    }

    public String getOpenEvv_user() {
        return OpenEvv_user;
    }

    public void setOpenEvv_user(String openEvv_user) {
        OpenEvv_user = openEvv_user;
    }

    public String getOpenEvv_pass() {
        return OpenEvv_pass;
    }

    public void setOpenEvv_pass(String openEvv_pass) {
        OpenEvv_pass = openEvv_pass;
    }

    public String getMolina_UserName() {
        return molina_UserName;
    }

    public void setMolina_UserName(String molina_UserName) {
        this.molina_UserName = molina_UserName;
    }

    public String getMolina_Password() {
        return molina_Password;
    }

    public void setMolina_Password(String molina_Password) {
        this.molina_Password = molina_Password;
    }

    public String getDb_username() {
        return db_username;
    }

    public void setDb_username(String db_username) {
        this.db_username = db_username;
    }

    public String getDb_password() {
        return db_password;
    }

    public void setDb_password(String db_password) {
        this.db_password = db_password;
    }

    public String getAlt_evv_visit_user() {
        return alt_evv_visit_user;
    }

    public void setAlt_evv_visit_user(String alt_evv_visit_user) {
        this.alt_evv_visit_user = alt_evv_visit_user;
    }

    public String getAlt_evv_visit_pass() {
        return alt_evv_visit_pass;
    }

    public void setAlt_evv_visit_pass(String alt_evv_visit_pass) {
        this.alt_evv_visit_pass = alt_evv_visit_pass;
    }

    public String getAlt_evv_visit_accId() {
        return alt_evv_visit_accId;
    }

    public void setAlt_evv_visit_accId(String alt_evv_visit_accId) {
        this.alt_evv_visit_accId = alt_evv_visit_accId;
    }

    public String getMember_user() {
        return member_user;
    }

    public void setMember_user(String member_user) {
        this.member_user = member_user;
    }

    public String getMember_pass() {
        return member_pass;
    }

    public void setMember_pass(String member_pass) {
        this.member_pass = member_pass;
    }

    public String getMember_accId() {
        return member_accId;
    }

    public void setMember_accId(String member_accId) {
        this.member_accId = member_accId;
    }

    public String getSftpHost() {
        return sftpHost;
    }

    public void setSftpHost(String sftpHost) {
        this.sftpHost = sftpHost;
    }

    public String getSftpUserName() {
        return sftpUserName;
    }

    public void setSftpUserName(String sftpUserName) {
        this.sftpUserName = sftpUserName;
    }

    public String getSftpPassword() {
        return sftpPassword;
    }

    public void setSftpPassword(String sftpPassword) {
        this.sftpPassword = sftpPassword;
    }

    public String getDwh() {
        return dwh;
    }

    public void setDwh(String dwh) {
        this.dwh = dwh;
    }
}
