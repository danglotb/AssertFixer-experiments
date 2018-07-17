/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.graphrbac.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
import com.microsoft.azure.management.graphrbac.GraphErrorException;
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
import retrofit2.http.Path;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import retrofit2.Response;
import rx.functions.Func1;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Objects.
 */
public class ObjectsInner {
    /** The Retrofit service to perform REST calls. */
    private ObjectsService service;
    /** The service client containing this operation class. */
    private GraphRbacManagementClientImpl client;

    /**
     * Initializes an instance of ObjectsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ObjectsInner(Retrofit retrofit, GraphRbacManagementClientImpl client) {
        this.service = retrofit.create(ObjectsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for Objects to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ObjectsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Objects getCurrentUser" })
        @GET("{tenantID}/me")
        Observable<Response<ResponseBody>> getCurrentUser(@Path("tenantID") String tenantID, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Objects getObjectsByObjectIds" })
        @POST("{tenantID}/getObjectsByObjectIds")
        Observable<Response<ResponseBody>> getObjectsByObjectIds(@Path("tenantID") String tenantID, @Body GetObjectsParametersInner parameters, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.graphrbac.Objects getObjectsByObjectIdsNext" })
        @GET
        Observable<Response<ResponseBody>> getObjectsByObjectIdsNext(@Url String nextUrl, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Gets the details for the currently logged-in user.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws GraphErrorException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the AADObjectInner object if successful.
     */
    public AADObjectInner getCurrentUser() {
        return getCurrentUserWithServiceResponseAsync().toBlocking().single().body();
    }

