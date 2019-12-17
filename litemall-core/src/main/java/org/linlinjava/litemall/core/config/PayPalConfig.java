package org.linlinjava.litemall.core.config;

import com.paypal.core.PayPalEnvironment;
import com.paypal.core.PayPalHttpClient;
import com.paypal.orders.ApplicationContext;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Iterator;

@Configuration
public class PayPalConfig {

    @Autowired
    private PayPalProperties properties;

    /**
     * Method to get client object
     *
     * @return PayPalHttpClient client
     */
    @Bean
    public PayPalHttpClient client() {
        PayPalEnvironment environment = properties.getEnv().equals("live") ? new PayPalEnvironment.Live(properties.getClientId(),
                properties.getSecret()) : new PayPalEnvironment.Sandbox(properties.getClientId(), properties.getSecret());
        PayPalHttpClient client = new PayPalHttpClient(environment);
        return client;
    }


    /**
     *  Method to get ApplicationContext object
     * @return
     */
    @Bean
    public ApplicationContext context() {
        return new ApplicationContext().brandName("myanimec").landingPage("BILLING")
                .cancelUrl(properties.getCancelUrl()).returnUrl(properties.getSuccessUrl()).userAction("PAY_NOW")
                .shippingPreference("SET_PROVIDED_ADDRESS");
    }

    /**
     * Method to pretty print a response
     *
     * @param jo  JSONObject
     * @param pre prefix (default="")
     * @return String pretty printed JSON
     */
    public String prettyPrint(JSONObject jo, String pre) {
        Iterator<?> keys = jo.keys();
        StringBuilder pretty = new StringBuilder();
        while (keys.hasNext()) {
            String key = (String) keys.next();
            pretty.append(String.format("%s%s: ", pre, StringUtils.capitalize(key)));
            if (jo.get(key) instanceof JSONObject) {
                pretty.append(prettyPrint(jo.getJSONObject(key), pre + "\t"));
            } else if (jo.get(key) instanceof JSONArray) {
                int sno = 1;
                for (Object jsonObject : jo.getJSONArray(key)) {
                    pretty.append(String.format("\n%s\t%d:\n", pre, sno++));
                    pretty.append(prettyPrint((JSONObject) jsonObject, pre + "\t\t"));
                }
            } else {
                pretty.append(String.format("%s\n", jo.getString(key)));
            }
        }
        return pretty.toString();
    }
}
