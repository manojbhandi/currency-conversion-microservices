# Springboot Microservices Project
# Service Registry :- Eureka Naming Server
![image](https://user-images.githubusercontent.com/97438009/191925044-3ca71022-1344-4c61-b95d-40bae3c756a6.png)

# Currency-Conversion-microservice

*USD to INR
============
![image](https://user-images.githubusercontent.com/97438009/191922263-e66ccc5d-d08a-435a-91fb-dafd1d5ee5d4.png)
`
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
@RestController
public class CurrencyConversionController {
    @Autowired
    private CurrencyExchangeProxy proxy;
    @GetMapping("currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retreiveConvertedValue(@PathVariable String from,
                                                     @PathVariable String to,
                                                     @PathVariable BigDecimal quantity){

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("from", from);
        uriVariables.put("to", to);

        ResponseEntity<CurrencyConversion> responseEntity = new RestTemplate()
                .getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
                CurrencyConversion.class, uriVariables );

        CurrencyConversion currencyConversion = responseEntity.getBody();

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()),
                currencyConversion.getEnvironment() +" "+ "  REST template");
    }

    @GetMapping("currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retreiveConvertedValueFeign(@PathVariable String from,
                                                     @PathVariable String to,
                                                    @PathVariable BigDecimal quantity){

        CurrencyConversion currencyConversion = proxy.retrieveExchangeValue(from, to);

        return new CurrencyConversion(currencyConversion.getId(), from, to, quantity,
                currencyConversion.getConversionMultiple(),
                quantity.multiply(currencyConversion.getConversionMultiple()), currencyConversion.getEnvironment() + "  feign");
    }
}
`
*AUD to INR
===========
![image](https://user-images.githubusercontent.com/97438009/191924160-4a1ad8cc-bb05-41ac-bee2-7070e0fbc2cb.png)


# Currency-Exchange-microservice

#Cloud-Config-Server

![image](https://user-images.githubusercontent.com/97438009/191923861-31f71dfa-b794-40bb-8599-7eddea828916.png)



![image](https://user-images.githubusercontent.com/97438009/191920014-58608240-c8bd-440d-9ed2-ff6524597559.png)