    /**
     * Gets the details for the currently logged-in user.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<AADObjectInner> getCurrentUserAsync(final ServiceCallback<AADObjectInner> serviceCallback) {
        return ServiceFuture.fromResponse(getCurrentUserWithServiceResponseAsync(), serviceCallback);
    }

    /**
     * Gets the details for the currently logged-in user.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AADObjectInner object
     */
    public Observable<AADObjectInner> getCurrentUserAsync() {
        return getCurrentUserWithServiceResponseAsync().map(new Func1<ServiceResponse<AADObjectInner>, AADObjectInner>() {
            @Override
            public AADObjectInner call(ServiceResponse<AADObjectInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Gets the details for the currently logged-in user.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the AADObjectInner object
     */
    public Observable<ServiceResponse<AADObjectInner>> getCurrentUserWithServiceResponseAsync() {
        if (this.client.tenantID() == null) {
            throw new IllegalArgumentException("Parameter this.client.tenantID() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.getCurrentUser(this.client.tenantID(), this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<AADObjectInner>>>() {
                @Override
                public Observable<ServiceResponse<AADObjectInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<AADObjectInner> clientResponse = getCurrentUserDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<AADObjectInner> getCurrentUserDelegate(Response<ResponseBody> response) throws GraphErrorException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<AADObjectInner, GraphErrorException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<AADObjectInner>() { }.getType())
                .registerError(GraphErrorException.class)
                .build(response);
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param parameters Objects filtering parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;AADObjectInner&gt; object if successful.
     */
    public PagedList<AADObjectInner> getObjectsByObjectIds(final GetObjectsParametersInner parameters) {
        ServiceResponse<Page<AADObjectInner>> response = getObjectsByObjectIdsSinglePageAsync(parameters).toBlocking().single();
        return new PagedList<AADObjectInner>(response.body()) {
            @Override
            public Page<AADObjectInner> nextPage(String nextLink) {
                return getObjectsByObjectIdsNextSinglePageAsync(nextLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param parameters Objects filtering parameters.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<AADObjectInner>> getObjectsByObjectIdsAsync(final GetObjectsParametersInner parameters, final ListOperationCallback<AADObjectInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            getObjectsByObjectIdsSinglePageAsync(parameters),
            new Func1<String, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(String nextLink) {
                    return getObjectsByObjectIdsNextSinglePageAsync(nextLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param parameters Objects filtering parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;AADObjectInner&gt; object
     */
    public Observable<Page<AADObjectInner>> getObjectsByObjectIdsAsync(final GetObjectsParametersInner parameters) {
        return getObjectsByObjectIdsWithServiceResponseAsync(parameters)
            .map(new Func1<ServiceResponse<Page<AADObjectInner>>, Page<AADObjectInner>>() {
                @Override
                public Page<AADObjectInner> call(ServiceResponse<Page<AADObjectInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param parameters Objects filtering parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;AADObjectInner&gt; object
     */
    public Observable<ServiceResponse<Page<AADObjectInner>>> getObjectsByObjectIdsWithServiceResponseAsync(final GetObjectsParametersInner parameters) {
        return getObjectsByObjectIdsSinglePageAsync(parameters)
            .concatMap(new Func1<ServiceResponse<Page<AADObjectInner>>, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(ServiceResponse<Page<AADObjectInner>> page) {
                    String nextLink = page.body().nextPageLink();
                    if (nextLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(getObjectsByObjectIdsNextWithServiceResponseAsync(nextLink));
                }
            });
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
    ServiceResponse<PageImpl<AADObjectInner>> * @param parameters Objects filtering parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;AADObjectInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<AADObjectInner>>> getObjectsByObjectIdsSinglePageAsync(final GetObjectsParametersInner parameters) {
        if (this.client.tenantID() == null) {
            throw new IllegalArgumentException("Parameter this.client.tenantID() is required and cannot be null.");
        }
        if (parameters == null) {
            throw new IllegalArgumentException("Parameter parameters is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        Validator.validate(parameters);
        return service.getObjectsByObjectIds(this.client.tenantID(), parameters, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<AADObjectInner>> result = getObjectsByObjectIdsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<AADObjectInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<AADObjectInner>> getObjectsByObjectIdsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<AADObjectInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<AADObjectInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;AADObjectInner&gt; object if successful.
     */
    public PagedList<AADObjectInner> getObjectsByObjectIdsNext(final String nextLink) {
        ServiceResponse<Page<AADObjectInner>> response = getObjectsByObjectIdsNextSinglePageAsync(nextLink).toBlocking().single();
        return new PagedList<AADObjectInner>(response.body()) {
            @Override
            public Page<AADObjectInner> nextPage(String nextLink) {
                return getObjectsByObjectIdsNextSinglePageAsync(nextLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<AADObjectInner>> getObjectsByObjectIdsNextAsync(final String nextLink, final ServiceFuture<List<AADObjectInner>> serviceFuture, final ListOperationCallback<AADObjectInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            getObjectsByObjectIdsNextSinglePageAsync(nextLink),
            new Func1<String, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(String nextLink) {
                    return getObjectsByObjectIdsNextSinglePageAsync(nextLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;AADObjectInner&gt; object
     */
    public Observable<Page<AADObjectInner>> getObjectsByObjectIdsNextAsync(final String nextLink) {
        return getObjectsByObjectIdsNextWithServiceResponseAsync(nextLink)
            .map(new Func1<ServiceResponse<Page<AADObjectInner>>, Page<AADObjectInner>>() {
                @Override
                public Page<AADObjectInner> call(ServiceResponse<Page<AADObjectInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
     * @param nextLink Next link for the list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;AADObjectInner&gt; object
     */
    public Observable<ServiceResponse<Page<AADObjectInner>>> getObjectsByObjectIdsNextWithServiceResponseAsync(final String nextLink) {
        return getObjectsByObjectIdsNextSinglePageAsync(nextLink)
            .concatMap(new Func1<ServiceResponse<Page<AADObjectInner>>, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(ServiceResponse<Page<AADObjectInner>> page) {
                    String nextLink = page.body().nextPageLink();
                    if (nextLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(getObjectsByObjectIdsNextWithServiceResponseAsync(nextLink));
                }
            });
    }

    /**
     * Gets AD group membership for the specified AD object IDs.
     *
    ServiceResponse<PageImpl<AADObjectInner>> * @param nextLink Next link for the list operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;AADObjectInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<AADObjectInner>>> getObjectsByObjectIdsNextSinglePageAsync(final String nextLink) {
        if (nextLink == null) {
            throw new IllegalArgumentException("Parameter nextLink is required and cannot be null.");
        }
        if (this.client.tenantID() == null) {
            throw new IllegalArgumentException("Parameter this.client.tenantID() is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        String nextUrl = String.format("%s/%s", this.client.tenantID(), nextLink);
        return service.getObjectsByObjectIdsNext(nextUrl, this.client.apiVersion(), this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<AADObjectInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<AADObjectInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<AADObjectInner>> result = getObjectsByObjectIdsNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<AADObjectInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<AADObjectInner>> getObjectsByObjectIdsNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<AADObjectInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<AADObjectInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
