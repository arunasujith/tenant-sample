package org.wso2.carbon.tenant.mgt.sample;

import org.apache.axis2.transport.http.HTTPConstants;
import org.wso2.carbon.authenticator.stub.AuthenticationAdminStub;
import org.apache.axis2.context.ServiceContext;


/**
 * Created by aruna on 6/10/15.
 */
public class AuthenticationAdmin {
    private static final String AS_URL = "https://localhost:9443/services/";

    public static String getCookie() {
        String endpoint = AS_URL + "AuthenticationAdmin";
        String cookie = null;
        try {
            AuthenticationAdminStub authAdminStub = new AuthenticationAdminStub(endpoint);
            boolean loginSuccess = authAdminStub.login("admin", "admin", "localhost");

            if (loginSuccess) {
                ServiceContext serviceContext = authAdminStub._getServiceClient().getLastOperationContext().getServiceContext();
                cookie = (String) serviceContext.getProperty(HTTPConstants.COOKIE_STRING);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return cookie;
    }
}
