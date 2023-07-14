# KafkaControllerApi

All URIs are relative to *http://localhost:24201*

Method | HTTP request | Description
------------- | ------------- | -------------
[**sendMemberUsingPOST**](KafkaControllerApi.md#sendMemberUsingPOST) | **POST** /api/v1/kafka/member | 메세지 전송
[**sendMessageUsingPOST**](KafkaControllerApi.md#sendMessageUsingPOST) | **POST** /api/v1/kafka/message | 메세지 전송


<a name="sendMemberUsingPOST"></a>
# **sendMemberUsingPOST**
> Boolean sendMemberUsingPOST(requestMemberDTO)

메세지 전송

프로듀서 메세지 전송

### Example
```java
// Import classes:
import com.sample.cmc.client.invoker.ApiClient;
import com.sample.cmc.client.invoker.ApiException;
import com.sample.cmc.client.invoker.Configuration;
import com.sample.cmc.client.invoker.models.*;
import com.sample.cmc.client.api.KafkaControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:24201");

    KafkaControllerApi apiInstance = new KafkaControllerApi(defaultClient);
    RequestMemberDTO requestMemberDTO = new RequestMemberDTO(); // RequestMemberDTO | 
    try {
      Boolean result = apiInstance.sendMemberUsingPOST(requestMemberDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KafkaControllerApi#sendMemberUsingPOST");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestMemberDTO** | [**RequestMemberDTO**](RequestMemberDTO.md)|  | [optional]

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

<a name="sendMessageUsingPOST"></a>
# **sendMessageUsingPOST**
> Boolean sendMessageUsingPOST(requestMessageDTO)

메세지 전송

프로듀서 메세지 전송

### Example
```java
// Import classes:
import com.sample.cmc.client.invoker.ApiClient;
import com.sample.cmc.client.invoker.ApiException;
import com.sample.cmc.client.invoker.Configuration;
import com.sample.cmc.client.invoker.models.*;
import com.sample.cmc.client.api.KafkaControllerApi;

public class Example {
  public static void main(String[] args) {
    ApiClient defaultClient = Configuration.getDefaultApiClient();
    defaultClient.setBasePath("http://localhost:24201");

    KafkaControllerApi apiInstance = new KafkaControllerApi(defaultClient);
    RequestMessageDTO requestMessageDTO = new RequestMessageDTO(); // RequestMessageDTO | 
    try {
      Boolean result = apiInstance.sendMessageUsingPOST(requestMessageDTO);
      System.out.println(result);
    } catch (ApiException e) {
      System.err.println("Exception when calling KafkaControllerApi#sendMessageUsingPOST");
      System.err.println("Status code: " + e.getCode());
      System.err.println("Reason: " + e.getResponseBody());
      System.err.println("Response headers: " + e.getResponseHeaders());
      e.printStackTrace();
    }
  }
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestMessageDTO** | [**RequestMessageDTO**](RequestMessageDTO.md)|  | [optional]

### Return type

**Boolean**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
**200** | OK |  -  |
**201** | Created |  -  |
**401** | Unauthorized |  -  |
**403** | Forbidden |  -  |
**404** | Not Found |  -  |

