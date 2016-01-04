package wse.bdovbysh.endpoins;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import wse.bdovbysh.RepositoryStub;
import wse.bdovbysh.entity.GetCountryRequest;
import wse.bdovbysh.entity.GetCountryResponse;

/**
 * Created by dovbysh on 12.10.2015.
 */
@Endpoint
public class CountryEndpoint {

    private final String TARGET_NAMESPACE =  "http://wse-bdovbysh.rhcloud.com/wss";
    private final static Logger log = Logger.getLogger(CountryEndpoint.class);
    private RepositoryStub repositoryStub;

    @Autowired
    public CountryEndpoint(RepositoryStub respositoryStub){
        this.repositoryStub = respositoryStub;
    }

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse handleCountryRequest(@RequestPayload GetCountryRequest request){
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(repositoryStub.getCountryByName(request.getCountyName()));
        return response;
    }

}
