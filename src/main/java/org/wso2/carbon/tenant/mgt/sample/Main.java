package org.wso2.carbon.tenant.mgt.sample;


/**
 * Created by aruna on 5/21/15.
 */
public class Main {

    public static void main(String[] args) {
        try {
            setKeyStoreProperties();
            String cookie = AuthenticationAdmin.getCookie();
            System.out.println(cookie);
            TenantMgtAdmin.addTenant(cookie);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void setKeyStoreProperties() throws Exception {
        System.setProperty("javax.net.ssl.trustStore", "/home/aruna/wso2/products/wso2as-5.2.1/repository/resources/security/wso2carbon.jks");
    }
}