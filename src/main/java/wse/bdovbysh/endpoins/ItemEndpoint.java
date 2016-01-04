package wse.bdovbysh.endpoins;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import wse.bdovbysh.entity.GetItemSumRequest;
import wse.bdovbysh.entity.GetItemSumResponse;

import java.math.BigDecimal;

/**
 * Created by dovbysh on 22.10.2015.
 */
@Endpoint
public class ItemEndpoint {

    @PayloadRoot(localPart = "getItemSumRequest", namespace = "http://wse-bdovbysh.rhcloud.com/ws")
    @ResponsePayload
    public GetItemSumResponse handleSum(@RequestPayload GetItemSumRequest itemRequest){
        BigDecimal result = BigDecimal.ZERO;

        for (BigDecimal item : itemRequest.getItems().getItem()){
               result = result.add(item);
        }

        GetItemSumResponse response = new GetItemSumResponse();
        response.setResult(result);
        return response;
    }
}
