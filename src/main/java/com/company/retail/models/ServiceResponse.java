package com.company.retail.models;

import javax.validation.constraints.NotNull;
import javax.websocket.server.ServerEndpoint;

/**
 * Created by saurav on 1/9/16.
 */
public class ServiceResponse {

    private Boolean successful;

    public ServiceResponse(Boolean successful){
        this.successful = successful;
    }

    public Boolean getSuccessful() {
        return successful;
    }

    public void setSuccessful(Boolean successful) {
        this.successful = successful;
    }

}
