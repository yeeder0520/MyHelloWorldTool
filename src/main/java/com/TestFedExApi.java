package com;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Supplier;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class TestFedExApi {

    final String FDX_TCK_V1_TRACKINGNUMBERS_URL = "https://apis.fedex.com/track/v1/trackingnumbers";
    final String FDX_TCK_V1_ASSOCIATEDSHIPMENTS_URL = "https://apis.fedex.com/track/v1/associatedshipments";


    public static void main(String[] args) throws Exception {
        TestFedExApi testJustin = new TestFedExApi();
        testJustin.transform();

    }

    public void transform() throws Exception {

        System.out.println("Begin call FDX API");

        String responseJson = formPostToFdxTckTokenUrl();
        String accessToken = getAccessToken(responseJson);
        String responseBody = "";
        Map<String, FedexApiResponseBean> fedexApiResponseBeanMap;
        String hawbNo = "650266208978";
        if (isSingleTrackingInfo(2)) {// [650266208978 , evDhJpz5uLHChmyVj4CrpQ==]
            //使用REST ful API-getTrackingInfo-Single
            responseBody = getTrackingInfoSingleByFedexAPI(accessToken, hawbNo);
        } else {
            //使用REST ful API-getTrackingInfo-Multiple
            responseBody = getTrackingInfoMultipleByFedexAPI(accessToken, hawbNo);
        }

        fedexApiResponseBeanMap = parseFedexApiResponseBody(responseBody);

        int responseJsonSize = fedexApiResponseBeanMap.size();

        if (responseJsonSize == 0) {
            if (isSingleTrackingInfo(2)) {// [650266208978 , evDhJpz5uLHChmyVj4CrpQ==]
                //使用REST ful API-getTrackingInfo-Multiple
                responseBody = getTrackingInfoMultipleByFedexAPI(accessToken, hawbNo);
            } else {
                //使用REST ful API-getTrackingInfo-Single
                responseBody = getTrackingInfoSingleByFedexAPI(accessToken, hawbNo);
            }
            fedexApiResponseBeanMap = parseFedexApiResponseBody(responseBody);
            responseJsonSize = fedexApiResponseBeanMap.size();
        }

        System.out.println("Finish call FDX API, size = " + responseJsonSize);

        fedexApiResponseBeanMap.values().forEach(fedexApiResponseBean -> {
            System.out.println("getDate() = " + fedexApiResponseBean.getDate());
            System.out.println("getEventType() = " + fedexApiResponseBean.getEventType());
            System.out.println("getCountryCode() = " + fedexApiResponseBean.getCountryCode());
            System.out.println("getReceivedByName() = " + fedexApiResponseBean.getReceivedByName());
            System.out.println("================================================================================================================================");
        });

        if (responseJsonSize > 0) {
            System.out.println("我大於0");
        }

    }

    /**
     * 呼叫取得TOKEN的URL
     *
     * @return 回應的JSON字串
     */
    private String formPostToFdxTckTokenUrl() {
        final String FDX_TCK_TOKEN_URL = "https://apis.fedex.com/oauth/token";
        RestTemplate restTemplate = new RestTemplate();
        /*組合form post*/
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", "l7f75f52434b37458ab673cded1d140707");
        formData.add("client_secret", "223a0cd2830e48acb5880c5872c0a550");

        /*宣告Header*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        /*請求*/
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);

        /*回應*/
        return restTemplate.postForEntity(FDX_TCK_TOKEN_URL, requestEntity, String.class).getBody();
    }

    /**
     * 處理回應字串，取得AccessToken
     *
     * @param responseJson responseJson
     * @return AccessToken
     * @throws IOException IOException
     */
    private String getAccessToken(String responseJson) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(responseJson);
        return jsonNode.get("access_token").asText();
    }

    /**
     * 使用REST API-getTrackingInfo-Single
     *
     * @param accessToken accessToken
     * @param hawbNo      hawbNo
     * @return 取得單件數的分提單號貨況資料
     * @throws JsonProcessingException JsonProcessingException
     */
    private String getTrackingInfoSingleByFedexAPI(String accessToken, String hawbNo) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        /*宣告Header*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        /*組合請求Body*/
        Map<String, Object> requestBody = new LinkedHashMap<>();
        List<Map<String, Object>> trackingInfoList = new ArrayList<>();
        Map<String, Object> trackingNumberInfo = new HashMap<>();
        trackingNumberInfo.put("trackingNumber", hawbNo);
        Map<String, Object> trackingInfo = new HashMap<>();
        trackingInfo.put("trackingNumberInfo", trackingNumberInfo);
        trackingInfoList.add(trackingInfo);
        requestBody.put("trackingInfo", trackingInfoList);
        requestBody.put("includeDetailedScans", true);

        /*將 body 轉 json字串*/
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        json = objectMapper.writeValueAsString(requestBody);

        /*請求*/
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        /*回應*/
        return restTemplate.postForEntity(FDX_TCK_V1_TRACKINGNUMBERS_URL, requestEntity, String.class).getBody();
    }

    /**
     * 使用REST API-getTrackingInfo-Multiple
     *
     * @param accessToken accessToken
     * @param hawbNo      hawbNo
     * @return 取得多件數的分提單號貨況資料
     * @throws JsonProcessingException JsonProcessingException
     */
    private String getTrackingInfoMultipleByFedexAPI(String accessToken, String hawbNo) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();

        /*宣告Header*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        /*組合請求Body*/
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("includeDetailedScans", true);
        requestBody.put("associatedType", "STANDARD_MPS");
        Map<String, Object> masterTrackingNumberInfo = new LinkedHashMap<>();
        Map<String, Object> trackingNumberInfo = new LinkedHashMap<>();
        trackingNumberInfo.put("trackingNumber", hawbNo);
        masterTrackingNumberInfo.put("trackingNumberInfo", trackingNumberInfo);
        requestBody.put("masterTrackingNumberInfo", masterTrackingNumberInfo);

        /*將 body 轉 json字串*/
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        json = objectMapper.writeValueAsString(requestBody);

        /*請求*/
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        /*回應*/
        return restTemplate.postForEntity(FDX_TCK_V1_ASSOCIATEDSHIPMENTS_URL, requestEntity, String.class).getBody();
    }

    @Data
    static class FedexApiResponseBean {
        String trackingNumber;
        String eventType;
        String countryCode;
        String date;
        String receivedByName;
    }

    /**
     * 決定使用 Single 或 Multiple
     *
     * @param totPackageNumber totPackageNumber
     * @return boolean
     */
    public boolean isSingleTrackingInfo(Integer totPackageNumber) {
        return totPackageNumber == 1;
    }

    /**
     * 處理FedexApi回應的Json(貨況)
     *
     * @param responseJsonString JSON資料
     * @throws IOException IOException
     */
    public Map<String, FedexApiResponseBean> parseFedexApiResponseBody(String responseJsonString) throws Exception {
        JSONObject jsonObject = JSONObject.fromObject(responseJsonString);
        Map<String, FedexApiResponseBean> returnFdxApiResultMap = new HashMap<>();
        // 取得 completeTrackResults
        JSONArray completeTrackResults = jsonObject.getJSONObject("output").getJSONArray("completeTrackResults");
        for (int i = 0; i < completeTrackResults.size(); i++) { // 迴圈 completeTrackResults
            String trackingNumber = completeTrackResults.getJSONObject(i).optString("trackingNumber"); //取得 trackingNumber
            JSONArray trackResults = completeTrackResults.getJSONObject(i).getJSONArray("trackResults"); //取得 trackResults
            for (int j = 0; j < trackResults.size(); j++) { // 迴圈 trackResults

                JSONObject error = trackResults.getJSONObject(j).optJSONObject("error");//處理error
                if (error != null) {
                    String code = error.getString("code");
                    String message = error.getString("message");
                    System.out.println("TrackingNumber [" + trackingNumber + "] , found error! errorCode:[" + code + "] , errorMessage:[" + message + "]");
                    continue;
                }

                JSONArray scanEvents = trackResults.getJSONObject(j).getJSONArray("scanEvents");
                String receivedByName = trackResults.getJSONObject(j).getJSONObject("deliveryDetails").optString("receivedByName");
                for (int k = 0; k < scanEvents.size(); k++) { // 迴圈 scanEvents
                    JSONObject scanEvent = scanEvents.getJSONObject(k);
                    String date = scanEvent.optString("date");
                    String eventType = scanEvent.optString("eventType");
                    String countryCode = scanEvent.optJSONObject("scanLocation").optString("countryCode");
                    String key = trackingNumber + "@" + eventType + "@" + countryCode;
                    if (returnFdxApiResultMap.containsKey(key)) {
                        // 因為越前面，日期越新，故後續重複出現的可以不處理
                        continue;
                    }
                    FedexApiResponseBean fdxApiResult = new FedexApiResponseBean();
                    fdxApiResult.setTrackingNumber(trackingNumber);
                    fdxApiResult.setDate(date);
                    fdxApiResult.setCountryCode(countryCode);
                    fdxApiResult.setEventType(eventType);
                    fdxApiResult.setReceivedByName(receivedByName);
                    returnFdxApiResultMap.put(key, fdxApiResult);
                }
            }
        }
        return returnFdxApiResultMap;
    }

}





