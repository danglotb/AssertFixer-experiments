/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.appservice.implementation;

import retrofit2.Retrofit;
import com.google.common.reflect.TypeToken;
import com.microsoft.azure.AzureServiceFuture;
import com.microsoft.azure.CloudException;
import com.microsoft.azure.ListOperationCallback;
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
 * in TopLevelDomains.
 */
public class TopLevelDomainsInner {
    /** The Retrofit service to perform REST calls. */
    private TopLevelDomainsService service;
    /** The service client containing this operation class. */
    private WebSiteManagementClientImpl client;

    /**
     * Initializes an instance of TopLevelDomainsInner.
     *
     * @param retrofit the Retrofit instance built from a Retrofit Builder.
     * @param client the instance of the service client containing this operation class.
     */
    public TopLevelDomainsInner(Retrofit retrofit, WebSiteManagementClientImpl client) {
        this.service = retrofit.create(TopLevelDomainsService.class);
        this.client = client;
    }

    /**
     * The interface defining all the services for TopLevelDomains to be
     * used by Retrofit to perform actually REST calls.
     */
    interface TopLevelDomainsService {
        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.TopLevelDomains list" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains")
        Observable<Response<ResponseBody>> list(@Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.TopLevelDomains get" })
        @GET("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains/{name}")
        Observable<Response<ResponseBody>> get(@Path("name") String name, @Path("subscriptionId") String subscriptionId, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.TopLevelDomains listAgreements" })
        @POST("subscriptions/{subscriptionId}/providers/Microsoft.DomainRegistration/topLevelDomains/{name}/listAgreements")
        Observable<Response<ResponseBody>> listAgreements(@Path("name") String name, @Path("subscriptionId") String subscriptionId, @Body TopLevelDomainAgreementOptionInner agreementOption, @Query("api-version") String apiVersion, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.TopLevelDomains listNext" })
        @GET
        Observable<Response<ResponseBody>> listNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

        @Headers({ "Content-Type: application/json; charset=utf-8", "x-ms-logging-context: com.microsoft.azure.management.appservice.TopLevelDomains listAgreementsNext" })
        @GET
        Observable<Response<ResponseBody>> listAgreementsNext(@Url String nextUrl, @Header("accept-language") String acceptLanguage, @Header("User-Agent") String userAgent);

    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;TopLevelDomainInner&gt; object if successful.
     */
    public PagedList<TopLevelDomainInner> list() {
        ServiceResponse<Page<TopLevelDomainInner>> response = listSinglePageAsync().toBlocking().single();
        return new PagedList<TopLevelDomainInner>(response.body()) {
            @Override
            public Page<TopLevelDomainInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<TopLevelDomainInner>> listAsync(final ListOperationCallback<TopLevelDomainInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listSinglePageAsync(),
            new Func1<String, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<Page<TopLevelDomainInner>> listAsync() {
        return listWithServiceResponseAsync()
            .map(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Page<TopLevelDomainInner>>() {
                @Override
                public Page<TopLevelDomainInner> call(ServiceResponse<Page<TopLevelDomainInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listWithServiceResponseAsync() {
        return listSinglePageAsync()
            .concatMap(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(ServiceResponse<Page<TopLevelDomainInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;TopLevelDomainInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listSinglePageAsync() {
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2015-04-01";
        return service.list(this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TopLevelDomainInner>> result = listDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TopLevelDomainInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TopLevelDomainInner>> listDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<TopLevelDomainInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<TopLevelDomainInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get details of a top-level domain.
     * Get details of a top-level domain.
     *
     * @param name Name of the top-level domain.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the TopLevelDomainInner object if successful.
     */
    public TopLevelDomainInner get(String name) {
        return getWithServiceResponseAsync(name).toBlocking().single().body();
    }

    /**
     * Get details of a top-level domain.
     * Get details of a top-level domain.
     *
     * @param name Name of the top-level domain.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<TopLevelDomainInner> getAsync(String name, final ServiceCallback<TopLevelDomainInner> serviceCallback) {
        return ServiceFuture.fromResponse(getWithServiceResponseAsync(name), serviceCallback);
    }

    /**
     * Get details of a top-level domain.
     * Get details of a top-level domain.
     *
     * @param name Name of the top-level domain.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the TopLevelDomainInner object
     */
    public Observable<TopLevelDomainInner> getAsync(String name) {
        return getWithServiceResponseAsync(name).map(new Func1<ServiceResponse<TopLevelDomainInner>, TopLevelDomainInner>() {
            @Override
            public TopLevelDomainInner call(ServiceResponse<TopLevelDomainInner> response) {
                return response.body();
            }
        });
    }

    /**
     * Get details of a top-level domain.
     * Get details of a top-level domain.
     *
     * @param name Name of the top-level domain.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the TopLevelDomainInner object
     */
    public Observable<ServiceResponse<TopLevelDomainInner>> getWithServiceResponseAsync(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        final String apiVersion = "2015-04-01";
        return service.get(name, this.client.subscriptionId(), apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<TopLevelDomainInner>>>() {
                @Override
                public Observable<ServiceResponse<TopLevelDomainInner>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<TopLevelDomainInner> clientResponse = getDelegate(response);
                        return Observable.just(clientResponse);
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<TopLevelDomainInner> getDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<TopLevelDomainInner, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<TopLevelDomainInner>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param name Name of the top-level domain.
     * @param agreementOption Domain agreement options.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object if successful.
     */
    public PagedList<TldLegalAgreementInner> listAgreements(final String name, final TopLevelDomainAgreementOptionInner agreementOption) {
        ServiceResponse<Page<TldLegalAgreementInner>> response = listAgreementsSinglePageAsync(name, agreementOption).toBlocking().single();
        return new PagedList<TldLegalAgreementInner>(response.body()) {
            @Override
            public Page<TldLegalAgreementInner> nextPage(String nextPageLink) {
                return listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param name Name of the top-level domain.
     * @param agreementOption Domain agreement options.
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<TldLegalAgreementInner>> listAgreementsAsync(final String name, final TopLevelDomainAgreementOptionInner agreementOption, final ListOperationCallback<TldLegalAgreementInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listAgreementsSinglePageAsync(name, agreementOption),
            new Func1<String, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(String nextPageLink) {
                    return listAgreementsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param name Name of the top-level domain.
     * @param agreementOption Domain agreement options.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<Page<TldLegalAgreementInner>> listAgreementsAsync(final String name, final TopLevelDomainAgreementOptionInner agreementOption) {
        return listAgreementsWithServiceResponseAsync(name, agreementOption)
            .map(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Page<TldLegalAgreementInner>>() {
                @Override
                public Page<TldLegalAgreementInner> call(ServiceResponse<Page<TldLegalAgreementInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param name Name of the top-level domain.
     * @param agreementOption Domain agreement options.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsWithServiceResponseAsync(final String name, final TopLevelDomainAgreementOptionInner agreementOption) {
        return listAgreementsSinglePageAsync(name, agreementOption)
            .concatMap(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(ServiceResponse<Page<TldLegalAgreementInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAgreementsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param name Name of the top-level domain.
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param agreementOption Domain agreement options.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsSinglePageAsync(final String name, final TopLevelDomainAgreementOptionInner agreementOption) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter name is required and cannot be null.");
        }
        if (this.client.subscriptionId() == null) {
            throw new IllegalArgumentException("Parameter this.client.subscriptionId() is required and cannot be null.");
        }
        if (agreementOption == null) {
            throw new IllegalArgumentException("Parameter agreementOption is required and cannot be null.");
        }
        Validator.validate(agreementOption);
        final String apiVersion = "2015-04-01";
        return service.listAgreements(name, this.client.subscriptionId(), agreementOption, apiVersion, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TldLegalAgreementInner>> result = listAgreementsDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TldLegalAgreementInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TldLegalAgreementInner>> listAgreementsDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<TldLegalAgreementInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<TldLegalAgreementInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;TopLevelDomainInner&gt; object if successful.
     */
    public PagedList<TopLevelDomainInner> listNext(final String nextPageLink) {
        ServiceResponse<Page<TopLevelDomainInner>> response = listNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<TopLevelDomainInner>(response.body()) {
            @Override
            public Page<TopLevelDomainInner> nextPage(String nextPageLink) {
                return listNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<TopLevelDomainInner>> listNextAsync(final String nextPageLink, final ServiceFuture<List<TopLevelDomainInner>> serviceFuture, final ListOperationCallback<TopLevelDomainInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(String nextPageLink) {
                    return listNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<Page<TopLevelDomainInner>> listNextAsync(final String nextPageLink) {
        return listNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Page<TopLevelDomainInner>>() {
                @Override
                public Page<TopLevelDomainInner> call(ServiceResponse<Page<TopLevelDomainInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TopLevelDomainInner&gt; object
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listNextWithServiceResponseAsync(final String nextPageLink) {
        return listNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<TopLevelDomainInner>>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(ServiceResponse<Page<TopLevelDomainInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Get all top-level domains supported for registration.
     * Get all top-level domains supported for registration.
     *
    ServiceResponse<PageImpl<TopLevelDomainInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;TopLevelDomainInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TopLevelDomainInner>>> listNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TopLevelDomainInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TopLevelDomainInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TopLevelDomainInner>> result = listNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TopLevelDomainInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TopLevelDomainInner>> listNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<TopLevelDomainInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<TopLevelDomainInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws CloudException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object if successful.
     */
    public PagedList<TldLegalAgreementInner> listAgreementsNext(final String nextPageLink) {
        ServiceResponse<Page<TldLegalAgreementInner>> response = listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single();
        return new PagedList<TldLegalAgreementInner>(response.body()) {
            @Override
            public Page<TldLegalAgreementInner> nextPage(String nextPageLink) {
                return listAgreementsNextSinglePageAsync(nextPageLink).toBlocking().single().body();
            }
        };
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @param serviceFuture the ServiceFuture object tracking the Retrofit calls
     * @param serviceCallback the async ServiceCallback to handle successful and failed responses.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the {@link ServiceFuture} object
     */
    public ServiceFuture<List<TldLegalAgreementInner>> listAgreementsNextAsync(final String nextPageLink, final ServiceFuture<List<TldLegalAgreementInner>> serviceFuture, final ListOperationCallback<TldLegalAgreementInner> serviceCallback) {
        return AzureServiceFuture.fromPageResponse(
            listAgreementsNextSinglePageAsync(nextPageLink),
            new Func1<String, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(String nextPageLink) {
                    return listAgreementsNextSinglePageAsync(nextPageLink);
                }
            },
            serviceCallback);
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<Page<TldLegalAgreementInner>> listAgreementsNextAsync(final String nextPageLink) {
        return listAgreementsNextWithServiceResponseAsync(nextPageLink)
            .map(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Page<TldLegalAgreementInner>>() {
                @Override
                public Page<TldLegalAgreementInner> call(ServiceResponse<Page<TldLegalAgreementInner>> response) {
                    return response.body();
                }
            });
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
     * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the PagedList&lt;TldLegalAgreementInner&gt; object
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsNextWithServiceResponseAsync(final String nextPageLink) {
        return listAgreementsNextSinglePageAsync(nextPageLink)
            .concatMap(new Func1<ServiceResponse<Page<TldLegalAgreementInner>>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(ServiceResponse<Page<TldLegalAgreementInner>> page) {
                    String nextPageLink = page.body().nextPageLink();
                    if (nextPageLink == null) {
                        return Observable.just(page);
                    }
                    return Observable.just(page).concatWith(listAgreementsNextWithServiceResponseAsync(nextPageLink));
                }
            });
    }

    /**
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     * Gets all legal agreements that user needs to accept before purchasing a domain.
     *
    ServiceResponse<PageImpl<TldLegalAgreementInner>> * @param nextPageLink The NextLink from the previous successful call to List operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the PagedList&lt;TldLegalAgreementInner&gt; object wrapped in {@link ServiceResponse} if successful.
     */
    public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> listAgreementsNextSinglePageAsync(final String nextPageLink) {
        if (nextPageLink == null) {
            throw new IllegalArgumentException("Parameter nextPageLink is required and cannot be null.");
        }
        String nextUrl = String.format("%s", nextPageLink);
        return service.listAgreementsNext(nextUrl, this.client.acceptLanguage(), this.client.userAgent())
            .flatMap(new Func1<Response<ResponseBody>, Observable<ServiceResponse<Page<TldLegalAgreementInner>>>>() {
                @Override
                public Observable<ServiceResponse<Page<TldLegalAgreementInner>>> call(Response<ResponseBody> response) {
                    try {
                        ServiceResponse<PageImpl<TldLegalAgreementInner>> result = listAgreementsNextDelegate(response);
                        return Observable.just(new ServiceResponse<Page<TldLegalAgreementInner>>(result.body(), result.response()));
                    } catch (Throwable t) {
                        return Observable.error(t);
                    }
                }
            });
    }

    private ServiceResponse<PageImpl<TldLegalAgreementInner>> listAgreementsNextDelegate(Response<ResponseBody> response) throws CloudException, IOException, IllegalArgumentException {
        return this.client.restClient().responseBuilderFactory().<PageImpl<TldLegalAgreementInner>, CloudException>newInstance(this.client.serializerAdapter())
                .register(200, new TypeToken<PageImpl<TldLegalAgreementInner>>() { }.getType())
                .registerError(CloudException.class)
                .build(response);
    }

}
