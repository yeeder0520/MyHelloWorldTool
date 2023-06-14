package com;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @author YeeDer
 * @version 1.0.0
 * @since 2022/9/1 上午 11:43
 **/
public class TestJustin {

    final String FDX_TCK_V1_TRACKINGNUMBERS_URL = "https://apis.fedex.com/track/v1/trackingnumbers";
    final String FDX_TCK_V1_ASSOCIATEDSHIPMENTS_URL = "https://apis.fedex.com/track/v1/associatedshipments";


    public static void main2(String[] args) throws IOException {
        String filePath = "C:\\Users\\6620\\Downloads\\aaa.json";

        // 将 JSON 字符串转换为 net.sf.json.JSONObject
        JSONObject jsonObject = JSONObject.fromObject(new String(Files.readAllBytes(Paths.get(filePath))));
        // 获取 completeTrackResults 数组
        JSONArray completeTrackResults = jsonObject.getJSONObject("output").getJSONArray("completeTrackResults");
        // 遍历 completeTrackResults 数组
        Map<String, FdxApiResult> fdxApiResultMap = new HashMap<>();
        for (int i = 0; i < completeTrackResults.size(); i++) {
            JSONObject trackResult = completeTrackResults.getJSONObject(i);
            String trackingNumber = trackResult.getString("trackingNumber");

            //获取 trackResults 数组
            JSONArray trackResults = trackResult.getJSONArray("trackResults");

            for (int j = 0; j < trackResults.size(); j++) {

                JSONObject error = trackResults.getJSONObject(j).optJSONObject("error");
                if (error!=null){
                    String code = error.getString("code");
                    String message = error.getString("message");
                    System.out.println("code = " + code);
                    System.out.println("message = " + message);
                    continue;
                }


                // 获取 scanEvents 数组
                JSONArray scanEvents = trackResults.getJSONObject(j).getJSONArray("scanEvents");
                String receivedByName = trackResults.getJSONObject(j).getJSONObject("deliveryDetails").getString("receivedByName");

                // 遍历 scanEvents 数组
                for (int k = 0; k < scanEvents.size(); k++) {
                    JSONObject scanEvent = scanEvents.getJSONObject(k);
                    String date = scanEvent.getString("date");
                    System.out.println("date = " + date);
                    String eventType = scanEvent.getString("eventType");
                    String countryCode = scanEvent.optJSONObject("scanLocation").optString("countryCode");
                    String key = trackingNumber + "@" + countryCode + "@" + eventType;
                    if (fdxApiResultMap.containsKey(key)) {
                        // 因為越前面，日期越新，故後續重複出現的可以不處理
                        continue;
                    }

                    FdxApiResult fdxApiResult = new FdxApiResult();
                    fdxApiResult.setTrackingNumber(trackingNumber);
                    fdxApiResult.setDate(date);
                    fdxApiResult.setCountryCode(countryCode);
                    fdxApiResult.setEventType(eventType);
                    fdxApiResult.setReceivedByName(receivedByName);
                    fdxApiResultMap.put(key, fdxApiResult);
                }
            }
        }


        fdxApiResultMap.keySet().forEach(value -> System.out.println("value = " + value));
        fdxApiResultMap.values().forEach(value -> System.out.println("value = " + value));

//        List<String> collect = fdxApiResultMap.keySet().stream().filter(
//                key -> key.equals("153407572601@HK@OD")
//        ).collect(Collectors.toList());
//
//        System.out.println("collect = " + collect);

    }



    public static void main(String[] args) throws IOException, IOException {
        TestJustin testJustin = new TestJustin();

//        String filePath = "C:\\Users\\6620\\Downloads\\aaa.json";
//        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(filePath));
//        testJustin.jsonResponseHandler(new JsonFactory().createParser(bufferedReader));

//        filePath = "C:\\Users\\6620\\Downloads\\err.json";
//        bufferedReader = Files.newBufferedReader(Paths.get(filePath));
//        testJustin.jsonResponseHandler(new JsonFactory().createParser(bufferedReader));

        //取得 Token
        String accessToken = testJustin.getToken();
        testJustin.restTemplateTest_TRACKINGNUMBERS(accessToken);
        System.out.println("=======================================");
//        testJustin.restTemplateTest_ASSOCIATEDSHIPMENTS(accessToken);
//        System.out.println("=======================================");
//        testJustin.httpClientTest_TRACKINGNUMBERS(accessToken);
//        System.out.println("=======================================");
//        testJustin.httpClientTest_ASSOCIATEDSHIPMENTS(accessToken);

    }

