package wse.bdovbysh.endpoins;

import org.apache.log4j.Logger;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import wse.bdovbysh.entity.CalcRequestType;
import wse.bdovbysh.entity.GetCalcRequest;
import wse.bdovbysh.entity.GetCalcResponse;
import wse.bdovbysh.entity.OperationsEnum;
import wse.bdovbysh.exceptions.BusinessException;

/**
 * Created by dovbysh on 15.10.2015.
 */
@Endpoint
public class CalculusEndpoint {

    private final static Logger log = Logger.getLogger(CalculusEndpoint.class);
    private final String TARGET_NAMESPACE =  "http://wse-bdovbysh.rhcloud.com/ws";

    @PayloadRoot(namespace = TARGET_NAMESPACE, localPart = "getCalcRequest")
    @ResponsePayload
    public GetCalcResponse handleCalculationRequest(@RequestPayload GetCalcRequest calcRequest) throws BusinessException{
        if (isValid(calcRequest)){
            CalcRequestType requestType = calcRequest.getRequest();
            Double first = requestType.getFirst();
            Double second = requestType.getSecond();
            Double result = null;
            OperationsEnum operationEnum = calcRequest.getRequest().getOperation();
            switch(operationEnum){
                case PLUS:
                    result = first + second;
                    break;
                case MINUS:
                    result = first - second;
                    break;
                case DIVIDE:
                    result = first / second;
                    break;
                case MULTIPLY:
                    result = first * second;
                    break;
                default:
                    break;
            }
            GetCalcResponse calcResponse = new GetCalcResponse();
            calcResponse.setResult(result);
            return calcResponse;
        }
        throw new BusinessException("42 in request");

    }

    private Boolean isValid(GetCalcRequest request){
        CalcRequestType requestType = request.getRequest();
        Double first = requestType.getFirst();
        Double second = requestType.getSecond();
        if ( first.equals(42d) || second.equals(42d)){
            return false;
        }
        return true;
    }

}
