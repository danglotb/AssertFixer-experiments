/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.containerinstance.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.CloudException;
import com.microsoft.rest.ServiceCallback;
import com.microsoft.rest.ServiceFuture;
import com.microsoft.rest.ServiceResponse;
import java.io.IOException;
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
 * in ContainerLogs.
 */
public class ContainerLogsInner {
    /** The Retrofit service to perform REST calls. */
    private ContainerLogsService service;
    /** The service client containing this operation class. */
    private ContainerInstanceManagementClientImpl client;

    /**
     * Initializes an instance of ContainerLogsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public ContainerLogsInner(Retrofit retrofit, ContainerInstanceManagementClientImpl client) {
        this.service = retrofit.create(ContainerLogsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for ContainerLogs to be
     * used by Retrofit to perform actually REST calls.
     */
    interface ContainerLogsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.containerinstance.ContainerLogs list" })
        @GET("subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/Microsoft.ContainerInstance/containerGroups/{containerGroupName}/containers/{containerName}/logs")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Path("resourceGroupName") String resourceGroupName, @Path("containerGroupName") String containerGroupName, @Path("containerName") String containerName, @Query("api-version") String apiVersion, @Query("tail") Integer tail, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LogsInner object if successful.
     */
    public LogsInner list(String resourceGroupName, String containerGroupName, String containerName) {
        return listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName).toBlocking().single().body();
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LogsInner> listAsync(String resourceGroupName, String containerGroupName, String containerName, final ServiceCallback<LogsInner> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName), serviceCallback);
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogsInner object
     */
    public Observable<LogsInner> listAsync(String resourceGroupName, String containerGroupName, String containerName) {
        return listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName).map(new Func1<ServiceResponse<LogsInner>, LogsInner>() {
            @Override
            public LogsInner call(ServiceResponse<LogsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogsInner object
     */
    public Observable<ServiceResponse<LogsInner>> listWithServiceResponseAsync(String resourceGroupName, String containerGroupName, String containerName) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (containerGroupName == null) {
            throw new IllegalArgumentException("Parameter containerGroupName is required and cannot be null.");
        }
        if (containerName == null) {
            throw new IllegalArgumentException("Parameter containerName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        final Integer tail = null;
        return service.list(this.client.subscriptionId(), resourceGroupName, containerGroupName, containerName, this.client.apiVersion(), tail, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LogsInner>>>() {
                @Override
                public Observable<ServiceResponse<LogsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LogsInner> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @param tail The number of lines to show from the tail of the container instance log. If not provided, all available logs are shown up to 4mb.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the LogsInner object if successful.
     */
    public LogsInner list(String resourceGroupName, String containerGroupName, String containerName, Integer tail) {
        return listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName, tail).toBlocking().single().body();
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @param tail The number of lines to show from the tail of the container instance log. If not provided, all available logs are shown up to 4mb.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<LogsInner> listAsync(String resourceGroupName, String containerGroupName, String containerName, Integer tail, final ServiceCallback<LogsInner> serviceCallback) {
        return ServiceFuture.fromResponse(listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName, tail), serviceCallback);
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @param tail The number of lines to show from the tail of the container instance log. If not provided, all available logs are shown up to 4mb.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogsInner object
     */
    public Observable<LogsInner> listAsync(String resourceGroupName, String containerGroupName, String containerName, Integer tail) {
        return listWithServiceResponseAsync(resourceGroupName, containerGroupName, containerName, tail).map(new Func1<ServiceResponse<LogsInner>, LogsInner>() {
            @Override
            public LogsInner call(ServiceResponse<LogsInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get the logs for a specified container instance.
     * Get the logs for a specified container instance in a specified resource group and container group.
     *
     * @param resourceGroupName The name of the resource group.
     * @param containerGroupName The name of the container group.
     * @param containerName The name of the container instance.
     * @param tail The number of lines to show from the tail of the container instance log. If not provided, all available logs are shown up to 4mb.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the LogsInner object
     */
    public Observable<ServiceResponse<LogsInner>> listWithServiceResponseAsync(String resourceGroupName, String containerGroupName, String containerName, Integer tail) {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (resourceGroupName == null) {
            throw new IllegalArgumentException("Parameter resourceGroupName is required and cannot be null.");
        }
        if (containerGroupName == null) {
            throw new IllegalArgumentException("Parameter containerGroupName is required and cannot be null.");
        }
        if (containerName == null) {
            throw new IllegalArgumentException("Parameter containerName is required and cannot be null.");
        }
        if (this.client.apiVersion() == null) {
            throw new IllegalArgumentException("Parameter this.client.apiVersion() is required and cannot be null.");
        }
        return service.list(this.client.subscriptionId(), resourceGroupName, containerGroupName, containerName, this.client.apiVersion(), tail, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<LogsInner>>>() {
                @Override
                public Observable<ServiceResponse<LogsInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<LogsInner> clientResponse = listDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<LogsInner> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<LogsInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<LogsInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