    public void restTemplateTest_TRACKINGNUMBERS(String accessToken) throws IOException {
        RestTemplate restTemplate = new RestTemplate();

        /*宣告Header*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("includeDetailedScans", true);

        /*組合JSON字串*/
        Map<String, Object> trackingInfo = new HashMap<>();
        Map<String, Object> trackingNumberInfo = new HashMap<>();
//        trackingNumberInfo.put("trackingNumber", "701106608015"); // O
//        trackingNumberInfo.put("trackingNumber", "153407572601"); // O
        trackingNumberInfo.put("trackingNumber", "649217671968"); // O
//        trackingNumberInfo.put("trackingNumber", "771865661234"); // X

        List<Map<String, Object>> trackingInfoList = new ArrayList<>();
        trackingInfo.put("trackingNumberInfo", trackingNumberInfo);
        trackingInfoList.add(trackingInfo);

        // 设置请求体的其他字段
        requestBody.put("trackingInfo", trackingInfoList);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            // 将 Map 对象转换为 JSON 字符串
            json = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        /*請求*/
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        /*回應*/
        String body = restTemplate.postForEntity(FDX_TCK_V1_TRACKINGNUMBERS_URL, requestEntity, String.class).getBody();
        System.out.println("body = " + body);


    }


    public void restTemplateTest_ASSOCIATEDSHIPMENTS(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();

        /*宣告Header*/
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + accessToken);

        Map<String, Object> requestBody = new LinkedHashMap<>();
        /*組合JSON字串*/
        requestBody.put("includeDetailedScans", true);
        requestBody.put("associatedType", "STANDARD_MPS");
        Map<String, Object> masterTrackingNumberInfo = new LinkedHashMap<>();
        Map<String, Object> trackingNumberInfo = new LinkedHashMap<>();
        trackingNumberInfo.put("trackingNumber", "701106608015");
        masterTrackingNumberInfo.put("trackingNumberInfo", trackingNumberInfo);
        requestBody.put("masterTrackingNumberInfo", masterTrackingNumberInfo);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            // 将 Map 对象转换为 JSON 字符串
            json = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        /*請求*/
        System.out.println("json = " + json);
        HttpEntity<String> requestEntity = new HttpEntity<>(json, headers);

