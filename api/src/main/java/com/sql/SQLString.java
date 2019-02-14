package com.sql;

public class SQLString {

    public static final String sql_getClientGeneral = "SELECT supp.CONTRACT, accinterface.PROVIDER_ID, client.LOC, client.F_NAME, client.M_NAME, client.L_NAME,\n" +
            "supp.CLIENT_SSN, supp.AR_NO, supp.MEDICAID_ID as MEDICAID_ID, supp.CLIENT_ID_CUSTOM1 as ClientCustomID,\n" +
            "supp.CLIENT_ID_CUSTOM2 as ClientOtherID, client.name_suffix, supp.case_manager, supp.case_manager_e_mail,\n" +
            "client.spv, client.spv_e_mail, supp.language, supp.sex, supp.marital_status_code, supp.dob,\n" +
            "supp.e_mail, supp.client_priority, client.tzname, appuser.user_f_name, appuser.user_l_name,\n" +
            "appuser.username, \n" +
            "case when appuser.account_status is not null and account_status = 'OPEN' then '2' END as ACCOUNT_STATUS,\n" +
            "appuser.created, \n" +
            "case when appuser.lock_date < appuser.expire_date and appuser.lock_date < appuser.deleted then appuser.lock_date\n" +
            "when appuser.expire_date < appuser.lock_date and appuser.expire_date < appuser.deleted then appuser.expire_date\n" +
            "else appuser.expire_date end as ClientDesigneeEndDate, \n" +
            "contact.contact_relationship, contact.f_name as ClientContactFirstName,\n" +
            "contact.l_name as ClientContactLastName, \n" +
            "case when contact.PHONENUM_BUSINESS is not null then 'Business'\n" +
            "when contact.PHONENUM_HOME is not null then 'Home'\n" +
            "when contact.PHONENUM_MOBILE is not null then 'Mobile'\n" +
            "when contact.PHONENUM_OTHER is not null then 'Other'\n" +
            "END as ClientContactPhoneType,\n" +
            "case when contact.PHONENUM_BUSINESS is not null then contact.PHONENUM_BUSINESS\n" +
            "when contact.PHONENUM_HOME is not null then contact.PHONENUM_HOME\n" +
            "when contact.PHONENUM_MOBILE is not null then contact.PHONENUM_MOBILE\n" +
            "when contact.PHONENUM_OTHER is not null then contact.PHONENUM_OTHER\n" +
            "END as ClientContactPhone,\n" +
            "contact.e_mail as ClientContactEmailAddress, contact.addr1 as ClientContactAddressLine1,\n" +
            "contact.addr2 as ClientContactAddressLine2, contact.city, contact.state, contact.zip_code\n" +
            "FROM STX.CLIENTS client\n" +
            "JOIN STX.ACCOUNTS_INTERFACES accinterface ON accinterface.ACCOUNT = client.ACCOUNT\n" +
            "JOIN STX.CLIENTS_SUPP supp ON supp.CLIENTKEY = client.CLIENTKEY\n" +
            "JOIN STX.CLIENTS_CONTACT contact ON contact.CLIENTKEY = client.CLIENTKEY\n" +
            "LEFT JOIN STX.app_users appuser ON appuser.USRSVKEY = client.CLIENTKEY\n" +
            "WHERE client.ACCOUNT LIKE '%s'\n" +
            "AND client.F_NAME LIKE '%s' and client.L_NAME LIKE '%s'";
}


