package com.ws;

import com.config.Environment;
import com.entity.interfaces.intake.provider.Providers;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.apache.log4j.Logger;

import java.io.IOException;

import static com.ws.WebServicesConstants.IMPORT_PROVIDER;

public class ProviderServices extends WebServicesBase {
    private static final Logger LOGGER = Logger.getLogger(ProviderServices.class);

    public ProviderServices() {
    }

    public Response sendImportProviderRequest(Environment environment, String modifyJson, String accountId){
        LOGGER.info(modifyJson);
        LOGGER.info(environment.getDwh() + IMPORT_PROVIDER);
        return sendPOSTWithAccountInHeader(environment.getDwh() + IMPORT_PROVIDER,
                modifyJson, environment.getMolina_UserName(), environment.getMolina_Password(), accountId);
    }

    public Providers[] createProvider(String jsonFileName, Environment environment,
                                      String qualifier, String providerId, String providerName,
                                      String payerId, String accountId) throws IOException {
        Gson gson = new Gson();
        Providers[] providers = toJsonModel(jsonFileName, Providers[].class);
        Providers providers1 = providers[0];
        providers1.setProviderQualifier(qualifier);
        providers1.setProviderID(providerId);
        providers1.setProviderName(providerName);
        providers1.setPayerID(payerId);

        sendImportProviderRequest(environment, gson.toJson(providers), accountId);

        return providers;
    }
}