        /*回應*/
        String body = restTemplate.postForEntity(FDX_TCK_V1_ASSOCIATEDSHIPMENTS_URL, requestEntity, String.class).getBody();
        System.out.println("body = " + body);

    }

    public void httpClientTest_TRACKINGNUMBERS(String accessToken) {
        String url = FDX_TCK_V1_TRACKINGNUMBERS_URL; // 替换为目标 URL
//        String requestBody = "{    \"includeDetailedScans\": true,    \"associatedType\": \"STANDARD_MPS\",    \"masterTrackingNumberInfo\": {        \"trackingNumberInfo\": {            \"trackingNumber\": \"701106608015\"        }    }}";

        Map<String, Object> requestBody = new LinkedHashMap<>();
        /*組合JSON字串*/
        List<Map<String, Object>> trackingInfoList = new ArrayList<>();
        Map<String, Object> trackingNumberInfo = new HashMap<>();
        trackingNumberInfo.put("trackingNumber", "1111111");
        Map<String, Object> trackingInfo = new HashMap<>();
        trackingInfo.put("trackingNumberInfo", trackingNumberInfo);
        trackingInfoList.add(trackingInfo);

        // 设置请求体的其他字段
        requestBody.put("trackingInfo", trackingInfoList);
        requestBody.put("includeDetailedScans", false);


        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            // 将 Map 对象转换为 JSON 字符串
            json = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 创建 HttpClient 对象
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建 POST 请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求头
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + accessToken);

            // 设置请求体
            StringEntity requestEntity = new StringEntity(json);
            httpPost.setEntity(requestEntity);

            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(httpPost);

            // 获取响应实体
            org.apache.http.HttpEntity responseEntity = response.getEntity();
            System.out.println("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
            // 解析响应
            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println("Response: " + responseString);
            }

            // 关闭响应实体
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void httpClientTest_ASSOCIATEDSHIPMENTS(String accessToken) {
        String url = FDX_TCK_V1_ASSOCIATEDSHIPMENTS_URL; // 替换为目标 URL

        Map<String, Object> requestBody = new LinkedHashMap<>();
        /*組合JSON字串*/
        requestBody.put("includeDetailedScans", true);
        requestBody.put("associatedType", "STANDARD_MPS");
        Map<String, Object> masterTrackingNumberInfo = new LinkedHashMap<>();
        Map<String, Object> trackingNumberInfo = new LinkedHashMap<>();
        trackingNumberInfo.put("trackingNumber", "a");
        masterTrackingNumberInfo.put("trackingNumberInfo", trackingNumberInfo);
        requestBody.put("masterTrackingNumberInfo", masterTrackingNumberInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "";
        try {
            // 将 Map 对象转换为 JSON 字符串
            json = objectMapper.writeValueAsString(requestBody);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        // 创建 HttpClient 对象
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            // 创建 POST 请求
            HttpPost httpPost = new HttpPost(url);

            // 设置请求头
            httpPost.setHeader("Content-Type", "application/json");
            httpPost.setHeader("Authorization", "Bearer " + accessToken);

            // 设置请求体
            StringEntity requestEntity = new StringEntity(json);
            httpPost.setEntity(requestEntity);

            // 发送请求并获取响应
            HttpResponse response = httpClient.execute(httpPost);

            // 获取响应实体
            org.apache.http.HttpEntity responseEntity = response.getEntity();
            System.out.println("response.getStatusLine().getStatusCode() = " + response.getStatusLine().getStatusCode());
            // 解析响应
            if (responseEntity != null) {
                String responseString = EntityUtils.toString(responseEntity);
                System.out.println("Response: " + responseString);
            }

            // 关闭响应实体
            EntityUtils.consume(responseEntity);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getToken() {
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap<String, String> formData = new LinkedMultiValueMap<>();
        formData.add("grant_type", "client_credentials");
        formData.add("client_id", "l7f75f52434b37458ab673cded1d140707");
        formData.add("client_secret", "223a0cd2830e48acb5880c5872c0a550");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(formData, headers);
        String url = "https://apis.fedex.com/oauth/token";
        ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);

        String accessToken = "";
        // 處理 API 回應
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody());
            accessToken = jsonNode.get("access_token").asText();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return accessToken;
    }

    public void jsonResponseHandler(JsonParser parser) throws IOException {
        Map<String, FdxApiResult> fdxApiResultMap = new HashMap<>();
        while (!parser.isClosed()) {
            if (JsonToken.FIELD_NAME.equals(parser.nextToken())) {
                FdxApiResult fdxApiResult = new FdxApiResult();
                String fieldName = parser.getCurrentName();
                // 取得TrackingNumber
                if ("trackingNumber".equals(fieldName)) {
                    parseTrackingNumberField(parser, fdxApiResult);
                }
                // 進入 error 物件
                if ("error".equals(fieldName)) {
                    parseErrorField(parser);
                }
                // 進入 scanEvents 物件
                if ("scanEvents".equals(fieldName)) {   //=>多筆
                    parseScanEventsField(parser);
                }
                // 進入 receivedByName 物件
                if ("receivedByName".equals(fieldName)) {
                    parseReceivedByNameField(parser);
                }
                //=>組 MAP
            }
        }

    }

    @Data
    static class FdxApiResult {
        String trackingNumber;
        String eventType;
        String countryCode;
        String date;
        String receivedByName;
    }


    /**
     * 處理日期
     *
     * @param inputData 輸入資料
     * @return 取得日期 yyyyMMdd
     */
    public static String paresDate(String inputData) {
        // 解析為OffsetDateTime物件
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(inputData);
        //取得日期
        LocalDate date = offsetDateTime.toLocalDate();
        return date.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
    }

    /**
     * 處理時間
     *
     * @param inputData 輸入資料
     * @return 取得時間 HHmm
     */
    public static String paresTime(String inputData) {
        // 解析為OffsetDateTime物件
        OffsetDateTime offsetDateTime = OffsetDateTime.parse(inputData);
        // 取得時間
        LocalTime time = offsetDateTime.toLocalTime();
        return time.format(DateTimeFormatter.ofPattern("HHmmss"));
    }

    /**
     * 處理Json字串中的TrackingNumber
     *
     * @param parser       JSON資料
     * @param fdxApiResult
     * @throws IOException IOException
     */
    public void parseTrackingNumberField(JsonParser parser, FdxApiResult fdxApiResult) throws IOException {
        parser.nextToken();
        String trackingNumber = parser.getText();
        System.out.println("trackingNumber = " + trackingNumber);
        fdxApiResult.setTrackingNumber(trackingNumber);
    }

    /**
     * 處理Json字串中的Error物件
     *
     * @param parser JSON資料
     * @throws IOException IOException
     */
    public void parseErrorField(JsonParser parser) throws IOException {
        // 進入 error 对象
        while (!JsonToken.END_OBJECT.equals(parser.nextToken())) {
            String errorFieldName = parser.getCurrentName();
            if ("code".equals(errorFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String errorCode = parser.getText();
                System.out.println("errorCode = " + errorCode);
            } else if ("message".equals(errorFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String errorMessage = parser.getText();
                System.out.println("errorMessage = " + errorMessage);
            }
        }
    }

    /**
     * 處理Json字串中的ScanEvents物件
     *
     * @param parser JSON資料
     * @throws IOException IOException
     */
    public void parseScanEventsField(JsonParser parser) throws IOException {
        if (JsonToken.START_ARRAY.equals(parser.nextToken())) {
            while (!JsonToken.END_ARRAY.equals(parser.nextToken())) {
                String scanEventFieldName = parser.getCurrentName();
                if ("eventType".equals(scanEventFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String eventType = parser.getText();
                    System.out.println("eventType: " + eventType);
                } else if ("scanLocation".equals(scanEventFieldName) && parser.getCurrentToken() == JsonToken.FIELD_NAME) {
                    parseScanEventsField_ScanLocation_CountryCode(parser);
                } else if ("date".equals(scanEventFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                    String date = paresDate(parser.getText());
                    String time = paresTime(parser.getText());
                    System.out.println("date = " + date);
                    System.out.println("time = " + time);
                }
            }
        }
    }

    /**
     * 處理Json字串中的ScanEventsField物件底下的ScanLocation物件底下的CountryCode
     *
     * @param parser JSON資料
     * @throws IOException IOException
     */
    private void parseScanEventsField_ScanLocation_CountryCode(JsonParser parser) throws IOException {
        while (!JsonToken.END_OBJECT.equals(parser.nextToken())) {
            String scanLocationFieldName = parser.getCurrentName();
            if ("countryCode".equals(scanLocationFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
                String countryCode = parser.getText();
                System.out.println("countryCode = " + countryCode);
            }
        }
    }

    /**
     * 處理Json字串中的ReceivedByNameField物件
     *
     * @param parser JSON資料
     * @throws IOException IOException
     */
    public void parseReceivedByNameField(JsonParser parser) throws IOException {
        parser.nextToken();
        String receivedByNameFieldName = parser.getCurrentName();
        if ("receivedByName".equals(receivedByNameFieldName) && parser.getCurrentToken() == JsonToken.VALUE_STRING) {
            String receivedByName = parser.getText();
            System.out.println("receivedByName = " + receivedByName);
        }
    }
}





