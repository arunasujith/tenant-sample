package org.wso2.carbon.tenant.mgt.sample;

import org.apache.axis2.client.Options;
import org.wso2.carbon.tenant.mgt.stub.TenantMgtAdminServiceStub;
import org.wso2.carbon.tenant.mgt.stub.beans.xsd.TenantInfoBean;

/**
 * Created by aruna on 6/10/15.
 */
public class TenantMgtAdmin {
    private static final String AS_URL = "https://localhost:9443/services/";

    public static void addTenant(String cookie) throws Exception {

        TenantMgtAdminServiceStub tenantMgtStub = null;
        String tenantMgtEndpoint = AS_URL + "TenantMgtAdminService";

        tenantMgtStub = new TenantMgtAdminServiceStub(tenantMgtEndpoint);
        Options option = tenantMgtStub._getServiceClient().getOptions();
        option.setManageSession(true);
        option.setProperty(org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING, cookie);

        String value = tenantMgtStub.addTenant(getTenantBean());

        System.out.println("Value ::" + value);
    }

    private static TenantInfoBean getTenantBean() {

        TenantInfoBean bean = new TenantInfoBean();
        bean.setActive(true);
        bean.setAdmin("sample");
        bean.setAdminPassword("sample");
        bean.setEmail("sample@sample.com");
        bean.setFirstname("FirstName");
        bean.setLastname("LastName");
        bean.setTenantDomain("sample.com");
        return bean;
    }
}
