/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.monitor.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.management.monitor.ErrorResponseException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in MetricDefinitions.
 */
public class MetricDefinitionsInner {
    /** The Retrofit service to perform REST calls. */
    private MetricDefinitionsService service;
    /** The service client containing this operation class. */
    private MonitorManagementClientImpl client;

    /**
     * Initializes an instance of MetricDefinitionsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public MetricDefinitionsInner(Retrofit retrofit, MonitorManagementClientImpl client) {
        this.service = retrofit.create(MetricDefinitionsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for MetricDefinitions to be
     * used by Retrofit to perform actually REST calls.
     */
    interface MetricDefinitionsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.MetricDefinitions list" })
        @GET("{resourceUri}/providers/microsoft.insights/metricDefinitions")
        Observable<Response<ResponseBody>> list(@Path(value = "resourceUri", encoded = true) String resourceUri, @Query("api-version") String apiVersion, @Query("metricnamespace") String metricnamespace, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;MetricDefinitionInner&gt; object if successful.
     */
    public List<MetricDefinitionInner> list(String resourceUri) {
        return listWithServiceResponseAsync(resourceUri).toBlocking().single().body();
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<MetricDefinitionInner>> listAsync(String resourceUri, final ServiceCallback<List<MetricDefinitionInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceUri), serviceCallback);
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricDefinitionInner&gt; object
     */
    public Observable<List<MetricDefinitionInner>> listAsync(String resourceUri) {
        return listWithServiceResponseAsync(resourceUri).map(new Func1<ServiceResponse<List<MetricDefinitionInner>>, List<MetricDefinitionInner>>() {
            @Override
            public List<MetricDefinitionInner> call(ServiceResponse<List<MetricDefinitionInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricDefinitionInner&gt; object
     */
    public Observable<ServiceResponse<List<MetricDefinitionInner>>> listWithServiceResponseAsync(String resourceUri) {
        if (resourceUri == null) {
            throw new IllegalArgumentException("Parameter resourceUri is required and cannot be null.");
        }
        final String apiVersion = "2018-01-01";
        final String metricnamespace = null;
        return service.list(resourceUri, apiVersion, metricnamespace, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<MetricDefinitionInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<MetricDefinitionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<MetricDefinitionInner>> result = listDelegate(response);
                        ServiceResponse<List<MetricDefinitionInner>> clientResponse = new ServiceResponse<List<MetricDefinitionInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @param metricnamespace Metric namespace to query metric definitions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the List&lt;MetricDefinitionInner&gt; object if successful.
     */
    public List<MetricDefinitionInner> list(String resourceUri, String metricnamespace) {
        return listWithServiceResponseAsync(resourceUri, metricnamespace).toBlocking().single().body();
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @param metricnamespace Metric namespace to query metric definitions for.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<MetricDefinitionInner>> listAsync(String resourceUri, String metricnamespace, final ServiceCallback<List<MetricDefinitionInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceUri, metricnamespace), serviceCallback);
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @param metricnamespace Metric namespace to query metric definitions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricDefinitionInner&gt; object
     */
    public Observable<List<MetricDefinitionInner>> listAsync(String resourceUri, String metricnamespace) {
        return listWithServiceResponseAsync(resourceUri, metricnamespace).map(new Func1<ServiceResponse<List<MetricDefinitionInner>>, List<MetricDefinitionInner>>() {
            @Override
            public List<MetricDefinitionInner> call(ServiceResponse<List<MetricDefinitionInner>> response) {
                return response.body();
            }
        });
    }

    /**
     * Lists the metric definitions for the resource.
     *
     * @param resourceUri The identifier of the resource.
     * @param metricnamespace Metric namespace to query metric definitions for.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the List&lt;MetricDefinitionInner&gt; object
     */
    public Observable<ServiceResponse<List<MetricDefinitionInner>>> listWithServiceResponseAsync(String resourceUri, String metricnamespace) {
        if (resourceUri == null) {
            throw new IllegalArgumentException("Parameter resourceUri is required and cannot be null.");
        }
        final String apiVersion = "2018-01-01";
        return service.list(resourceUri, apiVersion, metricnamespace, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<MetricDefinitionInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<MetricDefinitionInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<MetricDefinitionInner>> result = listDelegate(response);
                        ServiceResponse<List<MetricDefinitionInner>> clientResponse = new ServiceResponse<List<MetricDefinitionInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl1<MetricDefinitionInner>> listDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl1<MetricDefinitionInner>, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl1<MetricDefinitionInner>>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

}
