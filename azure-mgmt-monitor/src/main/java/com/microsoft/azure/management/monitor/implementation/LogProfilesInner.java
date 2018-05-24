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
import com.microsoft.azure.CloudException;
import com.microsoft.azure.management.monitor.ErrorResponseException;
import com.microsoft.azure.Page;
import com.microsoft.azure.PagedList;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import com.microsoft.rest.Validator;
import java.io.IOException;
import java.util.List;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.HTTP;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in LogProfiles.
 */
public class LogProfilesInner {
    /** The Retrofit service to perform REST calls. */
    private LogProfilesService service;
    /** The service client containing this operation class. */
    private MonitorManagementClientImpl client;

    /**
     * Initializes an instance of LogProfilesInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public LogProfilesInner(Retrofit retrofit, MonitorManagementClientImpl client) {
        this.service = retrofit.create(LogProfilesService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for LogProfiles to be
     * used by Retrofit to perform actually REST calls.
     */
    interface LogProfilesService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.LogProfiles delete" })
        @HTTP(path = "subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}", method = "DELETE", hasBody = true)
        Observable<Response<ResponseBody>> delete(@Path("logProfileName") String logProfileName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.LogProfiles get" })
        @GET("subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        Observable<Response<ResponseBody>> get(@Path("logProfileName") String logProfileName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.LogProfiles createOrUpdate" })
        @PUT("subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        Observable<Response<ResponseBody>> createOrUpdate(@Path("logProfileName") String logProfileName, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Body LogProfileResourceInner parameters, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.LogProfiles update" })
        @PATCH("subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles/{logProfileName}")
        Observable<Response<ResponseBody>> update(@Path("subscriptionId") String subscriptionId, @Path("logProfileName") String logProfileName, @Query("api-version") String apiVersion, @Body LogProfileResourcePatchInner logProfilesResource, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.monitor.LogProfiles list" })
        @GET("subscriptions/{subscriptionId}/providers/microsoft.insights/logprofiles")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     */
    public void delete(String logProfileName) {
        deleteWithServiceResponseAsync(logProfileName).toBlocking().single().body();
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<Void> deleteAsync(String logProfileName, final ServiceCallback<Void> serviceCallback) {
        return ServiceFuture.fromResponse(deleteWithServiceResponseAsync(logProfileName), serviceCallback);
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<Void> deleteAsync(String logProfileName) {
        return deleteWithServiceResponseAsync(logProfileName).map(new Func1<ServiceResponse<Void>, Void>() {
            @Override
            public Void call(ServiceResponse<Void> response) {
                return response.body();
            }
        });
    }

    /**
     * Deletes the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceResponse} object if successful.
     */
    public Observable<ServiceResponse<Void>> deleteWithServiceResponseAsync(String logProfileName) {
        if (logProfileName == null) {
            throw new IllegalArgumentException("Parameter logProfileName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.delete(logProfileName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Void>>>() {
                @Override
                public Observable<ServiceResponse<Void>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<Void> clientResponse = deleteDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<Void> deleteDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<Void, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<Void>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LogProfileResourceInner object if successful.
     */
    public LogProfileResourceInner get(String logProfileName) {
        return getWithServiceResponseAsync(logProfileName).toBlocking().single().body();
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LogProfileResourceInner> getAsync(String logProfileName, final ServiceCallback<LogProfileResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(logProfileName), serviceCallback);
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<LogProfileResourceInner> getAsync(String logProfileName) {
        return getWithServiceResponseAsync(logProfileName).map(new Func1<ServiceResponse<LogProfileResourceInner>, LogProfileResourceInner>() {
            @Override
            public LogProfileResourceInner call(ServiceResponse<LogProfileResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets the log profile.
     *
     * @param logProfileName The name of the log profile.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<ServiceResponse<LogProfileResourceInner>> getWithServiceResponseAsync(String logProfileName) {
        if (logProfileName == null) {
            throw new IllegalArgumentException("Parameter logProfileName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.get(logProfileName, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LogProfileResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<LogProfileResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LogProfileResourceInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<LogProfileResourceInner> getDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<LogProfileResourceInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<LogProfileResourceInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LogProfileResourceInner object if successful.
     */
    public LogProfileResourceInner createOrUpdate(String logProfileName, LogProfileResourceInner parameters) {
        return createOrUpdateWithServiceResponseAsync(logProfileName, parameters).toBlocking().single().body();
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters Parameters supplied to the operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LogProfileResourceInner> createOrUpdateAsync(String logProfileName, LogProfileResourceInner parameters, final ServiceCallback<LogProfileResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(createOrUpdateWithServiceResponseAsync(logProfileName, parameters), serviceCallback);
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<LogProfileResourceInner> createOrUpdateAsync(String logProfileName, LogProfileResourceInner parameters) {
        return createOrUpdateWithServiceResponseAsync(logProfileName, parameters).map(new Func1<ServiceResponse<LogProfileResourceInner>, LogProfileResourceInner>() {
            @Override
            public LogProfileResourceInner call(ServiceResponse<LogProfileResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Create or update a log profile in Azure Monitoring REST API.
     *
     * @param logProfileName The name of the log profile.
     * @param parameters Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<ServiceResponse<LogProfileResourceInner>> createOrUpdateWithServiceResponseAsync(String logProfileName, LogProfileResourceInner parameters) {
        if (logProfileName == null) {
            throw new IllegalArgumentException("Parameter logProfileName is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        Validator.validate(parameters);
        final String apiVersion = "2016-03-01";
        return service.createOrUpdate(logProfileName, this.client.subscriptionId(), apiVersion, parameters, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LogProfileResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<LogProfileResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LogProfileResourceInner> clientResponse = createOrUpdateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<LogProfileResourceInner> createOrUpdateDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<LogProfileResourceInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<LogProfileResourceInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LogProfileResourceInner object if successful.
     */
    public LogProfileResourceInner update(String logProfileName, LogProfileResourcePatchInner logProfilesResource) {
        return updateWithServiceResponseAsync(logProfileName, logProfilesResource).toBlocking().single().body();
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource Parameters supplied to the operation.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LogProfileResourceInner> updateAsync(String logProfileName, LogProfileResourcePatchInner logProfilesResource, final ServiceCallback<LogProfileResourceInner> serviceCallback) {
        return ServiceFuture.fromResponse(updateWithServiceResponseAsync(logProfileName, logProfilesResource), serviceCallback);
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<LogProfileResourceInner> updateAsync(String logProfileName, LogProfileResourcePatchInner logProfilesResource) {
        return updateWithServiceResponseAsync(logProfileName, logProfilesResource).map(new Func1<ServiceResponse<LogProfileResourceInner>, LogProfileResourceInner>() {
            @Override
            public LogProfileResourceInner call(ServiceResponse<LogProfileResourceInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Updates an existing LogProfilesResource. To update other fields use the CreateOrUpdate method.
     *
     * @param logProfileName The name of the log profile.
     * @param logProfilesResource Parameters supplied to the operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogProfileResourceInner object
     */
    public Observable<ServiceResponse<LogProfileResourceInner>> updateWithServiceResponseAsync(String logProfileName, LogProfileResourcePatchInner logProfilesResource) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (logProfileName == null) {
            throw new IllegalArgumentException("Parameter logProfileName is required and cannot be null.");
        }
        if (logProfilesResource == null) {
            throw new IllegalArgumentException("Parameter logProfilesResource is required and cannot be null.");
        }
        Validator.validate(logProfilesResource);
        final String apiVersion = "2016-03-01";
        return service.update(this.client.subscriptionId(), logProfileName, apiVersion, logProfilesResource, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LogProfileResourceInner>>>() {
                @Override
                public Observable<ServiceResponse<LogProfileResourceInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LogProfileResourceInner> clientResponse = updateDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<LogProfileResourceInner> updateDelegate(Response<ResponseBody> response) throws ErrorResponseException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<LogProfileResourceInner, ErrorResponseException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<LogProfileResourceInner>() { }.getType())
                .registerError(ErrorResponseException.class)
                .build(response);
    }

    /**
     * List the log profiles.
     *
     * @return the PagedList<LogProfileResourceInner> object if successful.
     */
    public PagedList<LogProfileResourceInner> list() {
        PageImpl1<LogProfileResourceInner> page = new PageImpl1<>();
        page.setItems(listWithServiceResponseAsync().toBlocking().single().body());
        page.setNextPageLink(null);
        return new PagedList<LogProfileResourceInner>(page) {
            @Override
            public Page<LogProfileResourceInner> nextPage(String nextPageLink) {
                return null;
            }
        };
    }

    /**
     * List the log profiles.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<LogProfileResourceInner>> listAsync(final ServiceCallback<List<LogProfileResourceInner>> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * List the log profiles.
     *
     * @return the observable to the List&lt;LogProfileResourceInner&gt; object
     */
    public Observable<Page<LogProfileResourceInner>> listAsync() {
        return listWithServiceResponseAsync().map(new Func1<ServiceResponse<List<LogProfileResourceInner>>, Page<LogProfileResourceInner>>() {
            @Override
            public Page<LogProfileResourceInner> call(ServiceResponse<List<LogProfileResourceInner>> response) {
                PageImpl1<LogProfileResourceInner> page = new PageImpl1<>();
                page.setItems(response.body());
                return page;
            }
        });
    }

    /**
     * List the log profiles.
     *
     * @return the observable to the List&lt;LogProfileResourceInner&gt; object
     */
    public Observable<ServiceResponse<List<LogProfileResourceInner>>> listWithServiceResponseAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2016-03-01";
        return service.list(this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<List<LogProfileResourceInner>>>>() {
                @Override
                public Observable<ServiceResponse<List<LogProfileResourceInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl1<LogProfileResourceInner>> result = listDelegate(response);
                        ServiceResponse<List<LogProfileResourceInner>> clientResponse = new ServiceResponse<List<LogProfileResourceInner>>(result.body().items(), result.response());
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl1<LogProfileResourceInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl1<LogProfileResourceInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl1<LogProfileResourceInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
